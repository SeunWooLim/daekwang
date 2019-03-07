package kr.or.daekwang.member.model.service;

import kr.or.daekwang.member.model.vo.MemberVo;

public interface MemberService {

	MemberVo loginCheck(MemberVo member);

	int checkId(String member_id);

	int enroll(MemberVo member);

}
