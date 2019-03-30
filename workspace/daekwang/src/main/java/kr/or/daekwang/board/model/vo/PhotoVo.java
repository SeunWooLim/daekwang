package kr.or.daekwang.board.model.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class PhotoVo {
	
	public static final long serialVersionUID = 32L;
	
	private char BOARD_FG;			//게시판구분
	private int BOARD_NO;			//원글 번호
	private char DELETE_YN;			//삭제 구분
	private int MEMBER_NO;			//작성자
	private Date PHOTO_DATE;		//작성일
	private int PHOTO_NO;			//사진번호
	private String PHOTO_ORNAME;	//사진원본명
	private String PHOTO_RENAME;	//사진고유명
	
	public PhotoVo() {
		
	}

	public PhotoVo(char bOARD_FG, int bOARD_NO, char dELETE_YN, int mEMBER_NO, Date pHOTO_DATE, int pHOTO_NO,
			String pHOTO_ORNAME, String pHOTO_RENAME) {
		super();
		BOARD_FG = bOARD_FG;
		BOARD_NO = bOARD_NO;
		DELETE_YN = dELETE_YN;
		MEMBER_NO = mEMBER_NO;
		PHOTO_DATE = pHOTO_DATE;
		PHOTO_NO = pHOTO_NO;
		PHOTO_ORNAME = pHOTO_ORNAME;
		PHOTO_RENAME = pHOTO_RENAME;
	}

	public char getBOARD_FG() {
		return BOARD_FG;
	}

	public void setBOARD_FG(char bOARD_FG) {
		BOARD_FG = bOARD_FG;
	}

	public int getBOARD_NO() {
		return BOARD_NO;
	}

	public void setBOARD_NO(int bOARD_NO) {
		BOARD_NO = bOARD_NO;
	}

	public char getDELETE_YN() {
		return DELETE_YN;
	}

	public void setDELETE_YN(char dELETE_YN) {
		DELETE_YN = dELETE_YN;
	}

	public int getMEMBER_NO() {
		return MEMBER_NO;
	}

	public void setMEMBER_NO(int mEMBER_NO) {
		MEMBER_NO = mEMBER_NO;
	}

	public Date getPHOTO_DATE() {
		return PHOTO_DATE;
	}

	public void setPHOTO_DATE(Date pHOTO_DATE) {
		PHOTO_DATE = pHOTO_DATE;
	}

	public int getPHOTO_NO() {
		return PHOTO_NO;
	}

	public void setPHOTO_NO(int pHOTO_NO) {
		PHOTO_NO = pHOTO_NO;
	}

	public String getPHOTO_ORNAME() {
		return PHOTO_ORNAME;
	}

	public void setPHOTO_ORNAME(String pHOTO_ORNAME) {
		PHOTO_ORNAME = pHOTO_ORNAME;
	}

	public String getPHOTO_RENAME() {
		return PHOTO_RENAME;
	}

	public void setPHOTO_RENAME(String pHOTO_RENAME) {
		PHOTO_RENAME = pHOTO_RENAME;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "PhotoVo [BOARD_FG=" + BOARD_FG + ", BOARD_NO=" + BOARD_NO + ", DELETE_YN=" + DELETE_YN + ", MEMBER_NO="
				+ MEMBER_NO + ", PHOTO_DATE=" + PHOTO_DATE + ", PHOTO_NO=" + PHOTO_NO + ", PHOTO_ORNAME=" + PHOTO_ORNAME
				+ ", PHOTO_RENAME=" + PHOTO_RENAME + "]";
	}
	
	
}
