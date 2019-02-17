package kr.or.daekwang.sermonAndPraise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.daekwang.sermonAndPraise.model.service.SermonAndPraiseService;

@Controller
public class SermonAndPraiseController {
	
	@Autowired
	private SermonAndPraiseService sermonAndPraiseService; 
	
	@RequestMapping(value = "/sundayWorship.do")
	public String sundayWorship() {
		return "sermonAndPraise/sundayWorship";
	}
	
	@RequestMapping(value = "/wednesdayWorship.do")
	public String wednesdayWorship() {
		return "sermonAndPraise/wednesdayWorship";
	}
	
	@RequestMapping(value = "/allgenWorship.do")
	public String allgenWorship() {
		return "sermonAndPraise/allgenWorship";
	}
	
	@RequestMapping(value = "/shalomChoir.do")
	public String shalomChoir() {
		return "sermonAndPraise/shalomChoir";
	}
	
	@RequestMapping(value = "/immanuelChoir.do")
	public String immanuelChoir() {
		return "sermonAndPraise/immanuelChoir";
	}
	
	@RequestMapping(value = "/unionChoir.do")
	public String unionChoir() {
		return "sermonAndPraise/unionChoir";
	}
	
	@RequestMapping(value = "/specialSong.do")
	public String speicalSong() {
		return "sermonAndPraise/specialSong";
	}
	
	@RequestMapping(value = "/specialEvent.do")
	public String specialEvent() {
		return "sermonAndPraise/specialEvent";
	}
	
	@RequestMapping(value = "/videoDetail.do")
	public String videoDetail() {
		return "sermonAndPraise/videoDetail";
	}
}
