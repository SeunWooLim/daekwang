package kr.or.daekwang.board.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import kr.or.daekwang.apply.model.vo.ApplyVo;
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
	public String churchNews(Model model, HttpServletRequest request, BoardVo boardVo) {
		
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
		int listCount = boardSerivce.countChurchNews(countMap);
		System.out.println("listCount : " + listCount);
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
		List<ApplyVo> list = boardSerivce.churchNewsList(map);
		
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
		
		return "sharingAndData/churchNews";
	}
	
	@RequestMapping(value = "/churchNewsDetail.do")
	public String churchNewsDetail(Model model, HttpServletRequest request) {
		int board_no = Integer.parseInt(request.getParameter("BOARD_NO"));
		
		if(board_no > 0) {
			boardSerivce.addChurchNewsReadCount(board_no);
		}
		BoardVo boardVo = boardSerivce.selectChurchNewsDetail(board_no);
		System.out.println(boardVo);
		model.addAttribute("boardVo", boardVo);
		
		return "sharingAndData/churchNewsDetail";
	}
	
	@RequestMapping(value = "/churchNewsInsertPage.do")
	public String churchNewsInsertPage() {
		return "sharingAndData/churchNewsInsert";
	}
	
	@RequestMapping(value = "/insertChurchNews.do")
	public String insertChurchNews(Model model, BoardVo boardVo) {
		System.out.println(boardVo);
		if(boardVo.getBOARD_TITLE() != null && boardVo.getBOARD_CONTENT() != null) {
			boardSerivce.insertChurchNews(boardVo);
		}
		
		return "redirect:/churchNews.do";
	}
	
	@RequestMapping(value = "/personNews.do")
	public String personNews(Model model) {
		
		List<BoardVo> list = boardSerivce.personNewsList();
		int listCount = boardSerivce.listCount();
		
		model.addAttribute("list", list);
		model.addAttribute("listCount", listCount);
		
		return "sharingAndData/personNews";
	}
	
	@RequestMapping(value = "/personNewsInsert.do")
	public String personNewsInsert() {
		return "sharingAndData/personNewsInsert";
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
