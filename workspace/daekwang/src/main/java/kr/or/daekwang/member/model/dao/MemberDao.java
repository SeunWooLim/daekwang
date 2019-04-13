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

	public int checkId(String member_id) {
		return mybatis.selectOne("memberMapper.checkId", member_id);
	}

	public int enroll(MemberVo member) {
		return mybatis.insert("memberMapper.enroll", member);
	}

	public String findId(MemberVo member) {
		return mybatis.selectOne("memberMapper.findId", member);
	}

	public int findPwd(MemberVo member) {
		return mybatis.selectOne("memberMapper.findPwd", member);
	}

	public int updateTempPwd(MemberVo member) {
		return mybatis.update("memberMapper.updateTempPwd", member);
	}


	
	
}
