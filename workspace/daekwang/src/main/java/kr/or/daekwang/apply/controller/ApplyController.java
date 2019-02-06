package kr.or.daekwang.apply.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ApplyController {
	
	@RequestMapping(value = "/weekPageApply.do")
	public String weekPageApply() {
		return "sharingAndData/weekPageApply";
	}
	
	@RequestMapping(value = "/worshipDataApply.do")
	public String worshipDataApply() {
		return "sharingAndData/worshipDataApply";
	}
}
