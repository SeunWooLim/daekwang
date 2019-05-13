package kr.or.daekwang.admin.model.service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.daekwang.admin.model.dao.AdminDao;
import kr.or.daekwang.admin.model.vo.SliderVo;
import kr.or.daekwang.apply.model.vo.ApplyVo;
import kr.or.daekwang.board.model.vo.BoardVo;
import kr.or.daekwang.board.model.vo.PhotoVo;
import kr.or.daekwang.nextGeneration.model.vo.NextGenerationVo;
import kr.or.daekwang.sermonAndPraise.model.vo.SermonAndPraiseVo;

@Service("adminService")
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminDao adminDao;

	@Override
	public List<ApplyVo> weekPageApplyAdminList(HashMap<String, Object> map) {
		return adminDao.weekPageApplyAdminList(map);
	}

	@Override
	public int countWeekPageApplyAdminList(HashMap<String, Object> countMap) {
		return adminDao.countWeekPageApplyAdminList(countMap);
	}

	@Override
	public int deleteWeekPageApplyAdmin(int apply_no) {
		return adminDao.deleteWeekPageApplyAdmin(apply_no);
	}

	@Override
	public int ckDeleteWeekPageApplyAdmin(String idx) {
		String[] arrIdx = idx.toString().split(",");
		int stackNum = 0;
		int result = 0;
		
		for (int i=0; i<arrIdx.length; i++) {
			result = adminDao.ckDeleteWeekPageApplyAdmin(Integer.parseInt(arrIdx[i]));
			if(result > 0) {
				stackNum++;
			}
		}
		if(stackNum == arrIdx.length) {
			return result;
		}else {
			return 0;
		}
	}

	@Override
	public List<ApplyVo> worshipDataApplyAdminList(HashMap<String, Object> map) {
		return adminDao.worshipDataApplyAdminList(map);
	}

	@Override
	public int countWorshipDataApplyAdmin(HashMap<String, Object> countMap) {
		return adminDao.countWorshipDataApplyAdmin(countMap);
	}

	@Override
	public int deleteWorshipDataApplyAdmin(int apply_no) {
		return adminDao.deleteWorshipDataApplyAdmin(apply_no);
	}

	@Override
	public int ckDeleteWorshipDataApplyAdmin(String idx) {
		String[] arrIdx = idx.toString().split(",");
		int stackNum = 0;
		int result = 0;
		
		for (int i=0; i<arrIdx.length; i++) {
			result = adminDao.ckDeleteWorshipDataApplyAdmin(Integer.parseInt(arrIdx[i]));
			if(result > 0) {
				stackNum++;
			}
		}
		if(stackNum == arrIdx.length) {
			return result;
		}else {
			return 0;
		}
	}

	@Override
	public List<ApplyVo> personNewsAdminList(HashMap<String, Object> map) {
		return adminDao.personNewsAdminList(map);
	}

	@Override
	public int countPersonNewsAdmin(HashMap<String, Object> countMap) {
		return adminDao.countPersonNewsAdmin(countMap);
	}

	@Override
	public int deletePersonNewsAdmin(int board_no) {
		return adminDao.deletePersonNewsAdmin(board_no);
	}

	@Override
	public int ckDeletePersonNewsAdmin(String idx) {
		String[] arrIdx = idx.toString().split(",");
		int stackNum = 0;
		int result = 0;
		
		for (int i=0; i<arrIdx.length; i++) {
			result = adminDao.ckDeletePersonNewsAdmin(Integer.parseInt(arrIdx[i]));
			if(result > 0) {
				stackNum++;
			}
		}
		if(stackNum == arrIdx.length) {
			return result;
		}else {
			return 0;
		}
	}

	@Override
	public int insertPersonNewsAdmin(BoardVo boardVo) {
		return adminDao.insertPersonNewsAdmin(boardVo);
	}

	@Override
	public int updatePersonNewsAdmin(BoardVo boardVo) {
		return adminDao.updatePersonNewsAdmin(boardVo);
	}

	@Override
	public List<ApplyVo> churchNoticeAdminList(HashMap<String, Object> map) {
		return adminDao.churchNoticeAdminList(map);
	}

	@Override
	public int countChurchNoticeAdmin(HashMap<String, Object> countMap) {
		return adminDao.countChurchNoticeAdmin(countMap);
	}

	@Override
	public int deleteChurchNoticeAdmin(int board_no) {
		return adminDao.deleteChurchNoticeAdmin(board_no);
	}

	@Override
	public int ckDeleteChurchNoticeAdmin(String idx) {
		String[] arrIdx = idx.toString().split(",");
		int stackNum = 0;
		int result = 0;
		
		for (int i=0; i<arrIdx.length; i++) {
			result = adminDao.ckDeleteChurchNoticeAdmin(Integer.parseInt(arrIdx[i]));
			if(result > 0) {
				stackNum++;
			}
		}
		if(stackNum == arrIdx.length) {
			return result;
		}else {
			return 0;
		}
	}

	@Override
	public int insertChurchNoticeAdmin(BoardVo boardVo) {
		return adminDao.insertChurchNoticeAdmin(boardVo);
	}

	@Override
	public int updateChurchNoticeAdmin(BoardVo boardVo) {
		return adminDao.updateChurchNoticeAdmin(boardVo);
	}

	@Override
	public List<ApplyVo> photoAdminList(HashMap<String, Object> map) {
		return adminDao.photoAdminList(map);
	}

	@Override
	public int countPhotoAdmin(HashMap<String, Object> countMap) {
		return adminDao.countPhotoAdmin(countMap);
	}

	@Override
	public int deletePhotoAdmin(int board_no) {
		//게시판 DELETE_YN = 'Y'처리
		int deleteResult = adminDao.deletePhotoAdmin(board_no);
		int result = 0;
		
		if(deleteResult != 0 ) {
			//사진정보 DELETE_YN ='Y' 처리
			result = adminDao.deleteImagePhotoAdmin(board_no);
			//사진 DELETE_DATE 추가
			if(result != 0) {
				adminDao.insertDeleteDate(board_no);
			}
		}
		
		return result;
	}

	@Override
	public int ckDeletePhotoAdmin(String idx) {
		
		String[] arrIdx = idx.toString().split(",");
		int stackNum = 0;
		int result = 0;
		
		for (int i=0; i<arrIdx.length; i++) {
			result = adminDao.ckDeletePhotoAdmin(Integer.parseInt(arrIdx[i]));
			if(result > 0) {
				int photoResult = adminDao.deleteImagePhotoAdmin(Integer.parseInt(arrIdx[i]));
				
				if(photoResult != 0) {
					adminDao.insertDeleteDate(Integer.parseInt(arrIdx[i]));
					stackNum++;
				}
			}
		}
		
		if(stackNum == arrIdx.length) {
			return result;
		}else {
			return 0;
		}
	}

	@Override
	public int updatePhotoAdmin(BoardVo boardVo) {
		return adminDao.updatePhotoAdmin(boardVo);
	}

	@Override
	public List<ApplyVo> memberAdminList(HashMap<String, Object> map) {
		return adminDao.memberAdminList(map);
	}

	@Override
	public int countMemberAdmin(HashMap<String, Object> countMap) {
		return adminDao.countMemberAdmin(countMap);
	}
	
	@Override
	public int updateMemberAuthChange(HashMap<String, Object> map) {
		return adminDao.updateMemberAuthChange(map);
	}

	@Override
	public List<Map< String, Object>> churchPhotoAdminList(HashMap<String, Object> mapp) {
		
		//게시판 게시물 먼저 조회
		List<BoardVo> boardList = adminDao.churchPhotoBoardMap(mapp);
		//변수
		
		int board_no = 0;
		//최종 리턴 리스트
		List<Map< String, Object>> list= new ArrayList<Map< String, Object>>();

		//게시물에 사진정보 붙이기
		for(int i = 0; i < boardList.size(); i++){
			//정보담을 map
			Map<String, Object> map  = new HashMap<String, Object>();
			
			//map에 리스트 값 하나하나 담기
			map.put("BOARD_NO", boardList.get(i).getBOARD_NO());
			map.put("MEMBER_NAME", boardList.get(i).getMemberVo().getMEMBER_NAME());
			map.put("BOARD_TITLE", boardList.get(i).getBOARD_TITLE());
			map.put("BOARD_CONTENT", boardList.get(i).getBOARD_CONTENT());
			map.put("FIRST_INPUT_DATE", boardList.get(i).getFIRST_INPUT_DATE());
			map.put("RECENT_UPDATE_DATE", boardList.get(i).getRECENT_UPDATE_DATE());
			
			//각 게시물에 관련된 사진 갯수 조회
			board_no = (int) boardList.get(i).getBOARD_NO();
			int PhotoListCount = adminDao.PhotoListCount(board_no);
			
			//map에 사진 갯수 넣기
			if(PhotoListCount != 0) {
				map.put("PHOTO_COUNT", PhotoListCount);
			}
			
			//각 게시물에 관련된 사진 rename 모두 조회
			List<PhotoVo> PhotoList = adminDao.churchPhotoPhotoList(board_no);
			String temp = "";
			map.put("UPLOAD_YYMM", PhotoList.get(0).getUPLOAD_YYMM());
			//map 모든 사진 rename 넣기
			if(PhotoList != null) {
				for(int j = 1; j <= PhotoList.size(); j++) {
					temp += PhotoList.get(j-1).getPHOTO_RENAME();
					map.put("PHOTO_IMAGE" + j, PhotoList.get(j-1).getPHOTO_RENAME());
				}
				map.put("PHOTO_IMAGE", temp);
			}
			list.add(map);
		}
		
		return list;
	}

	@Override
	public int countChurchPhotoAdmin(HashMap<String, Object> countMap) {
		return adminDao.countChurchPhotoAdmin(countMap);
	}

	@Override
	public SermonAndPraiseVo choirAdminList(char PRAISE_FG) {
		return adminDao.choirAdminList(PRAISE_FG);
	}

	@Override
	public int modifyChoirAdmin(SermonAndPraiseVo sermonAndPraiseVo) {
		return adminDao.modifyChoirAdmin(sermonAndPraiseVo);
	}

	@Override
	public List<NextGenerationVo> selectNextGenerationList() {
		return adminDao.selectNextGenerationList();
	}

	@Override
	public List<NextGenerationVo> selectNextGenerationYouthList() {
		return adminDao.selectNextGenerationYouthList();
	}

	@Override
	public int modifyChurchSchoolAdmin(NextGenerationVo nextGenerationVo) {
		return adminDao.modifyChurchSchoolAdmin(nextGenerationVo);
	}

	@Override
	public List<ApplyVo> mainSlideAdminList() {
		return adminDao.mainSlideAdminList();
	}
	
	@Override
	public List<ApplyVo> mainSlideAdminList2() {
		return adminDao.mainSlideAdminList2();
	}

	@Override
	public int deleteMainSlideAdmin(int slider_no) {
		return adminDao.deleteMainSlideAdmin(slider_no);
	}

	@Override
	public int updateMainSlideAdmin(SliderVo sliderVo) {
		return adminDao.updateMainSlideAdmin(sliderVo);
	}

	@Override
	public int insertMainSlideAdmin(SliderVo sliderVo) {
		return adminDao.insertMainSlideAdmin(sliderVo);
	}
	
	@Override
	public void autoDeletePhoto() {
		
		//삭제처리된지 한달 이상 된 사진리스트 조회
		List<PhotoVo> list =  adminDao.autoDeletePhoto();

		//사진이 있으면 삭제
		if(list != null) {
			for(int i = 0; i < list.size(); i++) {
				//파일 경로
				String path = "/home/hosting_users/dlatmddn77/tomcat/webapps/upload/" + list.get(i).getUPLOAD_YYMM()  +"/" ;
				//삭제할 사진 고유명 저장
				String photo_rename = list.get(i).getPHOTO_RENAME();
				//실제 경로 저장
				String real_path = path + photo_rename;
				//파일객체 생성
				File file = new File(real_path);
				//파일삭제
		        file.delete();
		        
		        //해당 파일이 삭제된지 안된지 확인
		        boolean isExists = file.exists();
		        if(!isExists) { 
		        	//삭제되었다면 DB에서도 삭제
		        	int result = adminDao.completeDeletePhoto(photo_rename);
		        	
		        	if(result != 0) {
		        		System.out.println("delete the file.");
		        	}
		        }else { 
		        	System.out.println("No, there is not a no file."); 
	        	}

			}
		}
	}
	
}
