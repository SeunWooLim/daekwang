package kr.or.daekwang.board.model.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.daekwang.apply.model.vo.ApplyVo;
import kr.or.daekwang.board.model.vo.BoardVo;

@Repository("boardDao")
public class BoardDao {
	
	@Autowired
	private SqlSessionTemplate mybatis;

	public List<BoardVo> personNewsList() {
		return mybatis.selectList("boardMapper.personNewsList");
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
}
