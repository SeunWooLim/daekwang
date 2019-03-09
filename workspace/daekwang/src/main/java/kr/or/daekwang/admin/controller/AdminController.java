package kr.or.daekwang.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.daekwang.admin.model.service.AdminService;

@Controller
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value = "admin.do")
	public String adminHome() {
		return "admin/adminhome";
	}
	
	@RequestMapping(value = "churchSchoolAdmin.do")
	public String churchSchoolAdmin() {
		return "admin/churchSchoolAdmin";
	}
	
	@RequestMapping(value = "churchNoticeAdmin.do")
	public String churchNoticeAdmin() {
		return "admin/churchNoticeAdmin";
	}
	
	@RequestMapping(value = "personNewsAdmin.do")
	public String personNewsAdmin() {
		return "admin/personNewsAdmin";
	}
	
	@RequestMapping(value = "churchPhotoAdmin.do")
	public String churchPhotoAdmin() {
		return "admin/churchPhotoAdmin";
	}
	
	@RequestMapping(value = "eventVideoAdmin.do")
	public String eventVideoAdmin() {
		return "admin/eventVideoAdmin";
	}
	
	@RequestMapping(value = "flowerPhotoAdmin.do")
	public String flowerPhotoAdmin() {
		return "admin/flowerPhotoAdmin";
	}
	
	@RequestMapping(value = "weekPageApplyAdmin.do")
	public String weekPageApplyAdmin() {
		return "admin/weekPageApplyAdmin";
	}
	
	@RequestMapping(value = "worshipDataApplayAdmin.do")
	public String worshipDataApplayAdmin() {
		return "admin/worshipDataApplayAdmin";
	}
	
	@RequestMapping(value = "updateDetail.do")
	public String updateDetail() {
		return "admin/updateDetail";
	}
}
