package kr.or.daekwang.apply.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.daekwang.apply.model.service.ApplyService;

@Controller
public class ApplyController {
	
	@Autowired
	private ApplyService applyService;
	
	@RequestMapping(value = "/weekPageApply.do")
	public String weekPageApply() {
		return "sharingAndData/weekPageApply";
	}
	
	@RequestMapping(value = "/worshipDataApply.do")
	public String worshipDataApply() {
		return "sharingAndData/worshipDataApply";
	}
}
