package kr.or.daekwang.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.daekwang.member.model.dao.MemberDao;
import kr.or.daekwang.member.model.vo.MemberVo;

@Service("memberService")
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberDao memberDao;

	@Override
	public MemberVo loginCheck(MemberVo member) {
		return memberDao.loginCheck(member);
	}

	@Override
	public int checkId(String member_id) {
		return memberDao.checkId(member_id);
	}

	@Override
	public int enroll(MemberVo member) {
		return memberDao.enroll(member);
	}
	
	
	
}
