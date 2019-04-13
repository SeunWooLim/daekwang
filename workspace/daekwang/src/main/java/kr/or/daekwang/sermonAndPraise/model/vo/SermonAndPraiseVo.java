package kr.or.daekwang.sermonAndPraise.model.vo;

import org.springframework.stereotype.Component;

@Component
public class SermonAndPraiseVo {
	
	public static final long serialVersionUID = 1L;
	
	private char PRAISE_FG;				//성가대구분
	private String PRAISE_BOSS;			//대장
	private String PRAISE_CONDUCTOR;	//지휘
	private String PRAISE_BANJU;		//반주
	private String PRAISE_MANAGER;		//총무
	private String PRAISE_SUBMANAGER;	//부총무
	private String PRAISE_WRITER;		//서기
	private String PRAISE_ACCOUNTANT;	//회계
	private String PRAISE_SOPRANO;		//소프라노
	private String PRAISE_ALTO;			//알토
	private String PRAISE_TENOR;		//테너
	private String PRAISE_BASS;			//베이스
	private String PRAISE_DETAIL;		//특이사항
	private String PRAISE_PHOTO_ORNAME; //성가대사진 원본명
	private String PRAISE_PHOTO_RENAME; //성가대사진 고유명
	
	public SermonAndPraiseVo() {
		
	}

	public SermonAndPraiseVo(char pRAISE_FG, String pRAISE_BOSS, String pRAISE_CONDUCTOR, String pRAISE_BANJU,
			String pRAISE_MANAGER, String pRAISE_SUBMANAGER, String pRAISE_WRITER, String pRAISE_ACCOUNTANT,
			String pRAISE_SOPRANO, String pRAISE_ALTO, String pRAISE_TENOR, String pRAISE_BASS, String pRAISE_DETAIL,
			String pRAISE_PHOTO_ORNAME, String pRAISE_PHOTO_RENAME) {
		super();
		PRAISE_FG = pRAISE_FG;
		PRAISE_BOSS = pRAISE_BOSS;
		PRAISE_CONDUCTOR = pRAISE_CONDUCTOR;
		PRAISE_BANJU = pRAISE_BANJU;
		PRAISE_MANAGER = pRAISE_MANAGER;
		PRAISE_SUBMANAGER = pRAISE_SUBMANAGER;
		PRAISE_WRITER = pRAISE_WRITER;
		PRAISE_ACCOUNTANT = pRAISE_ACCOUNTANT;
		PRAISE_SOPRANO = pRAISE_SOPRANO;
		PRAISE_ALTO = pRAISE_ALTO;
		PRAISE_TENOR = pRAISE_TENOR;
		PRAISE_BASS = pRAISE_BASS;
		PRAISE_DETAIL = pRAISE_DETAIL;
		PRAISE_PHOTO_ORNAME = pRAISE_PHOTO_ORNAME;
		PRAISE_PHOTO_RENAME = pRAISE_PHOTO_RENAME;
	}

	public char getPRAISE_FG() {
		return PRAISE_FG;
	}

	public void setPRAISE_FG(char pRAISE_FG) {
		PRAISE_FG = pRAISE_FG;
	}

	public String getPRAISE_BOSS() {
		return PRAISE_BOSS;
	}

	public void setPRAISE_BOSS(String pRAISE_BOSS) {
		PRAISE_BOSS = pRAISE_BOSS;
	}

	public String getPRAISE_CONDUCTOR() {
		return PRAISE_CONDUCTOR;
	}

	public void setPRAISE_CONDUCTOR(String pRAISE_CONDUCTOR) {
		PRAISE_CONDUCTOR = pRAISE_CONDUCTOR;
	}

	public String getPRAISE_BANJU() {
		return PRAISE_BANJU;
	}

	public void setPRAISE_BANJU(String pRAISE_BANJU) {
		PRAISE_BANJU = pRAISE_BANJU;
	}

	public String getPRAISE_MANAGER() {
		return PRAISE_MANAGER;
	}

	public void setPRAISE_MANAGER(String pRAISE_MANAGER) {
		PRAISE_MANAGER = pRAISE_MANAGER;
	}

	public String getPRAISE_SUBMANAGER() {
		return PRAISE_SUBMANAGER;
	}

	public void setPRAISE_SUBMANAGER(String pRAISE_SUBMANAGER) {
		PRAISE_SUBMANAGER = pRAISE_SUBMANAGER;
	}

	public String getPRAISE_WRITER() {
		return PRAISE_WRITER;
	}

	public void setPRAISE_WRITER(String pRAISE_WRITER) {
		PRAISE_WRITER = pRAISE_WRITER;
	}

	public String getPRAISE_ACCOUNTANT() {
		return PRAISE_ACCOUNTANT;
	}

	public void setPRAISE_ACCOUNTANT(String pRAISE_ACCOUNTANT) {
		PRAISE_ACCOUNTANT = pRAISE_ACCOUNTANT;
	}

	public String getPRAISE_SOPRANO() {
		return PRAISE_SOPRANO;
	}

	public void setPRAISE_SOPRANO(String pRAISE_SOPRANO) {
		PRAISE_SOPRANO = pRAISE_SOPRANO;
	}

	public String getPRAISE_ALTO() {
		return PRAISE_ALTO;
	}

	public void setPRAISE_ALTO(String pRAISE_ALTO) {
		PRAISE_ALTO = pRAISE_ALTO;
	}

	public String getPRAISE_TENOR() {
		return PRAISE_TENOR;
	}

	public void setPRAISE_TENOR(String pRAISE_TENOR) {
		PRAISE_TENOR = pRAISE_TENOR;
	}

	public String getPRAISE_BASS() {
		return PRAISE_BASS;
	}

	public void setPRAISE_BASS(String pRAISE_BASS) {
		PRAISE_BASS = pRAISE_BASS;
	}

	public String getPRAISE_DETAIL() {
		return PRAISE_DETAIL;
	}

	public void setPRAISE_DETAIL(String pRAISE_DETAIL) {
		PRAISE_DETAIL = pRAISE_DETAIL;
	}

	public String getPRAISE_PHOTO_ORNAME() {
		return PRAISE_PHOTO_ORNAME;
	}

	public void setPRAISE_PHOTO_ORNAME(String pRAISE_PHOTO_ORNAME) {
		PRAISE_PHOTO_ORNAME = pRAISE_PHOTO_ORNAME;
	}

	public String getPRAISE_PHOTO_RENAME() {
		return PRAISE_PHOTO_RENAME;
	}

	public void setPRAISE_PHOTO_RENAME(String pRAISE_PHOTO_RENAME) {
		PRAISE_PHOTO_RENAME = pRAISE_PHOTO_RENAME;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "SermonAndPraiseVo [PRAISE_FG=" + PRAISE_FG + ", PRAISE_BOSS=" + PRAISE_BOSS + ", PRAISE_CONDUCTOR="
				+ PRAISE_CONDUCTOR + ", PRAISE_BANJU=" + PRAISE_BANJU + ", PRAISE_MANAGER=" + PRAISE_MANAGER
				+ ", PRAISE_SUBMANAGER=" + PRAISE_SUBMANAGER + ", PRAISE_WRITER=" + PRAISE_WRITER
				+ ", PRAISE_ACCOUNTANT=" + PRAISE_ACCOUNTANT + ", PRAISE_SOPRANO=" + PRAISE_SOPRANO + ", PRAISE_ALTO="
				+ PRAISE_ALTO + ", PRAISE_TENOR=" + PRAISE_TENOR + ", PRAISE_BASS=" + PRAISE_BASS + ", PRAISE_DETAIL="
				+ PRAISE_DETAIL + ", PRAISE_PHOTO_ORNAME=" + PRAISE_PHOTO_ORNAME + ", PRAISE_PHOTO_RENAME="
				+ PRAISE_PHOTO_RENAME + "]";
	}

	
}
