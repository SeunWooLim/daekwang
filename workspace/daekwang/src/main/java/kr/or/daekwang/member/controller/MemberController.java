package kr.or.daekwang.member.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.daekwang.member.model.service.MemberService;
import kr.or.daekwang.member.model.vo.MemberVo;
import kr.or.daekwang.member.controller.MailSend;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	/**
	 * 로그인
	 * @param member
	 * @param session
	 * @param response
	 * @return common/main
	 */
	@RequestMapping(value = "/login.do", method=RequestMethod.POST)
	public String login(MemberVo member, HttpSession session, HttpServletResponse response) {
		
		if (session.getAttribute("loginUser") != null) {
			session.removeAttribute("loginUser"); 
		}
		MemberVo loginUser = memberService.loginCheck(member);
		
		if(loginUser !=null) {
			session.setAttribute("loginUser", loginUser);
		}
		
		return "common/main";
	}
	
	/**
	 * 로그아웃
	 * @param request
	 * @return common/main
	 */
	@RequestMapping(value = "/logout.do")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		
		if(session != null) {
			session.invalidate();
		}
		
		return "common/main";
	}
	
	/**
	 * 회원가입 페이지로 이동
	 * @return member/join
	 */
	@RequestMapping(value = "/join.do")
	public String join() {
		
		return "member/join";
	}
	
	/**
	 * 회원가입 처리
	 * @param request
	 * @param model
	 * @param member
	 * @param session
	 * @return common/alert
	 */
	@RequestMapping(value = "/enroll.do")
	public String enroll(HttpServletRequest request,  Model model, MemberVo member, HttpSession session) {
		
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		String email = email1 + "@" + email2;
		member.setMEMBER_EMAIL(email);
		String returnVal = "";
		
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String phone3 = request.getParameter("phone3");
		String phone = phone1 + "-" + phone2 + "-" + phone3;
		member.setMEMBER_PHONE(phone);
		
		
		int result = memberService.enroll(member);
		
		if(result != 1) {
			model.addAttribute("msg", "회원가입에 실패 하였습니다");
			model.addAttribute("url", "join.do");
			returnVal = "common/alert";
		}else {
			model.addAttribute("msg", "회원가입이 완료 되었습니다. 가입하신 아이디로 로그인 하여 주십시오");
			model.addAttribute("url", "forwardMain.do");
			returnVal = "common/alert";
		}
		return returnVal;
	}
	
	/**
	 * 회원가입시 아이디 중복 확인
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@ResponseBody 
	@RequestMapping(value="/checkId.do",  method = RequestMethod.POST)
	public String checkId(HttpServletRequest request, Model model) throws Exception{
        String member_id = request.getParameter("inpuid");
        //member_id와 같은 행의 갯수 조회
        int rowcount = memberService.checkId(member_id);
        
        return String.valueOf(rowcount);
	}
	
	/**
	 * 아이디 찾기
	 * @param request
	 * @param model
	 * @param member
	 * @return returnVal
	 */
	@RequestMapping(value = "/findId.do")
	public String findId(HttpServletRequest request, Model model, MemberVo member) {
		
		member.setMEMBER_EMAIL(request.getParameter("MEMBER_EMAIL1") + "@" + request.getParameter("MEMBER_EMAIL2") );
		
		String temp = memberService.findId(member);
		String member_id = null;
		if(temp != null) {
			member_id = "";
			for(int i = 0; i < temp.length(); i++) {
				if(i == temp.length() - 3 || i == temp.length() - 2) {
					member_id += "*";
				}else {
					member_id += temp.charAt(i);
				}
			}
		}
		
		String returnVal = "";
		
		if(member_id != null) {
			model.addAttribute("msg", "회원님의 아이디는  " + member_id +"  입니다");
			model.addAttribute("url", "forwardMain.do");
			returnVal = "common/alert";
		}else {
			model.addAttribute("msg", "일치하는 아이디가 존재하지 않습니다.");
			model.addAttribute("url", "forwardMain.do");
			returnVal = "common/alert";
		}
		
		return returnVal;
	}
	
	/**
	 * 비밀번호 찾기
	 * @param request
	 * @param model
	 * @param member
	 * @return returnVal
	 */
	@RequestMapping(value = "/findPwd.do")
	public String findPwd(HttpServletRequest request, Model model, MemberVo member) {
		
		member.setMEMBER_EMAIL(request.getParameter("MEMBER_EMAIL1") + "@" + request.getParameter("MEMBER_EMAIL2") );
		
		int findResult = memberService.findPwd(member);
		int result = 0;
		String returnVal = null;
		String tempPwd = "";
		
		
		if(findResult != 0) {
			for(int i = 0; i < 6; i++) {
				tempPwd += (int)(Math.random() * 9) + 1;
			}
			
			member.setMEMBER_PWD(tempPwd);
			result = memberService.updateTempPwd(member);
			
			if(result != 0) {
				MailSend ms= new MailSend();
				ms.mailSend(member.getMEMBER_EMAIL(), tempPwd);
				model.addAttribute("msg", "메일이 발송되었습니다.");
				model.addAttribute("url", "forwardMain.do");
				returnVal = "common/alert";
			}else {
				model.addAttribute("msg", "등록되지 않은 아이디 또는 이메일 입니다.");
				model.addAttribute("url", "forwardMain.do");
				returnVal = "common/alert";
			}
		}else {
			model.addAttribute("msg", "등록되지 않은 아이디 또는 이메일 입니다.");
			model.addAttribute("url", "forwardMain.do");
			returnVal = "common/alert";
		}
		
		
		
		return returnVal;
		
	}
	
	/**
	 * 마이페이지 체크 로 이동
	 * @return mypage/myPageChk
	 */
	@RequestMapping(value = "/myPageChk.do")
	public String myPageChk() {
		
		
		
		return "member/myPageChk";
	}
	
	/**
	 * 마이페이지로 이동
	 * @return mypage/myPage
	 */
	@RequestMapping(value = "/myPage.do")
	public String myPage(HttpSession session, HttpServletRequest request, Model model) {
		
		//로그인 확인
		if (session.getAttribute("loginUser") != null) {
			//등록된 세션정보 가져오기
			MemberVo member = (MemberVo)session.getAttribute("loginUser");
			
			//세션정보에서 이메일 가져와서 잘라 넣기
			String email = member.getMEMBER_EMAIL();
			String[] emailVal = email.split("@");
			
			Map<String, String> map = new HashMap<String, String>();
			
			for(int i = 1; i <= emailVal.length; i++) {
				map.put("email" + i, emailVal[i - 1]);
			}
			
			String phone = member.getMEMBER_PHONE();
			String[] phoneVal = phone.split("-");
			
			for(int i = 1; i <= phoneVal.length; i++) {
				map.put("phone" + i, phoneVal[i - 1]);
			}
			
			model.addAttribute("map", map);
			model.addAttribute("member", member);
		}
		
		return "member/myPage";
	}
	
}
