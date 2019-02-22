package kr.or.daekwang.nextGeneration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.daekwang.nextGeneration.model.service.NextGenerationService;
import kr.or.daekwang.nextGeneration.model.vo.NextGenerationVo;

@Controller
public class NextGenerationController {

	@Autowired
	private NextGenerationService nextGenerationService;
	
	@RequestMapping(value = "nextGeneration.do")
	public String nextGeneration(Model model) {
		
		List<NextGenerationVo> schoolList = nextGenerationService.selectNextGenerationList();
		List<NextGenerationVo> youthList = nextGenerationService.selectNextGenerationYouthList();
		
		model.addAttribute("schoolList", schoolList);
		model.addAttribute("youthList", youthList);
		return "nextGeneration/nextGeneration";
	}
}
