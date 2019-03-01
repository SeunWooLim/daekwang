package kr.or.daekwang.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {
	
	/**
	 * @return main.jsp
	 * 메인페이지로 이동
	 */
	@RequestMapping(value = "/forwardMain.do")
	public String forwardBoard() {
		return "common/main";
	}
	
	/**
	 * @return pastorGreeting.jsp
	 * 담임목사 인사 페이지로 이동
	 */
	@RequestMapping(value = "/pastorGreeting.do")
	public String pastorGreeting() {
		return "churchGuide/pastorGreeting";
	}
	
	/**
	 * @return churchIntrodocing.jsp
	 * 대광교회 소개 페이지로 이동
	 */
	@RequestMapping(value = "/churchIntroducing.do")
	public String churchIntrodocing() {
		return "churchGuide/churchIntroducing";
	}
	
	/**
	 * @return churchHistory.jsp
	 * 교회연혁 페이지로 이동
	 */
	@RequestMapping(value = "/churchHistory.do")
	public String churchHistory() {
		return "churchGuide/churchHistory";
	}
	
	/**
	 * @return newFamilyGuide
	 * 새가족을 위한 안내 페이지로 이동
	 */
	@RequestMapping(value = "/newFamilyGuide.do")
	public String newFamilyGuide() {
		return "churchGuide/newFamilyGuide";
	}
	
	/**
	 * @return volunteers.jsp
	 * 섬기는 사람들 페이지로 이동
	 */
	@RequestMapping(value = "/volunteers.do")
	public String volunteers() {
		return "churchGuide/volunteers";
	}
	
	/**
	 * @return worshipGuide.jsp
	 * 예배안내 페이지로 이동 
	 */
	@RequestMapping(value = "/worshipGuide.do")
	public String worshipGuide() {
		return "churchGuide/worshipGuide";
	}
	
	/**
	 * @return howToCome.jsp
	 * 찾아오시는 길 페이지로 이동
	 */
	@RequestMapping(value = "/howToCome.do")
	public String howToCome() {
		return "churchGuide/howToCome";
	}
	
	@RequestMapping(value = "/christianityCulture.do")
	public String christianityCulture() {
		return "mission/christianityCulture";
	}
	
	@RequestMapping(value = "/mediatorPrayer.do")
	public String mediatorPrayer() {
		return "mission/mediatorPrayer";
	}
	
	@RequestMapping(value = "/errorPage403.do")
	public String errorPage403() {
		return "error/403errorPage";
	}
	
	@RequestMapping(value = "/errorPage404.do")
	public String errorPage404() {
		return "error/404errorPage";
	}
	
	@RequestMapping(value = "/errorPage500.do")
	public String errorPage500() {
		return "error/500errorPage";
	}
}
