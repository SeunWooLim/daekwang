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
	
	/**
	 * @return firstYouth.jsp
	 * 1청년회 페이지로 이동
	 */
	@RequestMapping(value = "/firstYouth.do")
	public String firstYouth() {
		return "nextGeneration/firstYouth";
	}
	
	/**
	 * @return secondYouth.jsp
	 * 2청년회 페이지로 이동
	 */
	@RequestMapping(value = "/secondYouth.do")
	public String secondYouth() {
		return "nextGeneration/secondYouth";
	}
	
	/**
	 * @return infants.jsp
	 * 영유아부 페이지로 이동
	 */
	@RequestMapping(value = "/infants.do")
	public String infants() {
		return "nextGeneration/infants";
	}
	
	/**
	 * @return kindergarten.jsp
	 * 유치부 페이지로 이동
	 */
	@RequestMapping(value = "/kindergarten.do")
	public String kindergarten() {
		return "nextGeneration/kindergarten";
	}
	
	/**
	 * @return lowChild.jsp
	 * 유년부 페이지로 이동
	 */
	@RequestMapping(value = "/lowChild.do")
	public String lowChild() {
		return "nextGeneration/lowChild";
	}
	
	/**
	 * @return highChild.jsp
	 * 소년부 페이지로 이동
	 */
	@RequestMapping(value = "/highChild.do")
	public String highChild() {
		return "nextGeneration/highChild";
	}
	
	/**
	 * @return middleSchool.jsp
	 * 중등부 페이지로 이동
	 */
	@RequestMapping(value = "/middleSchool.do")
	public String middleSchool() {
		return "nextGeneration/middleSchool";
	}
	
	/**
	 * @return highSchool.jsp
	 * 고등부 페이지로 이동
	 */
	@RequestMapping(value = "/highSchool.do")
	public String highSchool() {
		return "nextGeneration/highSchool";
	}
	
	/**
	 * @return mediatorPrayer.jsp
	 * 중보기도회 페이지로 이동
	 */
	@RequestMapping(value = "/mediatorPrayer.do")
	public String mediatorPrayer() {
		return "mission/mediatorPrayer";
	}
	
	/**
	 * @return christianityCulture.jsp
	 * 경기기독문화원 페이지로 이동
	 */
	@RequestMapping(value = "/christianityCulture.do")
	public String christianityCulture() {
		return "mission/christianityCulture";
	}
}
