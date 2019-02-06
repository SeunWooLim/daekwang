package kr.or.daekwang.sermonAndPraise.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SermonAndPraiseController {
	
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
	
	@RequestMapping(value = "/speicalSong.do")
	public String speicalSong() {
		return "sermonAndPraise/speicalSong";
	}
	
	@RequestMapping(value = "/specialEvent.do")
	public String specialEvent() {
		return "sermonAndPraise/specialEvent";
	}
	
}
