package kr.or.daekwang.board.model.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.daekwang.apply.model.vo.ApplyVo;
import kr.or.daekwang.board.model.vo.BoardVo;
import kr.or.daekwang.board.model.vo.PhotoVo;

@Repository("boardDao")
public class BoardDao {
	
	@Autowired
	private SqlSessionTemplate mybatis;

	public List<BoardVo> personNewsList(int endRow) {
		return mybatis.selectList("boardMapper.personNewsList", endRow);
	}

	public int listCount() {
		return mybatis.selectOne("boardMapper.listCount");
	}

	public List<ApplyVo> churchNewsList(HashMap<String, Object> map) {
		return mybatis.selectList("boardMapper.churchNewsList", map);
	}

	public int countChurchNews(HashMap<String, Object> countMap) {
		return mybatis.selectOne("boardMapper.countChurchNews", countMap);
	}

	public int insertChurchNews(BoardVo boardVo) {
		return mybatis.insert("boardMapper.insertChurchNews", boardVo);
	}

	public BoardVo selectChurchNewsDetail(int BOARD_NO) {
		return mybatis.selectOne("boardMapper.selectChurchNewsDetail", BOARD_NO);
	}

	public int addChurchNewsReadCount(int BOARD_NO) {
		return mybatis.update("boardMapper.addChurchNewsReadCount", BOARD_NO);
	}

	public int insertNewFamilyIntroducingBoard(BoardVo boardVo) {
		return mybatis.insert("boardMapper.insertNewFamilyIntroducingBoard", boardVo);
	}

	public int selectBoardInformation(int member_no) {
		return mybatis.selectOne("boardMapper.selectBoardInformation", member_no);
	}

	public int insertNewFamilyIntroducingPhoto(PhotoVo photoVo) {
		return mybatis.insert("boardMapper.insertNewFamilyIntroducingPhoto", photoVo);
	}

	public List<BoardVo> newFamilyIntroducing(int endRow) {
		return mybatis.selectList("boardMapper.newFamilyIntroducing", endRow);
	}

	public List<BoardVo> flowerPhotoList(int endRow) {
		return mybatis.selectList("boardMapper.flowerPhotoList", endRow);
	}

	public int insertFlowerPhotoBoard(BoardVo boardVo) {
		return mybatis.insert("boardMapper.insertFlowerPhotoBoard", boardVo);
	}

	public int selectFlowerPhotoBoardInformation(int member_no) {
		return mybatis.selectOne("boardMapper.selectFlowerPhotoBoardInformation", member_no);
	}

	public int insertFlowerPhotoPhoto(PhotoVo photoVo) {
		return mybatis.insert("boardMapper.insertFlowerPhotoPhoto", photoVo);
	}
	
	public int insertChurchPhotoBoardVo(BoardVo boardVo) {
		return mybatis.insert("boardMapper.insertChurchPhotoBoardVo", boardVo);
	}
	
	public int selectChurchPhotoBoardInformation(int member_no) {
		return mybatis.selectOne("boardMapper.selectChurchPhotoBoardInformation", member_no);
	}
	
	public int insertChurchPhotoPhotoVo(PhotoVo photoVo) {
		return mybatis.insert("boardMapper.insertChurchPhotoPhotoVo", photoVo);
	}
	
	public List<BoardVo> churchPhotoBoardList(int endRow) {
		return mybatis.selectList("boardMapper.churchPhotoBoardList", endRow);
	}
	
	public HashMap<String, Object> churchPhotoBoardMap(int board_no) {
		return (HashMap<String, Object>)mybatis.selectList("boardMapper.churchPhotoBoardMap", board_no);
	}
	
	public int PhotoListCount(int board_no) {
		return mybatis.selectOne("boardMapper.PhotoListCount", board_no);
	}
	
	public List<PhotoVo> churchPhotoPhotoList(int board_no) {
		return mybatis.selectList("boardMapper.churchPhotoPhotoList", board_no);
	}

	

	

	
	

}
