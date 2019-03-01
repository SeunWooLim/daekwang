package kr.or.daekwang.member.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.daekwang.member.model.vo.MemberVo;

@Repository("memberDao")
public class MemberDao {
	
	@Autowired SqlSessionTemplate mybatis;

	public MemberVo loginCheck(MemberVo member) {
		return mybatis.selectOne("memberMapper.loginCheck", member);
	}


	
	
}
