package kr.or.daekwang.board.controller;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.or.daekwang.apply.model.vo.ApplyVo;
import kr.or.daekwang.board.model.service.BoardService;
import kr.or.daekwang.board.model.vo.BoardVo;
import kr.or.daekwang.board.model.vo.PhotoVo;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardSerivce;
	
	/**
	 * 새가족 소개 게시판으로 이동
	 * @param model
	 * @return sharingAndData/newFamilyIntroducing
	 */
	@RequestMapping(value = "/newFamilyIntroducing.do")
	public String newFamilyIntroducing(HttpServletRequest request) {
		return "sharingAndData/newFamilyIntroducing";
	}
	
	/**
	 * 새가족 게시판 AJAX 무한스크롤 조회
	 * @param model
	 * @param response
	 * @param pageNum
	 * @throws IOException
	 */
	@RequestMapping(value = "/addNewFamilyIntroducing.do")
	public void addNewFamilyIntroducing(Model model, HttpServletResponse response, @RequestParam(value="pageNum")int pageNum) throws IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		JSONObject job = new JSONObject();
		JSONArray jarr = new JSONArray();
		
		int endRow = pageNum * 10;
		List<BoardVo> list = boardSerivce.newFamilyIntroducing(endRow);
		
		for(BoardVo board : list) {
			JSONObject job2 = new JSONObject();
			job2.put("board_no", board.getBOARD_NO());
			job2.put("member_name", board.getMemberVo().getMEMBER_NAME());
			job2.put("board_title", board.getBOARD_TITLE());
			job2.put("board_content", board.getBOARD_CONTENT());
			job2.put("recent_update_date", board.getRECENT_UPDATE_DATE().toString());
			job2.put("photo_rename", board.getPhotoVo().getPHOTO_RENAME());
			job2.put("upload_yymm", board.getPhotoVo().getUPLOAD_YYMM());
			jarr.add(job2);
		}
		job.put("newFamilyIntroducing", jarr);
		
		out.println(job.toJSONString());
		out.flush();
		out.close();
	}
	
	/**
	 * 새가족 소개 등록 페이지로 이동
	 * @return sharingAndData/newFamilyIntroducingInsert
	 */
	@RequestMapping(value = "/newFamilyIntroducingInsert.do")
	public String newFamilyIntroducingInsert() {
		return "sharingAndData/newFamilyIntroducingInsert";
		//return "sharingAndData/dragAndDrop";
	}
	
	/**
	 * 새가족 소개 게시물 insert
	 * @param model
	 * @param boardVo
	 * @param photoVo
	 * @param mtfRequest
	 * @param request
	 * @return redirect:/newFamilyIntroducing.do
	 * @throws IOException 
	 */
	@RequestMapping(value = "/insertNewFamilyIntroducing.do", method=RequestMethod.POST)
	public String insertNewFamilyIntroducing(Model model, BoardVo boardVo, PhotoVo photoVo, MultipartHttpServletRequest mtfRequest, HttpServletRequest request) throws IOException {
		String returnVal = null;
		
		//파일객체생성(이미지파일)
		MultipartFile mf = mtfRequest.getFile("file");
		//생성된 파일 객체 이미지파일로 변환
		BufferedImage image = ImageIO.read(mf.getInputStream());
		
		//폴더를 만들기 위한 현재 년월 가져오기
		SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM");
		Calendar time = Calendar.getInstance();
		String format_time = format.format(time.getTime());
		
		//실제 카페24 운영서버 경로
		//폴더생성
		/*String tempPath = "/home/hosting_users/dlatmddn77/tomcat/webapps/upload/" + format_time +"/" ;
		File floder = new File(tempPath);
		if (!floder.exists()) {
			try{
				floder.mkdir(); 
	        } 
	        catch(Exception e){
	        	e.getStackTrace();
			}        
		}*/
		
		//로컬서버 경로설정
		String root = request.getSession().getServletContext().getRealPath("resources");
		String path = root + "\\uploadPhoto\\";
		//String path = tempPath;
		
		//파일명 설정
		String originFileName = mf.getOriginalFilename(); // 원본 파일 명
		String ext = originFileName.substring(originFileName.lastIndexOf('.')); //확장자명 추출
        long reFileName = System.currentTimeMillis();  // 고유 파일 명
		
        //실제 저장될 파일 명
        String safeFile = path + reFileName + ext;
        
        //파일 업로드
        try {
            //mf.transferTo(new File(safeFile));
        	ImageIO.write(imageResize(image), "jpg", new File(safeFile));
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        //이미지 원본이름, 고유이름 설정
        photoVo.setPHOTO_ORNAME(originFileName);
        photoVo.setPHOTO_RENAME(Long.valueOf(reFileName).toString() + ext);
        photoVo.setUPLOAD_YYMM(format_time);
        
        //게시판 정보, 이미지정보 저장
        int result = boardSerivce.insertNewFamilyIntroducing(boardVo, photoVo);
        
        if(result != 1) {
			model.addAttribute("msg", "신청을 실패했습니다");
			model.addAttribute("url", "newFamilyIntroducing.do");
			returnVal = "common/alert";
		}else {
			returnVal = "redirect:/newFamilyIntroducing.do";
		}
   
		return returnVal;
	}
	
	/**
	 * 교회소식 게시판으로 이동
	 * @param model
	 * @param request
	 * @param boardVo
	 * @return sharingAndData/churchNews
	 */
	@RequestMapping(value = "/churchNews.do")
	public String churchNews(Model model, HttpServletRequest request, BoardVo boardVo) {
		
		// 신청자, 제목, 내용 선택
		String searchSelect = request.getParameter("searchSelect");
		// 검색어
		String searchContent = request.getParameter("searchContent");
		
		//삭제
		if(request.getParameter("deleteFlag") != null) {
			int result = 0;
			int board_no = Integer.parseInt(request.getParameter("BOARD_NO"));
			result = boardSerivce.deleteBoard(board_no);
			if(result == 0) {
				model.addAttribute("msg", "삭제를 실패했습니다");
				model.addAttribute("url", "newFamilyAdmin.do");
				return "common/alert";
			}
		}
		
		//조회할 총 갯수 map 파라미터
		HashMap<String, Object> countMap = new HashMap<String, Object>();
		countMap.put("searchSelect", searchSelect);
		countMap.put("searchContent", searchContent);
		
		//페이징 처리 된 행의 갯수
		int limit = 10;
		//페이징 처리 할 총 게시물의 갯수 조회
		int listCount = boardSerivce.countChurchNews(countMap);
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
	
	/**
	 * 교회소식 디테일 페이지로 이동
	 * @param model
	 * @param request
	 * @return sharingAndData/churchNewsDetail
	 */
	@RequestMapping(value = "/churchNewsDetail.do")
	public String churchNewsDetail(Model model, HttpServletRequest request) {
		int board_no = Integer.parseInt(request.getParameter("BOARD_NO"));
		
		if(board_no > 0) {
			boardSerivce.addChurchNewsReadCount(board_no);
		}
		BoardVo boardVo = boardSerivce.selectChurchNewsDetail(board_no);
		model.addAttribute("boardVo", boardVo);
		
		return "sharingAndData/churchNewsDetail";
	}
	
	/**
	 * 교회소식 등록 페이지로 이동
	 * @return sharingAndData/churchNewsInsert
	 */
	@RequestMapping(value = "/churchNewsInsertPage.do")
	public String churchNewsInsertPage() {
		return "sharingAndData/churchNewsInsert";
	}
	
	/**
	 * 교회소식 게시물 insert
	 * @param model
	 * @param boardVo
	 * @return redirect:/churchNews.do
	 */
	@RequestMapping(value = "/insertChurchNews.do")
	public String insertChurchNews(Model model, BoardVo boardVo) {
		if(boardVo.getBOARD_TITLE() != null && boardVo.getBOARD_CONTENT() != null) {
			boardSerivce.insertChurchNews(boardVo);
		}
		
		return "redirect:/churchNews.do";
	}
	
	
	/**
	 * 교우소식 게시판 AJAX 무한스크롤 조회
	 * @param model
	 * @param response
	 * @param pageNum
	 * @throws IOException
	 */
	@RequestMapping(value = "/addPersonNews.do")
	public void personNews(Model model, HttpServletResponse response, @RequestParam(value="pageNum")int pageNum) throws IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		JSONObject job = new JSONObject();
		JSONArray jarr = new JSONArray();
		
		int endRow = pageNum * 10;
		List<BoardVo> list = boardSerivce.personNewsList(endRow);
		int listCount = boardSerivce.listCount();
		
		for(BoardVo board : list) {
			JSONObject job2 = new JSONObject();
			job2.put("board_no", board.getBOARD_NO());
			job2.put("member_name", board.getMemberVo().getMEMBER_NAME());
			job2.put("member_no", board.getMEMBER_NO());
			job2.put("board_title", board.getBOARD_TITLE());
			job2.put("board_content", board.getBOARD_CONTENT());
			job2.put("recent_update_date", board.getRECENT_UPDATE_DATE().toString());
			jarr.add(job2);
		}
		job.put("personNewsList", jarr);
		job.put("listCount", listCount);
		
		out.println(job.toJSONString());
		out.flush();
		out.close();
	}
	
	/**
	 * 교우소식 게시판으로 이동
	 * @param model
	 * @throws IOException 
	 */
	@RequestMapping(value = "/personNews.do")
	public String personNews(Model model, HttpServletRequest request) {
		
		//삭제
		if(request.getParameter("deleteFlag") != null) {
			int result = 0;
			int board_no = Integer.parseInt(request.getParameter("BOARD_NO"));
			result = boardSerivce.deleteBoard(board_no);
			if(result == 0) {
				model.addAttribute("msg", "삭제를 실패했습니다");
				model.addAttribute("url", "newFamilyAdmin.do");
				return "common/alert";
			}
		}
		
		return "sharingAndData/personNews";
	}
	
	/** 
	 * 교우소식 등록 페이지로 이동
	 * @return sharingAndData/personNewsInsert
	 */
	@RequestMapping(value = "/personNewsInsert.do")
	public String personNewsInsert() {
		return "sharingAndData/personNewsInsert";
	}
	
	
	/**
	 * 교우소식 게시물 insert
	 * @param boardVo
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "insertPersonNews.do")
	public String insertPersonNews(BoardVo boardVo, Model model) {
		
		int result = 0;
		if(boardVo.getBOARD_TITLE() != null && boardVo.getBOARD_TITLE() != null) {
			result = boardSerivce.insertPersonNews(boardVo);
		}
		
		if(result != 0) {
			return "redirect:/personNews.do";
		}else {
			model.addAttribute("msg", "게시물 등록을 실패했습니다");
			model.addAttribute("url", "personNews.do");
			return  "common/alert";
		}
	}
	
	/**
	 * 행사 동영상 게시판으로 이동
	 * @return sharingAndData/eventVideo
	 */
	@RequestMapping(value = "/eventVideo.do")
	public String eventVideo() {
		return "sharingAndData/eventVideo";
	}
	
	/**
	 * 꽃꽂이 갤러리로 이동
	 * @return sharingAndData/flowerPhoto
	 */
	@RequestMapping(value = "/flowerPhoto.do")
	public String flowerPhoto(HttpServletRequest request) {
		return "sharingAndData/flowerPhoto";
	}
	
	/**
	 * 꽃꽂이 갤러리 게시판 AJAX 무한스크롤 조회
	 * @param model
	 * @param response
	 * @param pageNum
	 * @throws IOException
	 */
	@RequestMapping(value = "/addFlowerPhoto.do")
	public void addFlowerPhoto(Model model, HttpServletResponse response, @RequestParam(value="pageNum")int pageNum) throws IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		JSONObject job = new JSONObject();
		JSONArray jarr = new JSONArray();
		
		int endRow = pageNum * 10;
		List<BoardVo> list = boardSerivce.flowerPhotoList(endRow);
		
		for(BoardVo board : list) {
			JSONObject job2 = new JSONObject();
			job2.put("board_no", board.getBOARD_NO());
			job2.put("member_name", board.getMemberVo().getMEMBER_NAME());
			job2.put("board_title", board.getBOARD_TITLE());
			job2.put("board_content", board.getBOARD_CONTENT());
			job2.put("recent_update_date", board.getRECENT_UPDATE_DATE().toString());
			job2.put("photo_rename", board.getPhotoVo().getPHOTO_RENAME());
			job2.put("upload_yymm", board.getPhotoVo().getUPLOAD_YYMM());
			jarr.add(job2);
		}
		job.put("flowerPhoto", jarr);
		
		out.println(job.toJSONString());
		out.flush();
		out.close();
	}
	
	/**
	 * 꽃꽂이 갤러리 등록 페이지로 이동
	 * @return sharingAndData/flowerPhotoInsert
	 */
	@RequestMapping(value = "/flowerPhotoInsert.do")
	public String flowerPhotoInsert() {
		return "sharingAndData/flowerPhotoInsert";
	}
	
	/**
	 * 꽃꽂이 갤러리 게시물 insert
	 * @return redirect:/flowerPhoto.do
	 * @throws IOException 
	 */
	@RequestMapping(value = "/insertFlowerPhoto.do")
	public String insertFlowerPhoto(Model model, BoardVo boardVo, PhotoVo photoVo, MultipartHttpServletRequest mtfRequest, HttpServletRequest request) throws IOException {
		String returnVal = null;
		
		//파일객체생성
		MultipartFile mf = mtfRequest.getFile("file");
		//생성된 파일 객체 이미지파일로 변환
		BufferedImage image = ImageIO.read(mf.getInputStream());

		//폴더를 만들기 위한 현재 년월 가져오기
		SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM");
		Calendar time = Calendar.getInstance();
		String format_time = format.format(time.getTime());
		
		//실제 카페24 운영서버 경로
		//폴더생성
		/*String tempPath = "/home/hosting_users/dlatmddn77/tomcat/webapps/upload/" + format_time +"/" ;
		File floder = new File(tempPath);
		if (!floder.exists()) {
			try{
				floder.mkdir(); 
	        } 
	        catch(Exception e){
	        	e.getStackTrace();
			}        
		}*/
		
		//로컬서버 경로설정
		String root = request.getSession().getServletContext().getRealPath("resources");
		String path = root + "\\uploadPhoto\\";
		
		//String path = tempPath;
		
		//파일명 설정
		String originFileName = mf.getOriginalFilename(); // 원본 파일 명
		String ext = originFileName.substring(originFileName.lastIndexOf('.')); //확장자명 추출
        long reFileName = System.currentTimeMillis();  // 고유 파일 명
		
        //저장될 파일 명
        String safeFile = path + reFileName + ext;
        
        //파일 업로드
        try {
            //mf.transferTo(new File(safeFile));
        	ImageIO.write(imageResize(image), "jpg", new File(safeFile));
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        //이미지 원본이름, 고유이름 설정
        photoVo.setPHOTO_ORNAME(originFileName);
        photoVo.setPHOTO_RENAME(Long.valueOf(reFileName).toString() + ext);
        photoVo.setUPLOAD_YYMM(format_time);
        
        //게시판 정보, 이미지정보 저장
        int result = boardSerivce.insertFlowerPhoto(boardVo, photoVo);
        
        if(result != 1) {
			model.addAttribute("msg", "신청을 실패했습니다");
			model.addAttribute("url", "flowerPhoto.do");
			returnVal = "common/alert";
		}else {
			returnVal = "redirect:/flowerPhoto.do";
		}
   
		return returnVal;
	}
	
	/**
	 * new 교회사진 리스트 페이지로 이동
	 * @param model
	 * @param request
	 * @param boardVo
	 * @return sharingAndData/churchPhotoNew
	 */
	@RequestMapping(value = "/churchPhotoNew.do")
	public String churchPhotoNew(Model model, HttpServletRequest request, BoardVo boardVo) {
		
		//삭제
		if(request.getParameter("deleteFlag") != null) {
			int result = 0;
			int board_no = Integer.parseInt(request.getParameter("BOARD_NO"));
			result = boardSerivce.deleteBoardAndPhoto(board_no);
			if(result == 0) {
				model.addAttribute("msg", "삭제를 실패했습니다");
				model.addAttribute("url", "newFamilyAdmin.do");
				return "common/alert";
			}
		}
		
		//페이징 처리 된 행의 갯수
		int limit = 9;
		//페이징 처리 할 총 게시물의 갯수 조회
		int listCount = boardSerivce.countChurchPhotoNew();
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
		int endRow = 9;
		//페이징 처리한 게시물의 번호
		int tableNum = listCount - (currentPage - 1)*limit;
		
		//현재 페이지에 대한 시작행부터 끝행 까지만 조회
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		
		//검색조건에 대한 조회 prameter map
		List<Map< String, Object>> list = boardSerivce.churchPhotoNewList(map);
		
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
		
		return "sharingAndData/churchPhotoNew";
	}
	
	/**
	 * new 교회사진 디테일 페이지로 이동
	 * @param boardVo
	 * @param model
	 * @return sharingAndData/churchPhotoDetail
	 */
	@RequestMapping(value = "/churchPhotoDetail.do")
	public String churchPhotoDetail(BoardVo boardVo, Model model, @RequestParam(value="currentPage")int currentPage) {
		
		List<PhotoVo> list = boardSerivce.selectChurchPhotoDetail(boardVo.getBOARD_NO());
		model.addAttribute("list", list);
		model.addAttribute("boardVo", boardVo);
		model.addAttribute("currentPage", currentPage);
		
		return "sharingAndData/churchPhotoDetail";
	}
	
	/**
	 * 교회 사진 페이지로 이동
	 * @return sharingAndData/churchPhoto
	 */
	@RequestMapping(value = "/churchPhoto.do")
	public String churchPhoto(HttpServletRequest request) {
		return "sharingAndData/churchPhoto";
	}
	
	/**
	 * 교회 사진 게시판 AJAX 무한스크롤 조회
	 * @param model
	 * @param response
	 * @param pageNum
	 * @throws IOException
	 */
	@RequestMapping(value = "/addChurchPhoto.do")
	public void addChurchPhoto(Model model, HttpServletResponse response, @RequestParam(value="pageNum")int pageNum) throws IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		JSONObject job = new JSONObject();
		JSONArray jarr = new JSONArray();
		
		int endRow = pageNum * 10;
		List<Map< String, Object>> list = boardSerivce.churchPhoto(endRow);
		
		for(int i = 0; i < list.size(); i++) {
			JSONObject job2 = new JSONObject();
			String imageName = null;
			job2.put("board_no", list.get(i).get("BOARD_NO"));
			job2.put("board_title", list.get(i).get("BOARD_TITLE"));
			job2.put("board_content", list.get(i).get("BOARD_CONTENT"));
			job2.put("recent_update_date", list.get(i).get("RECENT_UPDATE_DATE").toString());
			job2.put("photo_count", list.get(i).get("PHOTO_COUNT"));
			//job2.put("upload_yymm", list.get(i).get("UPLOAD_YYMM"));
			for(int j = 1; j <= (int)list.get(i).get("PHOTO_COUNT"); j++) {
				imageName += list.get(i).get("PHOTO_IMAGE" + j);
			}
			job2.put("photo_image", imageName);
			jarr.add(job2);
		}
		job.put("churchPhoto", jarr);
		
		out.println(job.toJSONString());
		out.flush();
		out.close();
	}
	
	/**
	 * 교회 사진 게시물 등록 페이지로 이동
	 * @return sharingAndData/churchPhotoInsert
	 */
	@RequestMapping(value = "/churchPhotoInsert.do")
	public String churchPhotoInsert() {
		return "sharingAndData/churchPhotoInsert";
	}
	
	
	/**
	 * 교회 사진 게시물 insert
	 * @param model
	 * @param mtfRequest
	 * @param request
	 * @param boardVo
	 * @param photoVo
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/insertChurchPhoto.do", method = RequestMethod.POST)
	public @ResponseBody String insertChurchPhoto(MultipartHttpServletRequest mtfRequest, HttpServletRequest request, BoardVo boardVo, PhotoVo photoVo, HttpServletResponse response)  {
		
		//파일객체생성
		List<MultipartFile> fileList = mtfRequest.getFiles("file");
		
		//폴더를 만들기 위한 현재 년월 가져오기
		SimpleDateFormat format = new SimpleDateFormat ("yyyy-MM");
		Calendar time = Calendar.getInstance();
		String format_time = format.format(time.getTime());
		
		//실제 카페24 운영서버 경로
		//폴더생성
		/*String tempPath = "/home/hosting_users/dlatmddn77/tomcat/webapps/upload/" + format_time +"/" ;
		File floder = new File(tempPath);
		if (!floder.exists()) {
			try{
				floder.mkdir(); 
	        } 
	        catch(Exception e){
	        	e.getStackTrace();
			}        
		}*/
		
		//로컬서버 경로설정
		String root = request.getSession().getServletContext().getRealPath("resources");
		String path = root + "\\uploadChurch\\";

		//String path = tempPath;
		
		//변수 설정
		String originFileName = null ;// 원본 파일 명
        String ext = null;//확장자명
        long reFileName = 0;  // 고유 파일 명
		String safeFile = null;
		int result = 0;
		
		if(fileList != null && fileList.size() > 0) {
		
			//게시판 정보 저장
			int board_no = boardSerivce.insertChurchPhotoBoardVo(boardVo);
			
	        for (MultipartFile mf : fileList) {
	        	
	        	if(!mf.isEmpty()) {
		            originFileName = mf.getOriginalFilename(); // 원본 파일 명
		            ext = originFileName.substring(originFileName.lastIndexOf('.')); //확장자명 추출
		            reFileName = System.currentTimeMillis();  // 고유 파일 명
		            
		            photoVo.setPHOTO_ORNAME(originFileName);
		            photoVo.setPHOTO_RENAME(Long.valueOf(reFileName).toString() + ext);
		            photoVo.setBOARD_NO(board_no);
		            photoVo.setMEMBER_NO(boardVo.getMEMBER_NO());
		            photoVo.setUPLOAD_YYMM(format_time);
		            
		            //사진 정보 저장
		            result = boardSerivce.insertChurchPhotoPhotoVo(photoVo);
		            
		            //저장될 파일 명
		            safeFile = path + reFileName + ext;
		            
		            try {
		            	//생성된 파일 객체 이미지파일로 변환
			    		BufferedImage image = ImageIO.read(mf.getInputStream());
		                //mf.transferTo(new File(safeFile));
		            	ImageIO.setUseCache(false);
		            	ImageIO.write(imageResize(image), "jpg", new File(safeFile));
		            	mf.getInputStream().close();
		            } catch (IllegalStateException e) {
		                // TODO Auto-generated catch block
		                e.printStackTrace();
		            } catch (IOException e) {
		                // TODO Auto-generated catch block
		                e.printStackTrace();
		            }
	        	}
	        }
		}
		String messageToReturn = ""; 
	    if (result != 0) { 
	    	messageToReturn = "success"; 
	    } else {
	    	messageToReturn = "failed"; 
	    }
		return messageToReturn;
	}

	/**
	 * image resize 설정 세팅
	 * @param image
	 * @return resizeImageHintJpg
	 */
	public BufferedImage imageResize(BufferedImage image) {
		
		Integer IMG_WIDTH = image.getWidth();
		Integer IMG_HEIGHT = image.getHeight();
		
		BufferedImage originalImage = image;
		int type = originalImage.getType() == 0? BufferedImage.TYPE_INT_ARGB : originalImage.getType();
			
		BufferedImage resizeImageHintJpg = resizeImageWithHint(originalImage, type, IMG_WIDTH, IMG_HEIGHT);
		
		return resizeImageHintJpg;
			
	}
	
    /**
     * image Resizing
     * @param originalImage
     * @param type
     * @param IMG_WIDTH
     * @param IMG_HEIGHT
     * @return resizedImage
     */
    public BufferedImage resizeImageWithHint(BufferedImage originalImage, int type, Integer IMG_WIDTH, Integer IMG_HEIGHT){
		
		BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
		g.dispose();	
		g.setComposite(AlphaComposite.Src);
	
		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		return resizedImage;
    }	
}
