package kr.or.daekwang.admin.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.or.daekwang.admin.model.service.AdminService;
import kr.or.daekwang.apply.model.vo.ApplyVo;
import kr.or.daekwang.board.controller.BoardController;
import kr.or.daekwang.board.model.vo.BoardVo;
import kr.or.daekwang.member.model.vo.MemberVo;
import kr.or.daekwang.nextGeneration.model.vo.NextGenerationVo;
import kr.or.daekwang.sermonAndPraise.model.vo.SermonAndPraiseVo;

@Controller
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value = "admin.do")
	public String adminHome() {
		return "admin/adminhome";
	}
	
	/**
	 * Admin - 회원 관리 페이지로 이동
	 * @param model
	 * @param memberVo
	 * @param request
	 * @return admin/memberAdmin
	 */
	@RequestMapping(value = "memberAdmin.do")
	public String memberAdmin(Model model, MemberVo memberVo, HttpServletRequest request) {
		
		// 신청자, 제목, 내용 선택
		String searchSelect = request.getParameter("searchSelect");
		// 검색어
		String searchContent = request.getParameter("searchContent");
		
		//조회할 총 갯수 map 파라미터
		HashMap<String, Object> countMap = new HashMap<String, Object>();
		countMap.put("searchSelect", searchSelect);
		countMap.put("searchContent", searchContent);
		
		//페이징 처리 된 행의 갯수
		int limit = 10;
		//페이징 처리 할 총 게시물의 갯수 조회
		int listCount = adminService.countMemberAdmin(countMap);
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
		List<ApplyVo> list = adminService.memberAdminList(map);
		
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
		
		return "admin/memberAdmin";
	}
	
	/**
	 * 회원 권한 변경 AJAX 처리
	 * @param response
	 * @param member_auth
	 * @param member_useyn
	 * @param member_no
	 * @throws IOException
	 */
	@RequestMapping(value="updateMemberAuthChange.do")
	public void updateMemberAuthChange(HttpServletResponse response, @RequestParam(value="member_auth")String member_auth, @RequestParam(value="member_useyn")String member_useyn, @RequestParam(value="member_no")String member_no) throws IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		System.out.println("member_auth : " + member_auth);
		System.out.println("member_useyn : " + member_useyn );
		System.out.println("member_no : " + member_no);

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("member_auth", member_auth);
		map.put("member_useyn", member_useyn);
		map.put("member_no", member_no);
		
		int result = adminService.updateMemberAuthChange(map);	
		
		out.println(result);
		out.flush();
		out.close();
	}
	
	/**
	 * Admin - 새가족 소개 관리 페이지로 이동
	 * @param model
	 * @param request
	 * @param boardVo
	 * @return admin/newFamilyAdmin
	 */
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
					model.addAttribute("url", "churchNoticeAdmin.do");
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
					model.addAttribute("url", "churchNoticeAdmin.do");
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
					model.addAttribute("url", "churchNoticeAdmin.do");
					return "common/alert";
				}
			//한줄삭제
			}else {
				int board_no = Integer.parseInt(request.getParameter("BOARD_NO"));
				result = adminService.deleteChurchNoticeAdmin(board_no);
				if(result == 0) {
					model.addAttribute("msg", "삭제를 실패했습니다");
					model.addAttribute("url", "churchNoticeAdmin.do");
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
	
	/**
	 * Admin - 교회 사진 관리 페이지로 이동
	 * @param model
	 * @param request
	 * @param boardVo
	 * @return admin/churchPhotoAdmin
	 */
	@RequestMapping(value = "churchPhotoAdmin.do")
	public String churchPhotoAdmin(Model model, HttpServletRequest request, BoardVo boardVo) {
		
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
					model.addAttribute("url", "churchPhotoAdmin.do");
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
					model.addAttribute("url", "churchPhotoAdmin.do");
					return "common/alert";
				}
			//한줄삭제
			}else {
				int board_no = Integer.parseInt(request.getParameter("BOARD_NO"));
				result = adminService.deletePhotoAdmin(board_no);
				if(result == 0) {
					model.addAttribute("msg", "삭제를 실패했습니다");
					model.addAttribute("url", "churchPhotoAdmin.do");
					return "common/alert";
				}
			}
		}
		
		//조회할 총 갯수 map 파라미터
		HashMap<String, Object> countMap = new HashMap<String, Object>();
		countMap.put("searchSelect", searchSelect);
		countMap.put("searchContent", searchContent);
		countMap.put("board_fg", 3);
		
		//페이징 처리 된 행의 갯수
		int limit = 10;
		//페이징 처리 할 총 게시물의 갯수 조회
		int listCount = adminService.countChurchPhotoAdmin(countMap);
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
		map.put("board_fg",3);
		
		//검색조건에 대한 조회 prameter map
		List<Map< String, Object>> list = adminService.churchPhotoAdminList(map);
		
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
	 * Admin - 교회학교 관리 페이지로 이동
	 * @param model
	 * @return admin/churchSchoolAdmin
	 */
	@RequestMapping(value = "churchSchoolAdmin.do")
	public String churchSchoolAdmin(Model model, HttpServletRequest request) {
		//기본 부서 페이지 영유아부
		int dept_no = 1;
		//수정 후 넘어오는 부서번호로 이동
		if((request.getParameter("DEPT_NO") != null)){
			dept_no = Integer.parseInt(request.getParameter("DEPT_NO"));
		}
		
		List<NextGenerationVo> schoolList = adminService.selectNextGenerationList();
		List<NextGenerationVo> youthList = adminService.selectNextGenerationYouthList();
		
		model.addAttribute("schoolList", schoolList);
		model.addAttribute("youthList", youthList);
		model.addAttribute("dept_no", dept_no);
		
		return "admin/churchSchoolAdmin";
	}
	
	/**
	 * Admin - 교회학교 정보 수정
	 * @param model
	 * @param NextGenerationVo
	 * @param mtfRequest
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "modifyChurchSchoolAdmin.do")
	public String modifyChurchSchoolAdmin(Model model, NextGenerationVo nextGenerationVo, MultipartHttpServletRequest mtfRequest, HttpServletRequest request) throws IOException {
		
		//파일객체생성(이미지파일)
		MultipartFile mf = mtfRequest.getFile("file");
		
		//파일이 들어왔다면
		if(!mf.isEmpty()) {

			//경로설정
			String root = request.getSession().getServletContext().getRealPath("resources");
			String path = root + "\\img\\deptImage\\";
			
			//기존 파일삭제
			File file = new File(path + nextGenerationVo.getDEPT_PHOTO_RENAME());
	        file.delete();
			
			//생성된 파일 객체 이미지파일로 변환
			BufferedImage image = ImageIO.read(mf.getInputStream());
			
			//파일명 설정
			String originFileName = mf.getOriginalFilename(); // 원본 파일 명
			String ext = originFileName.substring(originFileName.lastIndexOf('.')); //확장자명 추출
	        long reFileName = System.currentTimeMillis();  // 고유 파일 명
			
	        //실제 저장될 파일 명
	        String safeFile = path + reFileName + ext;
	        
	        //파일 업로드
	        try {
	        	ImageIO.write(BoardController.imageResize(image), "jpg", new File(safeFile));
	        } catch (IllegalStateException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        
	        //이미지 정보 세팅
	        nextGenerationVo.setDEPT_PHOTO_ORNAME(originFileName);
	        nextGenerationVo.setDEPT_PHOTO_RENAME(Long.valueOf(reFileName).toString() + ext);
	        
		}
		
		//이미지 & 찬양대 정보 수정
		int result = adminService.modifyChurchSchoolAdmin(nextGenerationVo);
		String returnVal = "";
		
		if(result != 0) {
			//수정후 다시 해당 부서 페이지로 가기위한 변수
			model.addAttribute("DEPT_NO", nextGenerationVo.getDEPT_NO());
			returnVal = "redirect:/churchSchoolAdmin.do";
		}else {
			model.addAttribute("msg", "수정을 실패했습니다");
			model.addAttribute("url", "churchSchoolAdmin.do");
			returnVal = "common/alert";
		}
				
		return returnVal;
	}
	
	/**
	 * Admin - 샬롬찬양대 관리 페이지로 이동
	 * @param model
	 * @param sermonAndPraiseVo
	 * @param request
	 * @return admin/shalomChoirAdmin
	 */
	@RequestMapping(value = "shalomChoirAdmin.do")
	public String shalomChoirAdmin(Model model, SermonAndPraiseVo sermonAndPraiseVo){
		
		char PRAISE_FG = '1';
		sermonAndPraiseVo = adminService.choirAdminList(PRAISE_FG);
		
		model.addAttribute("sapVo1", sermonAndPraiseVo);
		
		return "admin/shalomChoirAdmin";
	}
	
	/**
	 * Admin - 임마누엘찬양대 관리 페이지로 이동
	 * @param model
	 * @param sermonAndPraiseVo
	 * @return
	 */
	@RequestMapping(value = "immanuelChoirAdmin.do")
	public String immanuelChoirAdmin(Model model, SermonAndPraiseVo sermonAndPraiseVo) {
		
		char PRAISE_FG = '2';
		sermonAndPraiseVo = adminService.choirAdminList(PRAISE_FG);
		
		model.addAttribute("sapVo2", sermonAndPraiseVo);
		
		return "admin/immanuelChoirAdmin";
	}
	
	/**
	 * Admin - 샬롬/임마누엘 찬양대 정보 수정
	 * @param model
	 * @param sermonAndPraiseVo
	 * @param mtfRequest
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "modifyChoirAdmin.do")
	public String modifyChoirAdmin(Model model, SermonAndPraiseVo sermonAndPraiseVo, MultipartHttpServletRequest mtfRequest, HttpServletRequest request) throws IOException {
		//파일객체생성(이미지파일)
		MultipartFile mf = mtfRequest.getFile("file");
		
		//파일이 들어왔다면
		if(!mf.isEmpty()) {

			//경로설정
			String root = request.getSession().getServletContext().getRealPath("resources");
			String path = root + "\\img\\deptImage\\";
			
			//기존 파일삭제
			File file = new File(path + sermonAndPraiseVo.getPRAISE_PHOTO_RENAME());
	        file.delete();
			
			//생성된 파일 객체 이미지파일로 변환
			BufferedImage image = ImageIO.read(mf.getInputStream());
			
			//파일명 설정
			String originFileName = mf.getOriginalFilename(); // 원본 파일 명
			String ext = originFileName.substring(originFileName.lastIndexOf('.')); //확장자명 추출
	        long reFileName = System.currentTimeMillis();  // 고유 파일 명
			
	        //실제 저장될 파일 명
	        String safeFile = path + reFileName + ext;
	        
	        //파일 업로드
	        try {
	        	ImageIO.write(BoardController.imageResize(image), "jpg", new File(safeFile));
	        } catch (IllegalStateException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        
	        //이미지 정보 세팅
	        sermonAndPraiseVo.setPRAISE_PHOTO_ORNAME(originFileName);
	        sermonAndPraiseVo.setPRAISE_PHOTO_RENAME(Long.valueOf(reFileName).toString() + ext);
	        
		}
		
		//이미지 & 찬양대 정보 수정
		int result = adminService.modifyChoirAdmin(sermonAndPraiseVo);
		String returnVal = "";
		
		if(result != 0) {
			if(sermonAndPraiseVo.getPRAISE_FG() == 1) {
				returnVal = "redirect:/shalomChoirAdmin.do";
			}else {
				returnVal = "redirect:/immanuelChoirAdmin.do";
			}
		}else {
			if(sermonAndPraiseVo.getPRAISE_FG() == 1) {
				model.addAttribute("msg", "수정을 실패했습니다");
				model.addAttribute("url", "shalomChoirAdmin.do");
				returnVal = "common/alert";
			}else {
				model.addAttribute("msg", "수정을 실패했습니다");
				model.addAttribute("url", "immanuelChoirAdmin.do");
				returnVal = "common/alert";
			}
		}
		
		return returnVal;
	}
	
	@RequestMapping(value = "mainSlideAdmin.do")
	public String mainSlideAdmin() {
		
		
		
		return "admin/mainSlideAdmin";
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
	
}
