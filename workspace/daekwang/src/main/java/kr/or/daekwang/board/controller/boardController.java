package kr.or.daekwang.board.controller;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

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
	public String newFamilyIntroducing(Model model) {
		
		List<BoardVo> list = boardSerivce.newFamilyIntroducing();
		
		model.addAttribute("list", list);
		
		return "sharingAndData/newFamilyIntroducing";
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
		
		//경로설정
		String root = request.getSession().getServletContext().getRealPath("resources");
		String path = root + "\\uploadPhoto\\";
		
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
        
        System.out.println("boardVo : " + boardVo);
        System.out.println("photoVo : " + photoVo);
        
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
		System.out.println(boardVo);
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
		System.out.println(boardVo);
		if(boardVo.getBOARD_TITLE() != null && boardVo.getBOARD_CONTENT() != null) {
			boardSerivce.insertChurchNews(boardVo);
		}
		
		return "redirect:/churchNews.do";
	}
	
	/**
	 * 교우소식 게시판으로 이동
	 * @param model
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
	
	@RequestMapping(value = "/personNews.do")
	public String personNews(Model model) {
		
		/*List<BoardVo> list = boardSerivce.personNewsList();
		int listCount = boardSerivce.listCount();
		
		model.addAttribute("list", list);
		model.addAttribute("listCount", listCount);*/
		
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
	public String flowerPhoto(Model model) {
		
		List<BoardVo> list = boardSerivce.flowerPhotoList();
		
		model.addAttribute("list", list);
		
		return "sharingAndData/flowerPhoto";
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

		//경로설정
		String root = request.getSession().getServletContext().getRealPath("resources");
		String path = root + "\\uploadPhoto\\";
		
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
        
        System.out.println("boardVo(flower) : " + boardVo);
        System.out.println("photoVo(flower) : " + photoVo);
        
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
	
	@RequestMapping(value = "/churchPhoto.do")
	public String churchPhoto() {
		return "sharingAndData/churchPhoto";
	}
	
	@RequestMapping(value = "/churchPhotoInsert.do")
	public String churchPhotoInsert() {
		
/*		//파일객체생성
		List<MultipartFile> fileList = mtfRequest.getFiles("fileselect[]");
		System.out.println(fileList);
		//경로설정
		String root = request.getSession().getServletContext().getRealPath("resources");
		String path = root + "\\uploadPhoto\\";
		String originFileName = null ;// 원본 파일 명
        String ext = null;//확장자명
        long reFileName = 0;  // 고유 파일 명
        long fileSize = 0; // 파일 사이즈
		String safeFile = null;
		
        for (MultipartFile mf : fileList) {
            originFileName = mf.getOriginalFilename(); // 원본 파일 명
            ext = originFileName.substring(originFileName.lastIndexOf('.')); //확장자명 추출
            reFileName = System.currentTimeMillis();  // 고유 파일 명
            fileSize = mf.getSize(); // 파일 사이즈

            System.out.println("originFileName : " + originFileName);
            System.out.println("fileSize : " + fileSize);

            //저장될 파일 명
            safeFile = path + reFileName + ext;
            
            try {
                mf.transferTo(new File(safeFile));
            } catch (IllegalStateException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
        photoVo.setPHOTO_ORNAME(originFileName);
        photoVo.setPHOTO_RENAME(Long.valueOf(reFileName).toString() + ext);
        
        int result = boardSerivce.insertNewFamilyIntroducing(boardVo, photoVo);
        
        if(result != 1) {
			model.addAttribute("msg", "신청을 실패했습니다");
			model.addAttribute("url", "newFamilyIntroducing.do");
			returnVal = "common/alert";
		}else {
			returnVal = "common/main";
		}
		*/
		return "sharingAndData/churchPhotoInsert";
	}
	
	/**
	 * image resize 설정 세팅
	 * @param image
	 * @return resizeImageHintJpg
	 */
	private BufferedImage imageResize(BufferedImage image) {
		
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
    private static BufferedImage resizeImageWithHint(BufferedImage originalImage, int type, Integer IMG_WIDTH, Integer IMG_HEIGHT){
		
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
