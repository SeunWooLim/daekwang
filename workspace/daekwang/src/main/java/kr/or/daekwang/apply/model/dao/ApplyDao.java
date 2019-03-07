package kr.or.daekwang.apply.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.daekwang.apply.model.vo.ApplyVo;

@Repository("applyDao")
public class ApplyDao {
	
	@Autowired
	private SqlSessionTemplate mybatis;

	public int insertWeekPage(ApplyVo applyVo) {
		return mybatis.insert("applyMapper.insertWeekPage", applyVo);
	}

	public int insertWorshipData(ApplyVo applyVo) {
		return mybatis.insert("applyMapper.insertWorshipData", applyVo);
	}
}
