package kr.or.daekwang.board.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
}
