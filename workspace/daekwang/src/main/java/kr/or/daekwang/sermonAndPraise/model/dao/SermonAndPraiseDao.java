package kr.or.daekwang.sermonAndPraise.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.daekwang.sermonAndPraise.model.vo.SermonAndPraiseVo;

@Repository("SermonAndPraiseDao")
public class SermonAndPraiseDao {
	
	@Autowired SqlSessionTemplate mybatis;

	public SermonAndPraiseVo selectshalomChoir() {
		return mybatis.selectOne("sermonAndPraiseMapper.selectshalomChoir");
	}

	public SermonAndPraiseVo selectImmanuelChoir() {
		return mybatis.selectOne("sermonAndPraiseMapper.selectImmanuelChoir");
	}
}
