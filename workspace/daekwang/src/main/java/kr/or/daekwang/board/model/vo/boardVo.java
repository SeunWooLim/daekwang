package kr.or.daekwang.board.model.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class BoardVo {
	
	public static final long serialVersionUID = 3L;
	
	private char BOARD_FG;				//게시판구분
	private int BOARD_NO;				//게시판번호
	private String BOARD_TITLE;			//게시글제목
	private String BOARD_CONTENT;		//게시글내용
	private int BOARD_READCNT;			//게시글조회수
	private int MEMBER_NO;				//게시자번호
	private Date FIRST_INPUT_DATE;		//최초게시일
	private Date RECENT_UPDATE_DATE;	//최근수정일
	private char DELETE_YN;				//삭제여부
	private int REPLY_NO;				//댓글번호
	private char REPLY_BOARD_FG; 		//연관게시판
	private int REPLY_BOARD_NO;			//원글번호
	private String REPLY_CONTENT;		//댓글내용
	private int REPLY_MEMBER_NO;		//회원번호
	private Date REPLY_DATE;			//댓글날짜
	private char REPLY_DELETE_YN;		//댓글삭제여부
	
	public BoardVo() {
		
	}

	public BoardVo(char bOARD_FG, int bOARD_NO, String bOARD_TITLE, String bOARD_CONTENT, int bOARD_READCNT,
			int mEMBER_NO, Date fIRST_INPUT_DATE, Date rECENT_UPDATE_DATE, char dELETE_YN, int rEPLY_NO,
			char rEPLY_BOARD_FG, int rEPLY_BOARD_NO, String rEPLY_CONTENT, int rEPLY_MEMBER_NO, Date rEPLY_DATE,
			char rEPLY_DELETE_YN) {
		super();
		BOARD_FG = bOARD_FG;
		BOARD_NO = bOARD_NO;
		BOARD_TITLE = bOARD_TITLE;
		BOARD_CONTENT = bOARD_CONTENT;
		BOARD_READCNT = bOARD_READCNT;
		MEMBER_NO = mEMBER_NO;
		FIRST_INPUT_DATE = fIRST_INPUT_DATE;
		RECENT_UPDATE_DATE = rECENT_UPDATE_DATE;
		DELETE_YN = dELETE_YN;
		REPLY_NO = rEPLY_NO;
		REPLY_BOARD_FG = rEPLY_BOARD_FG;
		REPLY_BOARD_NO = rEPLY_BOARD_NO;
		REPLY_CONTENT = rEPLY_CONTENT;
		REPLY_MEMBER_NO = rEPLY_MEMBER_NO;
		REPLY_DATE = rEPLY_DATE;
		REPLY_DELETE_YN = rEPLY_DELETE_YN;
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

	public String getBOARD_TITLE() {
		return BOARD_TITLE;
	}

	public void setBOARD_TITLE(String bOARD_TITLE) {
		BOARD_TITLE = bOARD_TITLE;
	}

	public String getBOARD_CONTENT() {
		return BOARD_CONTENT;
	}

	public void setBOARD_CONTENT(String bOARD_CONTENT) {
		BOARD_CONTENT = bOARD_CONTENT;
	}

	public int getBOARD_READCNT() {
		return BOARD_READCNT;
	}

	public void setBOARD_READCNT(int bOARD_READCNT) {
		BOARD_READCNT = bOARD_READCNT;
	}

	public int getMEMBER_NO() {
		return MEMBER_NO;
	}

	public void setMEMBER_NO(int mEMBER_NO) {
		MEMBER_NO = mEMBER_NO;
	}

	public Date getFIRST_INPUT_DATE() {
		return FIRST_INPUT_DATE;
	}

	public void setFIRST_INPUT_DATE(Date fIRST_INPUT_DATE) {
		FIRST_INPUT_DATE = fIRST_INPUT_DATE;
	}

	public Date getRECENT_UPDATE_DATE() {
		return RECENT_UPDATE_DATE;
	}

	public void setRECENT_UPDATE_DATE(Date rECENT_UPDATE_DATE) {
		RECENT_UPDATE_DATE = rECENT_UPDATE_DATE;
	}

	public char getDELETE_YN() {
		return DELETE_YN;
	}

	public void setDELETE_YN(char dELETE_YN) {
		DELETE_YN = dELETE_YN;
	}

	public int getREPLY_NO() {
		return REPLY_NO;
	}

	public void setREPLY_NO(int rEPLY_NO) {
		REPLY_NO = rEPLY_NO;
	}

	public char getREPLY_BOARD_FG() {
		return REPLY_BOARD_FG;
	}

	public void setREPLY_BOARD_FG(char rEPLY_BOARD_FG) {
		REPLY_BOARD_FG = rEPLY_BOARD_FG;
	}

	public int getREPLY_BOARD_NO() {
		return REPLY_BOARD_NO;
	}

	public void setREPLY_BOARD_NO(int rEPLY_BOARD_NO) {
		REPLY_BOARD_NO = rEPLY_BOARD_NO;
	}

	public String getREPLY_CONTENT() {
		return REPLY_CONTENT;
	}

	public void setREPLY_CONTENT(String rEPLY_CONTENT) {
		REPLY_CONTENT = rEPLY_CONTENT;
	}

	public int getREPLY_MEMBER_NO() {
		return REPLY_MEMBER_NO;
	}

	public void setREPLY_MEMBER_NO(int rEPLY_MEMBER_NO) {
		REPLY_MEMBER_NO = rEPLY_MEMBER_NO;
	}

	public Date getREPLY_DATE() {
		return REPLY_DATE;
	}

	public void setREPLY_DATE(Date rEPLY_DATE) {
		REPLY_DATE = rEPLY_DATE;
	}

	public char getREPLY_DELETE_YN() {
		return REPLY_DELETE_YN;
	}

	public void setREPLY_DELETE_YN(char rEPLY_DELETE_YN) {
		REPLY_DELETE_YN = rEPLY_DELETE_YN;
	}

	@Override
	public String toString() {
		return "BoardVo [BOARD_FG=" + BOARD_FG + ", BOARD_NO=" + BOARD_NO + ", BOARD_TITLE=" + BOARD_TITLE
				+ ", BOARD_CONTENT=" + BOARD_CONTENT + ", BOARD_READCNT=" + BOARD_READCNT + ", MEMBER_NO=" + MEMBER_NO
				+ ", FIRST_INPUT_DATE=" + FIRST_INPUT_DATE + ", RECENT_UPDATE_DATE=" + RECENT_UPDATE_DATE
				+ ", DELETE_YN=" + DELETE_YN + ", REPLY_NO=" + REPLY_NO + ", REPLY_BOARD_FG=" + REPLY_BOARD_FG
				+ ", REPLY_BOARD_NO=" + REPLY_BOARD_NO + ", REPLY_CONTENT=" + REPLY_CONTENT + ", REPLY_MEMBER_NO="
				+ REPLY_MEMBER_NO + ", REPLY_DATE=" + REPLY_DATE + ", REPLY_DELETE_YN=" + REPLY_DELETE_YN + "]";
	}
	
	

}
