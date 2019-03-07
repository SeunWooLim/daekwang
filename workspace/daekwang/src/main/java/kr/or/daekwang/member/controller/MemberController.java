package kr.or.daekwang.member.controller;

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

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
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
	
	@RequestMapping(value = "/logout.do")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		
		if(session != null) {
			session.invalidate();
		}
		
		return "common/main";
	}
	
	@RequestMapping(value = "/join.do")
	public String join() {
		
		return "member/join";
	}
	
	@RequestMapping(value = "/enroll.do")
	public String enroll(HttpServletRequest request,  Model model, MemberVo member, HttpSession session) {
		
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		String email = email1 + "@" + email2;
		System.out.println(email);
		member.setMEMBER_EMAIL(email);
		String returnVal = null;
		
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String phone3 = request.getParameter("phone3");
		String phone = phone1 + "-" + phone2 + "-" + phone3;
		System.out.println(phone);
		member.setMEMBER_PHONE(phone);
		
		
		int result = memberService.enroll(member);
		
		if(result != 1) {
			model.addAttribute("msg", "회원가입에 실패 하였습니다");
			model.addAttribute("url", "join.do");
			returnVal = "common/alert";
		}else {
			returnVal = "common/main";
		}
		return returnVal;
	}
	
	@ResponseBody 
	@RequestMapping(value="/checkId.do",  method = RequestMethod.POST)
	public String checkId(HttpServletRequest request, Model model) throws Exception{
        String member_id = request.getParameter("inpuid");
        //member_id와 같은 행의 갯수 조회
        int rowcount = memberService.checkId(member_id);
        
        return String.valueOf(rowcount);
	}

}
