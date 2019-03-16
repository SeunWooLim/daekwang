package kr.or.daekwang.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.daekwang.board.model.service.BoardService;
import kr.or.daekwang.board.model.vo.BoardVo;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardSerivce;
	
	@RequestMapping(value = "/newFamilyIntroducing.do")
	public String newFamilyIntroducing() {
		return "sharingAndData/newFamilyIntroducing";
	}
	
	@RequestMapping(value = "/churchNews.do")
	public String churchNews() {
		return "sharingAndData/churchNews";
	}
	
	@RequestMapping(value = "/churchNewsDetail.do")
	public String churchNewsDetail() {
		return "sharingAndData/churchNewsDetail";
	}
	
	@RequestMapping(value = "/personNews.do")
	public String personNews(Model model) {
		
		List<BoardVo> list = boardSerivce.personNewsList();
		int listCount = boardSerivce.listCount();
		
		model.addAttribute("list", list);
		model.addAttribute("listCount", listCount);
		
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
	
	@RequestMapping(value = "/churchNewsInsert.do")
	public String churchNewsInsert() {
		return "sharingAndData/churchNewsInsert";
	}
	
	@RequestMapping(value = "/personNewsInsert.do")
	public String personNewsInsert() {
		return "sharingAndData/personNewsInsert";
	}
	
	@RequestMapping(value = "/newFamilyIntroducingInsert.do")
	public String newFamilyIntroducingInsert() {
		return "sharingAndData/newFamilyIntroducingInsert";
	}
	
	@RequestMapping(value = "/churchPhotoInsert.do")
	public String churchPhotoInsert() {
		return "sharingAndData/churchPhotoInsert";
	}
	
	@RequestMapping(value = "/flowerPhotoInsert.do")
	public String flowerPhotoInsert() {
		return "sharingAndData/flowerPhotoInsert";
	}
	
	

	

}
