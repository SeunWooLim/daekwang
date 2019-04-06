package kr.or.daekwang.admin.controller;

import java.io.File;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.daekwang.admin.model.service.AdminService;
import kr.or.daekwang.apply.model.vo.ApplyVo;
import kr.or.daekwang.board.model.vo.BoardVo;

@Controller
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value = "admin.do")
	public String adminHome() {
		return "admin/adminhome";
	}
	
	@RequestMapping(value = "memberAdmin.do")
	public String memberAdmin() {
		return "admin/memberAdmin";
	}
	
	@RequestMapping(value = "churchSchoolAdmin.do")
	public String churchSchoolAdmin() {
		return "admin/churchSchoolAdmin";
	}
	
	@RequestMapping(value = "newFamilyAdmin.do")
	public String newFamilyAdmin(Model model, HttpServletRequest request, BoardVo boardVo) {
		
		// 신청자, 제목, 내용 선택
		String searchSelect = request.getParameter("searchSelect");
		// 검색어
		String searchContent = request.getParameter("searchContent");
		
		//게시물 수정
		if(request.getParameter("updateFlag") != null) {
			int result = 0;
			if(boardVo.getBOARD_TITLE() != null && boardVo.getBOARD_CONTENT() != null) {
				result = adminService.updatePhotoAdmin(boardVo);
				if(result == 0) {
					model.addAttribute("msg", "수정을 실패했습니다");
					model.addAttribute("url", "newFamilyAdmin.do");
					return "common/alert";
				}
			}
		}
		
		//삭제
		if(request.getParameter("deleteFlag") != null) {
			int result = 0;
			//체크박스 체크된것 모두 삭제
			if(request.getParameter("idx") != null) {
				String idx = request.getParameter("idx");
				result = adminService.ckDeletePhotoAdmin(idx);
				if(result == 0) {
					model.addAttribute("msg", "삭제를 실패했습니다");
					model.addAttribute("url", "newFamilyAdmin.do");
					return "common/alert";
				}
			//한줄삭제
			}else {
				int board_no = Integer.parseInt(request.getParameter("BOARD_NO"));
				result = adminService.deletePhotoAdmin(board_no);
				if(result == 0) {
					model.addAttribute("msg", "삭제를 실패했습니다");
					model.addAttribute("url", "newFamilyAdmin.do");
					return "common/alert";
				}
			}
		}
		
		//조회할 총 갯수 map 파라미터
		HashMap<String, Object> countMap = new HashMap<String, Object>();
		countMap.put("searchSelect", searchSelect);
		countMap.put("searchContent", searchContent);
		countMap.put("board_fg", 4);
		
		//페이징 처리 된 행의 갯수
		int limit = 10;
		//페이징 처리 할 총 게시물의 갯수 조회
		int listCount = adminService.countPhotoAdmin(countMap);
		//총 페이징 갯수
		int maxPage = (int)((double)listCount / limit + 0.9);
		//현재 페이지 기본 값 1
		int currentPage = 1;
		int temp = 0;
		//화면에서 선택된 현재 페이지의 값 불러오기
		if(request.getParameter("currentPage") != null) {
			// < 버튼 눌렀을때의 처리
			if(request.getParameter("prev") != null) {
				temp = Integer.parseInt(request.getParameter("currentPage"));
				
				if(temp > 5) {
					currentPage = ((int)((temp - 1) / 5) - 1) * 5 + 1;
				}
			// > 버튼 눌렀을 때의 처리
			}else if(request.getParameter("next") != null) {
				temp = Integer.parseInt(request.getParameter("currentPage"));
				if(maxPage % 5 == 0) {
					if(temp < maxPage - ((maxPage - 1 )% 5)) {
						currentPage = ((int)((temp - 1) / 5) + 1) * 5 + 1;
					}else {
						currentPage = maxPage;
					}
				}else {
					if(temp < maxPage - ((maxPage % 5) - 1)) {
						currentPage = ((int)((temp - 1) / 5) + 1) * 5 + 1;
					}else {
						currentPage = maxPage;
					}
				}
				
			// 이외의 처리
			}else {
				currentPage = Integer.parseInt(request.getParameter("currentPage"));
			}
		}
		//화면의 시작 페이지
		int startPage = 0;
		if(currentPage % 5 != 0){
			startPage = (((int)((limit + currentPage) / 5)) -2 ) * 5 + 1;
		}else{
			startPage = currentPage - 4;
		}
		//화면의 끝 페이지
		int endPage = startPage + 4;
		//페이징의 시작 행
		int startRow = (currentPage - 1)*limit;
		//페이징의 끝 행
		int endRow = 10;
		//페이징 처리한 게시물의 번호
		int tableNum = listCount - (currentPage - 1)*limit;
		
		//현재 페이지에 대한 시작행부터 끝행 까지만 조회
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		map.put("searchSelect", searchSelect);
		map.put("searchContent", searchContent);
		map.put("board_fg", 4);
		
		//검색조건에 대한 조회 prameter map
		List<ApplyVo> list = adminService.photoAdminList(map);
		
		if(maxPage < endPage)
			endPage = maxPage;
		
		model.addAttribute("tableNum",tableNum);
		model.addAttribute("list",list);
		model.addAttribute("limit",limit);
		model.addAttribute("currentPage",currentPage);
		model.addAttribute("maxPage",maxPage);
		model.addAttribute("startPage",startPage);	
		model.addAttribute("endPage",endPage);
		model.addAttribute("startRow", startRow);
		model.addAttribute("listCount", listCount);
		model.addAttribute("searchSelect", searchSelect);
		model.addAttribute("searchContent", searchContent);
		
		return "admin/newFamilyAdmin";
	}
	
	/**
	 * Admin - 교회소식 관리 페이지로 이동
	 * @param model
	 * @param request
	 * @param boardVo
	 * @return admin/churchNoticeAdmin
	 */
	@RequestMapping(value = "churchNoticeAdmin.do")
	public String churchNoticeAdmin(Model model, HttpServletRequest request, BoardVo boardVo) {
		
		// 신청자, 제목, 내용 선택
		String searchSelect = request.getParameter("searchSelect");
		// 검색어
		String searchContent = request.getParameter("searchContent");
		
		//게시물등록
		if(request.getParameter("insertFlag") != null) {
			int result = 0;
			//폼에서 제목과 내용이 값이 있을때만 insert 실행
			if(boardVo.getBOARD_TITLE() != null && boardVo.getBOARD_CONTENT() != null) {
				result = adminService.insertChurchNoticeAdmin(boardVo);
				if(result != 1) {
					model.addAttribute("msg", "등록을 실패했습니다");
					model.addAttribute("url", "personNewsAdmin.do");
					return "common/alert";
				}
			}
		}
		
		//게시물 수정
		if(request.getParameter("updateFlag") != null) {
			int result = 0;
			if(boardVo.getBOARD_TITLE() != null && boardVo.getBOARD_CONTENT() != null) {
				result = adminService.updateChurchNoticeAdmin(boardVo);
				if(result == 0) {
					model.addAttribute("msg", "수정을 실패했습니다");
					model.addAttribute("url", "personNewsAdmin.do");
					return "common/alert";
				}
			}
		}
		
		//삭제
		if(request.getParameter("deleteFlag") != null) {
			int result = 0;
			//체크박스 체크된것 모두 삭제
			if(request.getParameter("idx") != null) {
				String idx = request.getParameter("idx");
				result = adminService.ckDeleteChurchNoticeAdmin(idx);
				if(result == 0) {
					model.addAttribute("msg", "삭제를 실패했습니다");
					model.addAttribute("url", "personNewsAdmin.do");
					return "common/alert";
				}
			//한줄삭제
			}else {
				int board_no = Integer.parseInt(request.getParameter("BOARD_NO"));
				result = adminService.deleteChurchNoticeAdmin(board_no);
				if(result == 0) {
					model.addAttribute("msg", "삭제를 실패했습니다");
					model.addAttribute("url", "personNewsAdmin.do");
					return "common/alert";
				}
			}
		}
		
		//조회할 총 갯수 map 파라미터
		HashMap<String, Object> countMap = new HashMap<String, Object>();
		countMap.put("searchSelect", searchSelect);
		countMap.put("searchContent", searchContent);
		
		//페이징 처리 된 행의 갯수
		int limit = 10;
		//페이징 처리 할 총 게시물의 갯수 조회
		int listCount = adminService.countChurchNoticeAdmin(countMap);
		//총 페이징 갯수
		int maxPage = (int)((double)listCount / limit + 0.9);
		//현재 페이지 기본 값 1
		int currentPage = 1;
		int temp = 0;
		//화면에서 선택된 현재 페이지의 값 불러오기
		if(request.getParameter("currentPage") != null) {
			// < 버튼 눌렀을때의 처리
			if(request.getParameter("prev") != null) {
				temp = Integer.parseInt(request.getParameter("currentPage"));
				
				if(temp > 5) {
					currentPage = ((int)((temp - 1) / 5) - 1) * 5 + 1;
				}
			// > 버튼 눌렀을 때의 처리
			}else if(request.getParameter("next") != null) {
				temp = Integer.parseInt(request.getParameter("currentPage"));
				if(maxPage % 5 == 0) {
					if(temp < maxPage - ((maxPage - 1 )% 5)) {
						currentPage = ((int)((temp - 1) / 5) + 1) * 5 + 1;
					}else {
						currentPage = maxPage;
					}
				}else {
					if(temp < maxPage - ((maxPage % 5) - 1)) {
						currentPage = ((int)((temp - 1) / 5) + 1) * 5 + 1;
					}else {
						currentPage = maxPage;
					}
				}
				
			// 이외의 처리
			}else {
				currentPage = Integer.parseInt(request.getParameter("currentPage"));
			}
		}
		//화면의 시작 페이지
		int startPage = 0;
		if(currentPage % 5 != 0){
			startPage = (((int)((limit + currentPage) / 5)) -2 ) * 5 + 1;
		}else{
			startPage = currentPage - 4;
		}
		//화면의 끝 페이지
		int endPage = startPage + 4;
		//페이징의 시작 행
		int startRow = (currentPage - 1)*limit;
		//페이징의 끝 행
		int endRow = 10;
		//페이징 처리한 게시물의 번호
		int tableNum = listCount - (currentPage - 1)*limit;
		
		//현재 페이지에 대한 시작행부터 끝행 까지만 조회
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		map.put("searchSelect", searchSelect);
		map.put("searchContent", searchContent);
		
		//검색조건에 대한 조회 prameter map
		List<ApplyVo> list = adminService.churchNoticeAdminList(map);
		
		if(maxPage < endPage)
			endPage = maxPage;
		
		model.addAttribute("tableNum",tableNum);
		model.addAttribute("list",list);
		model.addAttribute("limit",limit);
		model.addAttribute("currentPage",currentPage);
		model.addAttribute("maxPage",maxPage);
		model.addAttribute("startPage",startPage);	
		model.addAttribute("endPage",endPage);
		model.addAttribute("startRow", startRow);
		model.addAttribute("listCount", listCount);
		model.addAttribute("searchSelect", searchSelect);
		model.addAttribute("searchContent", searchContent);
		
		return "admin/churchNoticeAdmin";
	}
	
	/**
	 * Admin - 교우소식 관리 페이지로 이동
	 * @param model
	 * @param request
	 * @param boardVo
	 * @return admin/personNewsAdmin
	 */
	@RequestMapping(value = "personNewsAdmin.do")
	public String personNewsAdmin(Model model, HttpServletRequest request, BoardVo boardVo) {
		
		// 신청자, 제목, 내용 선택
		String searchSelect = request.getParameter("searchSelect");
		// 검색어
		String searchContent = request.getParameter("searchContent");
		
		//게시물등록
		if(request.getParameter("insertFlag") != null) {
			int result = 0;
			//폼에서 제목과 내용이 값이 있을때만 insert 실행
			if(boardVo.getBOARD_TITLE() != null && boardVo.getBOARD_CONTENT() != null) {
				result = adminService.insertPersonNewsAdmin(boardVo);
				if(result != 1) {
					model.addAttribute("msg", "등록을 실패했습니다");
					model.addAttribute("url", "personNewsAdmin.do");
					return "common/alert";
				}
			}
		}
		
		//게시물 수정
		if(request.getParameter("updateFlag") != null) {
			int result = 0;
			if(boardVo.getBOARD_TITLE() != null && boardVo.getBOARD_CONTENT() != null) {
				result = adminService.updatePersonNewsAdmin(boardVo);
				if(result == 0) {
					model.addAttribute("msg", "수정을 실패했습니다");
					model.addAttribute("url", "personNewsAdmin.do");
					return "common/alert";
				}
			}
		}
		
		//삭제
		if(request.getParameter("deleteFlag") != null) {
			int result = 0;
			//체크박스 체크된것 모두 삭제
			if(request.getParameter("idx") != null) {
				String idx = request.getParameter("idx");
				result = adminService.ckDeletePersonNewsAdmin(idx);
				if(result == 0) {
					model.addAttribute("msg", "삭제를 실패했습니다");
					model.addAttribute("url", "personNewsAdmin.do");
					return "common/alert";
				}
			//한줄삭제
			}else {
				int board_no = Integer.parseInt(request.getParameter("BOARD_NO"));
				result = adminService.deletePersonNewsAdmin(board_no);
				if(result == 0) {
					model.addAttribute("msg", "삭제를 실패했습니다");
					model.addAttribute("url", "personNewsAdmin.do");
					return "common/alert";
				}
			}
		}
		
		//조회할 총 갯수 map 파라미터
		HashMap<String, Object> countMap = new HashMap<String, Object>();
		countMap.put("searchSelect", searchSelect);
		countMap.put("searchContent", searchContent);
		
		//페이징 처리 된 행의 갯수
		int limit = 10;
		//페이징 처리 할 총 게시물의 갯수 조회
		int listCount = adminService.countPersonNewsAdmin(countMap);
		//총 페이징 갯수
		int maxPage = (int)((double)listCount / limit + 0.9);
		//현재 페이지 기본 값 1
		int currentPage = 1;
		int temp = 0;
		//화면에서 선택된 현재 페이지의 값 불러오기
		if(request.getParameter("currentPage") != null) {
			// < 버튼 눌렀을때의 처리
			if(request.getParameter("prev") != null) {
				temp = Integer.parseInt(request.getParameter("currentPage"));
				
				if(temp > 5) {
					currentPage = ((int)((temp - 1) / 5) - 1) * 5 + 1;
				}
			// > 버튼 눌렀을 때의 처리
			}else if(request.getParameter("next") != null) {
				temp = Integer.parseInt(request.getParameter("currentPage"));
				if(maxPage % 5 == 0) {
					if(temp < maxPage - ((maxPage - 1 )% 5)) {
						currentPage = ((int)((temp - 1) / 5) + 1) * 5 + 1;
					}else {
						currentPage = maxPage;
					}
				}else {
					if(temp < maxPage - ((maxPage % 5) - 1)) {
						currentPage = ((int)((temp - 1) / 5) + 1) * 5 + 1;
					}else {
						currentPage = maxPage;
					}
				}
				
			// 이외의 처리
			}else {
				currentPage = Integer.parseInt(request.getParameter("currentPage"));
			}
		}
		//화면의 시작 페이지
		int startPage = 0;
		if(currentPage % 5 != 0){
			startPage = (((int)((limit + currentPage) / 5)) -2 ) * 5 + 1;
		}else{
			startPage = currentPage - 4;
		}
		//화면의 끝 페이지
		int endPage = startPage + 4;
		//페이징의 시작 행
		int startRow = (currentPage - 1)*limit;
		//페이징의 끝 행
		int endRow = 10;
		//페이징 처리한 게시물의 번호
		int tableNum = listCount - (currentPage - 1)*limit;
		
		//현재 페이지에 대한 시작행부터 끝행 까지만 조회
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		map.put("searchSelect", searchSelect);
		map.put("searchContent", searchContent);
		
		//검색조건에 대한 조회 prameter map
		List<ApplyVo> list = adminService.personNewsAdminList(map);
		
		if(maxPage < endPage)
			endPage = maxPage;
		
		model.addAttribute("tableNum",tableNum);
		model.addAttribute("list",list);
		model.addAttribute("limit",limit);
		model.addAttribute("currentPage",currentPage);
		model.addAttribute("maxPage",maxPage);
		model.addAttribute("startPage",startPage);	
		model.addAttribute("endPage",endPage);
		model.addAttribute("startRow", startRow);
		model.addAttribute("listCount", listCount);
		model.addAttribute("searchSelect", searchSelect);
		model.addAttribute("searchContent", searchContent);
		
		return "admin/personNewsAdmin";
	}
	
	@RequestMapping(value = "churchPhotoAdmin.do")
	public String churchPhotoAdmin() {
		return "admin/churchPhotoAdmin";
	}
	
	
	/**
	 * Admin - 꽃꽂이 갤러리 관리 페이지로 이동
	 * @param model
	 * @param request
	 * @param boardVo
	 * @return
	 */
	@RequestMapping(value = "flowerPhotoAdmin.do")
	public String flowerPhotoAdmin(Model model, HttpServletRequest request, BoardVo boardVo) {
		
		// 신청자, 제목, 내용 선택
		String searchSelect = request.getParameter("searchSelect");
		// 검색어
		String searchContent = request.getParameter("searchContent");
		
		//게시물 수정
		if(request.getParameter("updateFlag") != null) {
			int result = 0;
			if(boardVo.getBOARD_TITLE() != null && boardVo.getBOARD_CONTENT() != null) {
				result = adminService.updatePhotoAdmin(boardVo);
				if(result == 0) {
					model.addAttribute("msg", "수정을 실패했습니다");
					model.addAttribute("url", "flowerPhotoAdmin.do");
					return "common/alert";
				}
			}
		}
		
		//삭제
		if(request.getParameter("deleteFlag") != null) {
			int result = 0;
			//체크박스 체크된것 모두 삭제
			if(request.getParameter("idx") != null) {
				String idx = request.getParameter("idx");
				result = adminService.ckDeletePhotoAdmin(idx);
				if(result == 0) {
					model.addAttribute("msg", "삭제를 실패했습니다");
					model.addAttribute("url", "flowerPhotoAdmin.do");
					return "common/alert";
				}
			//한줄삭제
			}else {
				int board_no = Integer.parseInt(request.getParameter("BOARD_NO"));
				result = adminService.deletePhotoAdmin(board_no);
				if(result == 0) {
					model.addAttribute("msg", "삭제를 실패했습니다");
					model.addAttribute("url", "flowerPhotoAdmin.do");
					return "common/alert";
				}
			}
		}
		
		//조회할 총 갯수 map 파라미터
		HashMap<String, Object> countMap = new HashMap<String, Object>();
		countMap.put("searchSelect", searchSelect);
		countMap.put("searchContent", searchContent);
		countMap.put("board_fg", 5);
		
		//페이징 처리 된 행의 갯수
		int limit = 10;
		//페이징 처리 할 총 게시물의 갯수 조회
		int listCount = adminService.countPhotoAdmin(countMap);
		//총 페이징 갯수
		int maxPage = (int)((double)listCount / limit + 0.9);
		//현재 페이지 기본 값 1
		int currentPage = 1;
		int temp = 0;
		//화면에서 선택된 현재 페이지의 값 불러오기
		if(request.getParameter("currentPage") != null) {
			// < 버튼 눌렀을때의 처리
			if(request.getParameter("prev") != null) {
				temp = Integer.parseInt(request.getParameter("currentPage"));
				
				if(temp > 5) {
					currentPage = ((int)((temp - 1) / 5) - 1) * 5 + 1;
				}
			// > 버튼 눌렀을 때의 처리
			}else if(request.getParameter("next") != null) {
				temp = Integer.parseInt(request.getParameter("currentPage"));
				if(maxPage % 5 == 0) {
					if(temp < maxPage - ((maxPage - 1 )% 5)) {
						currentPage = ((int)((temp - 1) / 5) + 1) * 5 + 1;
					}else {
						currentPage = maxPage;
					}
				}else {
					if(temp < maxPage - ((maxPage % 5) - 1)) {
						currentPage = ((int)((temp - 1) / 5) + 1) * 5 + 1;
					}else {
						currentPage = maxPage;
					}
				}
				
			// 이외의 처리
			}else {
				currentPage = Integer.parseInt(request.getParameter("currentPage"));
			}
		}
		//화면의 시작 페이지
		int startPage = 0;
		if(currentPage % 5 != 0){
			startPage = (((int)((limit + currentPage) / 5)) -2 ) * 5 + 1;
		}else{
			startPage = currentPage - 4;
		}
		//화면의 끝 페이지
		int endPage = startPage + 4;
		//페이징의 시작 행
		int startRow = (currentPage - 1)*limit;
		//페이징의 끝 행
		int endRow = 10;
		//페이징 처리한 게시물의 번호
		int tableNum = listCount - (currentPage - 1)*limit;
		
		//현재 페이지에 대한 시작행부터 끝행 까지만 조회
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		map.put("searchSelect", searchSelect);
		map.put("searchContent", searchContent);
		map.put("board_fg",5);
		
		//검색조건에 대한 조회 prameter map
		List<ApplyVo> list = adminService.photoAdminList(map);
		
		if(maxPage < endPage)
			endPage = maxPage;
		
		model.addAttribute("tableNum",tableNum);
		model.addAttribute("list",list);
		model.addAttribute("limit",limit);
		model.addAttribute("currentPage",currentPage);
		model.addAttribute("maxPage",maxPage);
		model.addAttribute("startPage",startPage);	
		model.addAttribute("endPage",endPage);
		model.addAttribute("startRow", startRow);
		model.addAttribute("listCount", listCount);
		model.addAttribute("searchSelect", searchSelect);
		model.addAttribute("searchContent", searchContent);
		
		return "admin/flowerPhotoAdmin";
	}
	
	
	/**
	 * Admin - 주보신청 관리 페이지로 이동
	 * @param model
	 * @param request
	 * @return admin/weekPageApplyAdmin
	 */
	@RequestMapping(value = "weekPageApplyAdmin.do")
	public String weekPageApplyAdmin(Model model, HttpServletRequest request) {
		
		// 주보원고, 광고요청 선택
		String searchSelect2 = request.getParameter("searchSelect2");
		// 신청자, 내용 선택
		String searchSelect1 = request.getParameter("searchSelect1");
		// 검색어
		String searchContent = request.getParameter("searchContent");
		
		//삭제
		if(request.getParameter("deleteFlag") != null) {
			int result = 0;
			//체크박스 체크된것 모두 삭제
			if(request.getParameter("idx") != null) {
				String idx = request.getParameter("idx");
				result = adminService.ckDeleteWeekPageApplyAdmin(idx);
				
				if(result == 0) {
					return "error/500errorPage";
				}
			//한줄삭제
			}else {
				int apply_no = Integer.parseInt(request.getParameter("APPLY_NO"));
				result = adminService.deleteWeekPageApplyAdmin(apply_no);
				if(result == 0) {
					return "error/500errorPage";
				}
			}
		}
		
		//조회할 총 갯수 map 파라미터
		HashMap<String, Object> countMap = new HashMap<String, Object>();
		countMap.put("searchSelect2", searchSelect2);
		countMap.put("searchSelect1", searchSelect1);
		countMap.put("searchContent", searchContent);
		
		//페이징 처리 된 행의 갯수
		int limit = 10;
		//페이징 처리 할 총 게시물의 갯수 조회
		int listCount = adminService.countWeekPageApplyAdminList(countMap);
		//총 페이징 갯수
		int maxPage = (int)((double)listCount / limit + 0.9);
		//현재 페이지 기본 값 1
		int currentPage = 1;
		int temp = 0;
		//화면에서 선택된 현재 페이지의 값 불러오기
		if(request.getParameter("currentPage") != null) {
			// < 버튼 눌렀을때의 처리
			if(request.getParameter("prev") != null) {
				temp = Integer.parseInt(request.getParameter("currentPage"));
				
				if(temp > 5) {
					currentPage = ((int)((temp - 1) / 5) - 1) * 5 + 1;
				}
			// > 버튼 눌렀을 때의 처리
			}else if(request.getParameter("next") != null) {
				temp = Integer.parseInt(request.getParameter("currentPage"));
				if(maxPage % 5 == 0) {
					if(temp < maxPage - ((maxPage - 1 )% 5)) {
						currentPage = ((int)((temp - 1) / 5) + 1) * 5 + 1;
					}else {
						currentPage = maxPage;
					}
				}else {
					if(temp < maxPage - ((maxPage % 5) - 1)) {
						currentPage = ((int)((temp - 1) / 5) + 1) * 5 + 1;
					}else {
						currentPage = maxPage;
					}
				}
				
			// 이외의 처리
			}else {
				currentPage = Integer.parseInt(request.getParameter("currentPage"));
			}
		}
		//화면의 시작 페이지
		int startPage = 0;
		if(currentPage % 5 != 0){
			startPage = (((int)((limit + currentPage) / 5)) -2 ) * 5 + 1;
		}else{
			startPage = currentPage - 4;
		}
		//화면의 끝 페이지
		int endPage = startPage + 4;
		//페이징의 시작 행
		int startRow = (currentPage - 1)*limit;
		//페이징의 끝 행
		int endRow = 10;
		//페이징 처리한 게시물의 번호
		int tableNum = listCount - (currentPage - 1)*limit;
		
		//현재 페이지에 대한 시작행부터 끝행 까지만 조회
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		map.put("searchSelect2", searchSelect2);
		map.put("searchSelect1", searchSelect1);
		map.put("searchContent", searchContent);
		
		//검색조건에 대한 조회 prameter map
		List<ApplyVo> list = adminService.weekPageApplyAdminList(map);
		
		if(maxPage < endPage)
			endPage = maxPage;
		
		model.addAttribute("tableNum",tableNum);
		model.addAttribute("list",list);
		model.addAttribute("limit",limit);
		model.addAttribute("currentPage",currentPage);
		model.addAttribute("maxPage",maxPage);
		model.addAttribute("startPage",startPage);
		model.addAttribute("endPage",endPage);
		model.addAttribute("startRow", startRow);
		model.addAttribute("listCount", listCount);
		model.addAttribute("searchSelect2", searchSelect2);
		model.addAttribute("searchSelect1", searchSelect1);
		model.addAttribute("searchContent", searchContent);
		
		return "admin/weekPageApplyAdmin";
	}
	
	
	/**
	 * Admin - 예배자료신청 관리 페이지로 이동
	 * @param model
	 * @param request
	 * @return admin/worshipDataApplayAdmin
	 */
	@RequestMapping(value = "worshipDataApplyAdmin.do")
	public String worshipDataApplyAdmin(Model model, HttpServletRequest request) {
		
		// 신청자, 내용 선택
		String searchSelect1 = request.getParameter("searchSelect1");
		// 검색어
		String searchContent = request.getParameter("searchContent");
		
		//삭제
		if(request.getParameter("deleteFlag") != null) {
			int result = 0;
			//체크박스 체크된것 모두 삭제
			if(request.getParameter("idx") != null) {
				String idx = request.getParameter("idx");
				result = adminService.ckDeleteWorshipDataApplyAdmin(idx);
				if(result == 0) {
					return "error/500errorPage";
				}
			//한줄삭제
			}else {
				int apply_no = Integer.parseInt(request.getParameter("APPLY_NO"));
				result = adminService.deleteWorshipDataApplyAdmin(apply_no);
				if(result == 0) {
					return "error/500errorPage";
				}
			}
		}
		
		//조회할 총 갯수 map 파라미터
		HashMap<String, Object> countMap = new HashMap<String, Object>();
		countMap.put("searchSelect1", searchSelect1);
		countMap.put("searchContent", searchContent);
		
		//페이징 처리 된 행의 갯수
		int limit = 10;
		//페이징 처리 할 총 게시물의 갯수 조회
		int listCount = adminService.countWorshipDataApplyAdmin(countMap);
		//총 페이징 갯수
		int maxPage = (int)((double)listCount / limit + 0.9);
		//현재 페이지 기본 값 1
		int currentPage = 1;
		int temp = 0;
		//화면에서 선택된 현재 페이지의 값 불러오기
		if(request.getParameter("currentPage") != null) {
			// < 버튼 눌렀을때의 처리
			if(request.getParameter("prev") != null) {
				temp = Integer.parseInt(request.getParameter("currentPage"));
				
				if(temp > 5) {
					currentPage = ((int)((temp - 1) / 5) - 1) * 5 + 1;
				}
			// > 버튼 눌렀을 때의 처리
			}else if(request.getParameter("next") != null) {
				temp = Integer.parseInt(request.getParameter("currentPage"));
				if(maxPage % 5 == 0) {
					if(temp < maxPage - ((maxPage - 1 )% 5)) {
						currentPage = ((int)((temp - 1) / 5) + 1) * 5 + 1;
					}else {
						currentPage = maxPage;
					}
				}else {
					if(temp < maxPage - ((maxPage % 5) - 1)) {
						currentPage = ((int)((temp - 1) / 5) + 1) * 5 + 1;
					}else {
						currentPage = maxPage;
					}
				}
				
			// 이외의 처리
			}else {
				currentPage = Integer.parseInt(request.getParameter("currentPage"));
			}
		}
		//화면의 시작 페이지
		int startPage = 0;
		if(currentPage % 5 != 0){
			startPage = (((int)((limit + currentPage) / 5)) -2 ) * 5 + 1;
		}else{
			startPage = currentPage - 4;
		}
		//화면의 끝 페이지
		int endPage = startPage + 4;
		//페이징의 시작 행
		int startRow = (currentPage - 1)*limit;
		//페이징의 끝 행
		int endRow = 10;
		//페이징 처리한 게시물의 번호
		int tableNum = listCount - (currentPage - 1)*limit;
		
		//현재 페이지에 대한 시작행부터 끝행 까지만 조회
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		map.put("searchSelect1", searchSelect1);
		map.put("searchContent", searchContent);
		
		//검색조건에 대한 조회 prameter map
		List<ApplyVo> list = adminService.worshipDataApplyAdminList(map);
		
		if(maxPage < endPage)
			endPage = maxPage;
		
		model.addAttribute("tableNum",tableNum);
		model.addAttribute("list",list);
		model.addAttribute("limit",limit);
		model.addAttribute("currentPage",currentPage);
		model.addAttribute("maxPage",maxPage);
		model.addAttribute("startPage",startPage);
		model.addAttribute("endPage",endPage);
		model.addAttribute("startRow", startRow);
		model.addAttribute("listCount", listCount);
		model.addAttribute("searchSelect1", searchSelect1);
		model.addAttribute("searchContent", searchContent);
		
		return "admin/worshipDataApplayAdmin";
	}
	
	/**
	 * Admin - 파일 다운로드
	 * @param response
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping(value="/downloadFile.do")
	public void downloadFile( HttpServletResponse response, HttpServletRequest request) throws Exception{	
		
		String storedFileName = request.getParameter("STORED_FILE_NAME");
		String originalFileName = request.getParameter("ORIGINAL_FILE_NAME");
		
		String root = request.getSession().getServletContext().getRealPath("resources");
		String path = root + "\\uploadFile\\";
		
		byte fileByte[] = FileUtils.readFileToByteArray(new File(path + storedFileName));
		
		response.setContentType("application/octet-stream");
		response.setContentLength(fileByte.length);
		
		response.setHeader("Content-Disposition",  "attachment;  fileName=\""  + URLEncoder.encode(originalFileName,"UTF-8")+"\";");
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		response.getOutputStream().write(fileByte);
		response.getOutputStream().flush();
		response.getOutputStream().close();
	}
	
	@RequestMapping(value = "shalomChoirAdmin.do")
	public String shalomChoirAdmin() {
		return "admin/shalomChoirAdmin";
	}
	
	@RequestMapping(value = "immanuelChoirAdmin.do")
	public String immanuelChoirAdmin() {
		return "admin/immanuelChoirAdmin";
	}
	
	@RequestMapping(value = "mainSlideAdmin.do")
	public String mainSlideAdmin() {
		return "admin/mainSlideAdmin";
	}
	
}
