package kr.or.daekwang.apply.model.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

import kr.or.daekwang.member.model.vo.MemberVo;

@Component
public class ApplyVo {
	
	public static final long serialVersionUID = 4L;
	
	private char APPLY_FG;			//신청구분
	private int APPLY_NO;			//신청번호
	private String APPLY_TITLE;		//신청제목	
	private String APPLY_CONTENT;	//신청내용
	private int MEMBER_NO;			//신청자
	private Date APPLY_DATE;		//신청일
	private String APPLY_ORFILE;	//첨부파일원본명
	private String APPLY_REFILE;	//첨부파일고유명
	private char DELETE_YN;			//삭제여부
	private String WORSHIP_NAME; 	//예배명
	private String APPLY_CATE;		//주보신청분류
	private String DEPT_NAME; 		//부서명
	
	private MemberVo memberVo;
	
	public ApplyVo() {
		
	}

	public ApplyVo(char aPPLY_FG, int aPPLY_NO, String aPPLY_TITLE, String aPPLY_CONTENT, int mEMBER_NO,
			Date aPPLY_DATE, String aPPLY_ORFILE, String aPPLY_REFILE, char dELETE_YN, String wORSHIP_NAME,
			String aPPLY_CATE, String dEPT_NAME, MemberVo memberVo) {
		super();
		APPLY_FG = aPPLY_FG;
		APPLY_NO = aPPLY_NO;
		APPLY_TITLE = aPPLY_TITLE;
		APPLY_CONTENT = aPPLY_CONTENT;
		MEMBER_NO = mEMBER_NO;
		APPLY_DATE = aPPLY_DATE;
		APPLY_ORFILE = aPPLY_ORFILE;
		APPLY_REFILE = aPPLY_REFILE;
		DELETE_YN = dELETE_YN;
		WORSHIP_NAME = wORSHIP_NAME;
		APPLY_CATE = aPPLY_CATE;
		DEPT_NAME = dEPT_NAME;
		this.memberVo = memberVo;
	}

	public char getAPPLY_FG() {
		return APPLY_FG;
	}

	public void setAPPLY_FG(char aPPLY_FG) {
		APPLY_FG = aPPLY_FG;
	}

	public int getAPPLY_NO() {
		return APPLY_NO;
	}

	public void setAPPLY_NO(int aPPLY_NO) {
		APPLY_NO = aPPLY_NO;
	}

	public String getAPPLY_TITLE() {
		return APPLY_TITLE;
	}

	public void setAPPLY_TITLE(String aPPLY_TITLE) {
		APPLY_TITLE = aPPLY_TITLE;
	}

	public String getAPPLY_CONTENT() {
		return APPLY_CONTENT;
	}

	public void setAPPLY_CONTENT(String aPPLY_CONTENT) {
		APPLY_CONTENT = aPPLY_CONTENT;
	}

	public int getMEMBER_NO() {
		return MEMBER_NO;
	}

	public void setMEMBER_NO(int mEMBER_NO) {
		MEMBER_NO = mEMBER_NO;
	}

	public Date getAPPLY_DATE() {
		return APPLY_DATE;
	}

	public void setAPPLY_DATE(Date aPPLY_DATE) {
		APPLY_DATE = aPPLY_DATE;
	}

	public String getAPPLY_ORFILE() {
		return APPLY_ORFILE;
	}

	public void setAPPLY_ORFILE(String aPPLY_ORFILE) {
		APPLY_ORFILE = aPPLY_ORFILE;
	}

	public String getAPPLY_REFILE() {
		return APPLY_REFILE;
	}

	public void setAPPLY_REFILE(String aPPLY_REFILE) {
		APPLY_REFILE = aPPLY_REFILE;
	}

	public char getDELETE_YN() {
		return DELETE_YN;
	}

	public void setDELETE_YN(char dELETE_YN) {
		DELETE_YN = dELETE_YN;
	}

	public String getWORSHIP_NAME() {
		return WORSHIP_NAME;
	}

	public void setWORSHIP_NAME(String wORSHIP_NAME) {
		WORSHIP_NAME = wORSHIP_NAME;
	}

	public String getAPPLY_CATE() {
		return APPLY_CATE;
	}

	public void setAPPLY_CATE(String aPPLY_CATE) {
		APPLY_CATE = aPPLY_CATE;
	}

	public String getDEPT_NAME() {
		return DEPT_NAME;
	}

	public void setDEPT_NAME(String dEPT_NAME) {
		DEPT_NAME = dEPT_NAME;
	}

	public MemberVo getMemberVo() {
		return memberVo;
	}

	public void setMemberVo(MemberVo memberVo) {
		this.memberVo = memberVo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ApplyVo [APPLY_FG=" + APPLY_FG + ", APPLY_NO=" + APPLY_NO + ", APPLY_TITLE=" + APPLY_TITLE
				+ ", APPLY_CONTENT=" + APPLY_CONTENT + ", MEMBER_NO=" + MEMBER_NO + ", APPLY_DATE=" + APPLY_DATE
				+ ", APPLY_ORFILE=" + APPLY_ORFILE + ", APPLY_REFILE=" + APPLY_REFILE + ", DELETE_YN=" + DELETE_YN
				+ ", WORSHIP_NAME=" + WORSHIP_NAME + ", APPLY_CATE=" + APPLY_CATE + ", DEPT_NAME=" + DEPT_NAME + "]";
	}

	
}
