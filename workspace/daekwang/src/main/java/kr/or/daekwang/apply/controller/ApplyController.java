package kr.or.daekwang.apply.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;

import javax.activation.CommandMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.or.daekwang.apply.model.service.ApplyService;
import kr.or.daekwang.apply.model.vo.ApplyVo;

@Controller
public class ApplyController {
	
	@Autowired
	private ApplyService applyService;
	
	/**
	 * 주보광고신청 페이지로 이동
	 * @param session
	 * @param model
	 * @return sharingAndData/weekPageApply
	 */
	@RequestMapping(value = "/weekPageApply.do")
	public String weekPageApply(HttpSession session, Model model) {
		String returnVal = null;
		
		if (session.getAttribute("loginUser") == null) {
			
			model.addAttribute("msg", "로그인 후 이용해 주세요");
			model.addAttribute("url", "forwardMain.do");
			returnVal = "common/alert";
		}else {
			
			returnVal = "sharingAndData/weekPageApply";
		}
		
		return returnVal;
	}
	
	/**
	 * 주보광고신청 insert
	 * @param model
	 * @param applyVo
	 * @return returnVal
	 */
	@RequestMapping(value = "/insertWeekPage.do", method=RequestMethod.POST)
	public String insertWeekPage(Model model, ApplyVo applyVo) {
		String returnVal = null;
		int result = applyService.insertWeekPage(applyVo);
		
		if(result != 1) {
			model.addAttribute("msg", "신청을 실패했습니다");
			model.addAttribute("url", "weekPageApply.do");
			returnVal = "common/alert";
		}else {
			returnVal = "common/main";
		}
		
		return returnVal;
	}
	
	/**
	 * 예배자료신청 페이지로 이동
	 * @param session
	 * @param model
	 * @return sharingAndData/worshipDataApply
	 */
	@RequestMapping(value = "/worshipDataApply.do")
	public String worshipDataApply(HttpSession session, Model model) {
		String returnVal = null;
		
		if (session.getAttribute("loginUser") == null) {
			
			model.addAttribute("msg", "로그인 후 이용해 주세요");
			model.addAttribute("url", "forwardMain.do");
			returnVal = "common/alert";
		}else {
			
			returnVal = "sharingAndData/worshipDataApply";
		}
		
		return returnVal;
		
	}
	
	/**
	 * 예배자료신청 insert
	 * @param model
	 * @param applyVo
	 * @param mtfRequest
	 * @param request
	 * @return returnVal
	 */
	@RequestMapping(value = "/insertWorshipData.do", method=RequestMethod.POST)
	public String insertWorshipData(Model model, ApplyVo applyVo, MultipartHttpServletRequest mtfRequest, HttpServletRequest request) {
		String returnVal = null;
		
		//파일객체생성
		MultipartFile mf = mtfRequest.getFile("file");
		
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
		String path = root + "\\uploadFile\\";
		
		//String path = tempPath;
		
		String originFileName = mf.getOriginalFilename(); // 원본 파일 명
		String ext = originFileName.substring(originFileName.lastIndexOf('.')); //확장자명 추출
        long fileSize = mf.getSize(); // 파일 사이즈
        long reFileName = System.currentTimeMillis();  // 고유 파일 명
        
        //저장될 파일 명
        String safeFile = path + reFileName + ext;
        
        
        //파일 업로드
        try {
            mf.transferTo(new File(safeFile));
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        applyVo.setAPPLY_ORFILE(originFileName);
        applyVo.setAPPLY_REFILE(Long.valueOf(reFileName).toString() + ext);
        applyVo.setUPLOAD_YYMM(format_time);
		
		int result = applyService.insertWorshipData(applyVo);
		
		if(result != 1) {
			model.addAttribute("msg", "신청을 실패했습니다");
			model.addAttribute("url", "worshipDataApply.do");
			returnVal = "common/alert";
		}else {
			returnVal = "common/main";
		}
		
		return returnVal;
	}
	
}
