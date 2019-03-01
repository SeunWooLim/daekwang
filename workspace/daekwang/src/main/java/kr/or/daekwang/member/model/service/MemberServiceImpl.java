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
	
	
}
