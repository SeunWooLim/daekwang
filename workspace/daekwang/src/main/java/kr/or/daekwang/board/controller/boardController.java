package kr.or.daekwang.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class boardController {
	
	@RequestMapping(value = "/newFamilyIntroducing.do")
	public String newFamilyIntroducing() {
		return "sharingAndData/newFamilyIntroducing";
	}
	
	@RequestMapping(value = "/churchNews.do")
	public String churchNews() {
		return "sharingAndData/churchNews";
	}
	
	@RequestMapping(value = "/personNews.do")
	public String personNews() {
		return "sharingAndData/personNews";
	}
	
	@RequestMapping(value = "/churchPhoto.do")
	public String churchPhoto() {
		return "sharingAndData/churchPhoto";
	}
	
	@RequestMapping(value = "/eventVideo.do")
	public String eventVideo() {
		return "sharingAndData/eventVideo";
	}
	
	@RequestMapping(value = "/flowerPhoto.do")
	public String flowerPhoto() {
		return "sharingAndData/flowerPhoto";
	}
	

}
