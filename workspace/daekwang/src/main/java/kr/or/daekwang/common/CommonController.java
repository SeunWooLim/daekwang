package kr.or.daekwang.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.daekwang.admin.model.service.AdminService;
import kr.or.daekwang.apply.model.vo.ApplyVo;

@Controller
public class CommonController {
	
	@Autowired
	private AdminService adminService;
	
	/**
	 * 메인페이지로 이동
	 * @return main.jsp
	 */
	@RequestMapping(value = "/forwardMain.do")
	public String forwardBoard(Model model) {
		
		//메인슬라이더 리스트 조회
		List<ApplyVo> list = adminService.mainSlideAdminList();
		List<ApplyVo> list2 = adminService.mainSlideAdminList2();
		
		model.addAttribute("wList", list);
		model.addAttribute("mList", list2);
		
		return "common/main";
	}
	
	/**
	 * 담임목사 인사 페이지로 이동
	 * @return pastorGreeting.jsp
	 */
	@RequestMapping(value = "/pastorGreeting.do")
	public String pastorGreeting() {
		return "churchGuide/pastorGreeting";
	}
	
	/**
	 * 교회비전  페이지로 이동
	 * @return churchVision.jsp
	 */
	@RequestMapping(value = "/churchVision.do")
	public String churchVision() {
		return "churchGuide/churchVision";
	}
	/**
	 * 대광교회 소개 페이지로 이동
	 * @return churchIntrodocing.jsp
	 */
	@RequestMapping(value = "/churchIntroducing.do")
	public String churchIntrodocing() {
		return "churchGuide/churchIntroducing";
	}
	
	/**
	 * 교회연혁 페이지로 이동
	 * @return churchHistory.jsp
	 */
	@RequestMapping(value = "/churchHistory.do")
	public String churchHistory() {
		return "churchGuide/churchHistory";
	}
	
	/**
	 * 새가족을 위한 안내 페이지로 이동
	 * @return newFamilyGuide
	 */
	@RequestMapping(value = "/newFamilyGuide.do")
	public String newFamilyGuide() {
		return "churchGuide/newFamilyGuide";
	}
	
	/**
	 * 섬기는 사람들 페이지로 이동
	 * @return volunteers.jsp
	 */
	@RequestMapping(value = "/volunteers.do")
	public String volunteers() {
		return "churchGuide/volunteers";
	}
	
	/**
	 * 예배안내 페이지로 이동 
	 * @return worshipGuide.jsp
	 */
	@RequestMapping(value = "/worshipGuide.do")
	public String worshipGuide() {
		return "churchGuide/worshipGuide";
	}
	
	/**
	 * 찾아오시는 길 페이지로 이동
	 * @return howToCome.jsp
	 */
	@RequestMapping(value = "/howToCome.do")
	public String howToCome() {
		return "churchGuide/howToCome";
	}
	
	/**
	 * 경기기독문화원 페이지로 이동
	 * @return mission/christianityCulture
	 */
	@RequestMapping(value = "/christianityCulture.do")
	public String christianityCulture() {
		return "mission/christianityCulture";
	}
	
	/**
	 * 중보기도회 페이지로 이동
	 * @return mission/mediatorPrayer
	 */
	@RequestMapping(value = "/mediatorPrayer.do")
	public String mediatorPrayer() {
		return "mission/mediatorPrayer";
	}
	
	/**
	 * 403에러 발생시 에러페이지로 이동
	 * @return error/403errorPage
	 */
	@RequestMapping(value = "/errorPage403.do")
	public String errorPage403() {
		return "error/403errorPage";
	}
	
	/**
	 * 404에러 발생시 에러페이지로 이동
	 * @return error/404errorPage
	 */
	@RequestMapping(value = "/errorPage404.do")
	public String errorPage404() {
		return "error/404errorPage";
	}
	
	/**
	 * 500에러 발생시 에러페이지로 이동
	 * @return error/500errorPage
	 */
	@RequestMapping(value = "/errorPage500.do")
	public String errorPage500() {
		return "error/500errorPage";
	}
	
	/**
	 * 드래그앤 드롭 테스트 페이지
	 * @return sharingAndData/dragAndDrop
	 */
	@RequestMapping(value = "/dragAndDrop.do")
	public String dragAndDrop() {
		return "sharingAndData/dragAndDrop";
	}
	
}
