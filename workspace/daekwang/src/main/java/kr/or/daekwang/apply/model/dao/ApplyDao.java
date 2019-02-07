package kr.or.daekwang.apply.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("applyDao")
public class ApplyDao {
	
	@Autowired
	private SqlSessionTemplate mybatis;
}
