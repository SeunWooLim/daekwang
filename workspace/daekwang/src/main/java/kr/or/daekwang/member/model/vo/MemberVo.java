package kr.or.daekwang.member.model.vo;

import org.springframework.stereotype.Component;

@Component
public class MemberVo {
	
	public static final long serialVersionUID = 2L;
	
	private int MEMBER_NO;			//회원번호
	private String MEMBER_FG;		//회원구분
	private String MEMBER_ID;		//회원아이디
	private String MEMBER_PWD;		//회원비밀번호
	private String MEMBER_NAME;		//회원이름
	private String MEMBER_PHONE;	//핸드폰번호
	private String MEMBER_EMAIL;	//회원이메일
	private String MEMBER_ADDR;		//회원주소
	private String MEMBER_DETAIL;	//회원설명
	private String MEMBER_USEYN;	//사용여부
	
	public MemberVo() {
		
	}

	public MemberVo(int mEMBER_NO, String mEMBER_FG, String mEMBER_ID, String mEMBER_PWD, String mEMBER_NAME,
			String mEMBER_PHONE, String mEMBER_EMAIL, String mEMBER_ADDR, String mEMBER_DETAIL, String mEMBER_USEYN) {
		super();
		MEMBER_NO = mEMBER_NO;
		MEMBER_FG = mEMBER_FG;
		MEMBER_ID = mEMBER_ID;
		MEMBER_PWD = mEMBER_PWD;
		MEMBER_NAME = mEMBER_NAME;
		MEMBER_PHONE = mEMBER_PHONE;
		MEMBER_EMAIL = mEMBER_EMAIL;
		MEMBER_ADDR = mEMBER_ADDR;
		MEMBER_DETAIL = mEMBER_DETAIL;
		MEMBER_USEYN = mEMBER_USEYN;
	}

	public int getMEMBER_NO() {
		return MEMBER_NO;
	}

	public void setMEMBER_NO(int mEMBER_NO) {
		MEMBER_NO = mEMBER_NO;
	}

	public String getMEMBER_FG() {
		return MEMBER_FG;
	}

	public void setMEMBER_FG(String mEMBER_FG) {
		MEMBER_FG = mEMBER_FG;
	}

	public String getMEMBER_ID() {
		return MEMBER_ID;
	}

	public void setMEMBER_ID(String mEMBER_ID) {
		MEMBER_ID = mEMBER_ID;
	}

	public String getMEMBER_PWD() {
		return MEMBER_PWD;
	}

	public void setMEMBER_PWD(String mEMBER_PWD) {
		MEMBER_PWD = mEMBER_PWD;
	}

	public String getMEMBER_NAME() {
		return MEMBER_NAME;
	}

	public void setMEMBER_NAME(String mEMBER_NAME) {
		MEMBER_NAME = mEMBER_NAME;
	}

	public String getMEMBER_PHONE() {
		return MEMBER_PHONE;
	}

	public void setMEMBER_PHONE(String mEMBER_PHONE) {
		MEMBER_PHONE = mEMBER_PHONE;
	}

	public String getMEMBER_EMAIL() {
		return MEMBER_EMAIL;
	}

	public void setMEMBER_EMAIL(String mEMBER_EMAIL) {
		MEMBER_EMAIL = mEMBER_EMAIL;
	}

	public String getMEMBER_ADDR() {
		return MEMBER_ADDR;
	}

	public void setMEMBER_ADDR(String mEMBER_ADDR) {
		MEMBER_ADDR = mEMBER_ADDR;
	}

	public String getMEMBER_DETAIL() {
		return MEMBER_DETAIL;
	}

	public void setMEMBER_DETAIL(String mEMBER_DETAIL) {
		MEMBER_DETAIL = mEMBER_DETAIL;
	}

	public String getMEMBER_USEYN() {
		return MEMBER_USEYN;
	}

	public void setMEMBER_USEYN(String mEMBER_USEYN) {
		MEMBER_USEYN = mEMBER_USEYN;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "MemberVo [MEMBER_NO=" + MEMBER_NO + ", MEMBER_FG=" + MEMBER_FG + ", MEMBER_ID=" + MEMBER_ID
				+ ", MEMBER_PWD=" + MEMBER_PWD + ", MEMBER_NAME=" + MEMBER_NAME + ", MEMBER_PHONE=" + MEMBER_PHONE
				+ ", MEMBER_EMAIL=" + MEMBER_EMAIL + ", MEMBER_ADDR=" + MEMBER_ADDR + ", MEMBER_DETAIL=" + MEMBER_DETAIL
				+ ", MEMBER_USEYN=" + MEMBER_USEYN + "]";
	}

	
	
}
