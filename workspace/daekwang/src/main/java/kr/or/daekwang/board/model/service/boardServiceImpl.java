package kr.or.daekwang.board.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public int insertPersonNews(BoardVo boardVo) {
		return boardDao.insertPersonNews(boardVo);
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
			
			map.put("UPLOAD_YYMM", PhotoList.get(0).getUPLOAD_YYMM());
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
	public int countChurchPhotoNew() {
		return boardDao.countChurchPhotoNew();
	}

	@Override
	public List<Map< String, Object>> churchPhotoNewList(HashMap<String, Object> smap) {
		//게시판 게시물 먼저 조회
		List<BoardVo> boardList = boardDao.churchPhotoNewList(smap);
		
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
			map.put("MEMBER_NO", boardList.get(i).getMEMBER_NO());
			
			//각 게시물에 관련된 사진 갯수 조회
			board_no = (int) boardList.get(i).getBOARD_NO();
			int PhotoListCount = boardDao.PhotoListCount(board_no);
			
			//map에 사진 갯수 넣기
			if(PhotoListCount != 0) {
				map.put("PHOTO_COUNT", PhotoListCount);
			}
			
			//각 게시물에 관련된 사진 rename 모두 조회
			List<PhotoVo> PhotoList = boardDao.churchPhotoPhotoList(board_no);
			
			map.put("UPLOAD_YYMM", PhotoList.get(0).getUPLOAD_YYMM());
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
	public List<PhotoVo> selectChurchPhotoDetail(int board_no) {
		return boardDao.selectChurchPhotoDetail(board_no);
	}

	@Override
	public int deleteBoardAndPhoto(int board_no) {
		//게시판 DELETE_YN = 'Y'처리
		int deleteResult = boardDao.deleteBoardInfor(board_no);
		int result = 0;
		
		if(deleteResult != 0 ) {
			//사진정보 DELETE_YN ='Y' 처리
			result = boardDao.deletePhotoInfor(board_no);
			//사진 DELETE_DATE 추가
			if(result != 0) {
				boardDao.insertDeleteDate(board_no);
			}
		}
		return result;
	}

	@Override
	public int deleteBoard(int board_no) {
		return boardDao.deleteBoardInfor(board_no);
	}
	
}
