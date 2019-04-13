package kr.or.daekwang.board.model.service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.daekwang.apply.model.vo.ApplyVo;
import kr.or.daekwang.board.model.dao.BoardDao;
import kr.or.daekwang.board.model.vo.BoardVo;
import kr.or.daekwang.board.model.vo.PhotoVo;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDao boardDao;

	@Override
	public List<BoardVo> personNewsList(int endRow) {
		return boardDao.personNewsList(endRow);
	}

	@Override
	public int listCount() {
		return boardDao.listCount();
	}

	@Override
	public List<ApplyVo> churchNewsList(HashMap<String, Object> map) {
		return boardDao.churchNewsList(map);
	}

	@Override
	public int countChurchNews(HashMap<String, Object> countMap) {
		return boardDao.countChurchNews(countMap);
	}

	@Override
	public int insertChurchNews(BoardVo boardVo) {
		return boardDao.insertChurchNews(boardVo);
	}

	@Override
	public BoardVo selectChurchNewsDetail(int BOARD_NO) {
		return boardDao.selectChurchNewsDetail(BOARD_NO);
	}

	@Override
	public int addChurchNewsReadCount(int BOARD_NO) {
		return boardDao.addChurchNewsReadCount(BOARD_NO);
	}

	@Override
	public int insertNewFamilyIntroducing(BoardVo boardVo, PhotoVo photoVo) {
		
		//게시판 정보 등록
		int boardResult = boardDao.insertNewFamilyIntroducingBoard(boardVo);
		int photoResult = 0;
		int boardNoParam = 0;
		
		//정상적으로 등록되면 해당 게시물 번호 가져오기
		if(boardResult == 1) {
			boardNoParam = boardDao.selectBoardInformation(boardVo.getMEMBER_NO());
		}
		
		//정상적으로 게시물번호 조회시 사진테이블 insert
		if(boardNoParam != 0) {
			//게시물 번호 세팅
			photoVo.setBOARD_NO(boardNoParam);
			//회원 번호 세팅
			photoVo.setMEMBER_NO(boardVo.getMEMBER_NO());
			//사진 insert
			photoResult = boardDao.insertNewFamilyIntroducingPhoto(photoVo);
		}
		
		return photoResult;
	}

	@Override
	public List<BoardVo> newFamilyIntroducing(int endRow) {
		return boardDao.newFamilyIntroducing(endRow);
	}

	@Override
	public List<BoardVo> flowerPhotoList(int endRow) {
		return boardDao.flowerPhotoList(endRow);
	}

	@Override
	public int insertFlowerPhoto(BoardVo boardVo, PhotoVo photoVo) {
		//게시판 정보 등록
		int boardResult = boardDao.insertFlowerPhotoBoard(boardVo);
		int photoResult = 0;
		int boardNoParam = 0;
		
		//정상적으로 등록되면 해당 게시물 번호 가져오기
		if(boardResult == 1) {
			boardNoParam = boardDao.selectFlowerPhotoBoardInformation(boardVo.getMEMBER_NO());
		}
		
		//정상적으로 게시물번호 조회시 사진테이블 insert
		if(boardNoParam != 0) {
			//게시물 번호 세팅
			photoVo.setBOARD_NO(boardNoParam);
			//회원 번호 세팅
			photoVo.setMEMBER_NO(boardVo.getMEMBER_NO());
			//사진 insert
			photoResult = boardDao.insertFlowerPhotoPhoto(photoVo);
		}
		
		return photoResult;
	}
	
	@Override
	public int insertChurchPhotoBoardVo(BoardVo boardVo) {
		
		//게시판 정보 등록
		int result = boardDao.insertChurchPhotoBoardVo(boardVo);
		int board_no = 0;
		
		//게시판 정보 정상 등록 됐으면 게시물 번호 조회
		if(result != 0) {
			board_no = boardDao.selectChurchPhotoBoardInformation(boardVo.getMEMBER_NO());
		}else {
			board_no = 0;
		}
		
		return board_no;
	}
	
	

	@Override
	public int insertChurchPhotoPhotoVo(PhotoVo photoVo) {
		return boardDao.insertChurchPhotoPhotoVo(photoVo);
	}

	@Override
	public List<Map< String, Object>> churchPhoto(int endRow) {
		
		//게시판 게시물 먼저 조회
		List<BoardVo> boardList = boardDao.churchPhotoBoardMap(endRow);
		
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
			map.put("BOARD_TITLE", boardList.get(i).getBOARD_TITLE());
			map.put("BOARD_CONTENT", boardList.get(i).getBOARD_CONTENT());
			map.put("RECENT_UPDATE_DATE", boardList.get(i).getRECENT_UPDATE_DATE());
			
			//각 게시물에 관련된 사진 갯수 조회
			board_no = (int) boardList.get(i).getBOARD_NO();
			int PhotoListCount = boardDao.PhotoListCount(board_no);
			
			//map에 사진 갯수 넣기
			if(PhotoListCount != 0) {
				map.put("PHOTO_COUNT", PhotoListCount);
			}
			
			//각 게시물에 관련된 사진 rename 모두 조회
			List<PhotoVo> PhotoList = boardDao.churchPhotoPhotoList(board_no);
			
			//map 모든 사진 rename 넣기
			if(PhotoList != null) {
				for(int j = 1; j <= PhotoList.size(); j++) {
					map.put("PHOTO_IMAGE" + j, PhotoList.get(j-1).getPHOTO_RENAME());
				}
			}
			list.add(map);
		}
		
		return list;
	}

	@Override
	public void autoDeletePhoto(String path) {
		
		//삭제처리된지 한달 이상 된 사진리스트 조회
		List<PhotoVo> list =  boardDao.autoDeletePhoto();

		//사진이 있으면 삭제
		if(list != null) {
			for(int i = 0; i < list.size(); i++) {
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
		        	int result = boardDao.completeDeletePhoto(photo_rename);
		        	
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
