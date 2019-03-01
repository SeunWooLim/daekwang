package kr.or.daekwang.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	public String enroll() {
		
		return "common/main";
	}
}
