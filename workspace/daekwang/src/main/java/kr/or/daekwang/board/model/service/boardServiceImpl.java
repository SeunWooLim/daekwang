package kr.or.daekwang.board.model.service;

import java.util.HashMap;
import java.util.List;

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
	public HashMap<String, Object> churchPhoto(int endRow) {
		
		//List<BoardVo> BoardList = boardDao.churchPhotoBoardList(endRow);
		
		//교회 사진 게시물 전체 조회
		HashMap<String, Object> BoardMap = boardDao.churchPhotoBoardMap(endRow);
		
		//게시물에 사진정보 붙이기
		for(int i = 0; i < BoardMap.size(); i++) {
			int board_no = (int) BoardMap.get("BOARD_NO");
			
			//게시물에 대한 사진 갯수 조회
			int PhotoListCount = boardDao.PhotoListCount(board_no);
			
			//사진 갯수를 "PHOTO_COUNT" 로 저장
			if(PhotoListCount != 0) {
				BoardMap.put("PHOTO_COUNT", PhotoListCount);
			}
			
			//게시물에 대한 사진 정보 조회
			List<PhotoVo> PhotoList = boardDao.churchPhotoPhotoList(board_no);
			
			//사진정보 저장
			if(PhotoList != null) {
				for(int j = 1; j <= PhotoList.size(); j++) {
					BoardMap.put("PHOTO_IMAGE" + j, PhotoList.get(j).getPHOTO_RENAME());
				}
			}
			
		}
		
		return BoardMap;
	}
	
	
	
}
