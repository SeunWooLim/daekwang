package kr.or.daekwang.sermonAndPraise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.daekwang.sermonAndPraise.model.service.SermonAndPraiseService;
import kr.or.daekwang.sermonAndPraise.model.vo.SermonAndPraiseVo;

@Controller
public class SermonAndPraiseController {
	
	@Autowired
	private SermonAndPraiseService sermonAndPraiseService; 
	
	/**
	 * 주일 낮 설교 페이지로 이동
	 * @return sermonAndPraise/sundayWorship
	 */
	@RequestMapping(value = "/sundayWorship.do")
	public String sundayWorship() {
		return "sermonAndPraise/sundayWorship";
	}
	
	/**
	 * 수요기도회 설교 페이지로 이동
	 * @return sermonAndPraise/wednesdayWorship
	 */
	@RequestMapping(value = "/wednesdayWorship.do")
	public String wednesdayWorship() {
		return "sermonAndPraise/wednesdayWorship";
	}
	
	/**
	 * 올젠워쉽 설교 페이지로 이동
	 * @return sermonAndPraise/allgenWorship
	 */
	@RequestMapping(value = "/allgenWorship.do")
	public String allgenWorship() {
		return "sermonAndPraise/allgenWorship";
	}
	
	/**
	 * 샬롬 찬양대 페이지로 이동
	 * @param model
	 * @return sermonAndPraise/shalomChoir
	 */
	@RequestMapping(value = "/shalomChoir.do")
	public String shalomChoir(Model model) {
		
		SermonAndPraiseVo sermonAndPraiseVo = sermonAndPraiseService.selectshalomChoir();
		
		model.addAttribute("sapVo1", sermonAndPraiseVo);
		
		return "sermonAndPraise/shalomChoir";
	}
	
	/**
	 * 임마누엘 찬양대 페이지로 이동
	 * @param model
	 * @return sermonAndPraise/immanuelChoir
	 */
	@RequestMapping(value = "/immanuelChoir.do")
	public String immanuelChoir(Model model) {
		
		SermonAndPraiseVo sermonAndPraiseVo = sermonAndPraiseService.selectImmanuelChoir();
		
		model.addAttribute("sapVo2", sermonAndPraiseVo);
		
		return "sermonAndPraise/immanuelChoir";
	}
	
	/**
	 * 연합찬양대 페이지로 이동
	 * @return sermonAndPraise/unionChoir
	 */
	@RequestMapping(value = "/unionChoir.do")
	public String unionChoir() {
		return "sermonAndPraise/unionChoir";
	}
	
	/**
	 * 특송 페이지로 이동
	 * @return sermonAndPraise/specialSong
	 */
	@RequestMapping(value = "/specialSong.do")
	public String speicalSong() {
		return "sermonAndPraise/specialSong";
	}
	
	/**
	 * 특별행사 페이지로 이동
	 * @return sermonAndPraise/specialEvent
	 */
	@RequestMapping(value = "/specialEvent.do")
	public String specialEvent() {
		return "sermonAndPraise/specialEvent";
	}
	
	/**
	 * 비디오 디테일 페이지로 이동
	 * @param model
	 * @param vid
	 * @param desc
	 * @param menu
	 * @param playlist
	 * @return sermonAndPraise/videoDetail
	 */
	@RequestMapping(value = "/videoDetail.do")
	public String videoDetail(Model model, @RequestParam(value="vid") String vid, @RequestParam(value="desc") String desc, @RequestParam(value="menu") String menu, @RequestParam(value="playlist") String playlist) {
		
		model.addAttribute("vid", vid);
		model.addAttribute("desc", desc);
		model.addAttribute("menu", menu);
		model.addAttribute("playlist", playlist);
		
		return "sermonAndPraise/videoDetail";
	}
	
	
	
}
