package kr.or.daekwang.sermonAndPraise.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("SermonAndPraiseDao")
public class SermonAndPraiseDao {
	
	@Autowired SqlSessionTemplate mybatis;
}
