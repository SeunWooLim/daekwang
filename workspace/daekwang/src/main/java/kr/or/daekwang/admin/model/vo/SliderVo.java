package kr.or.daekwang.admin.model.vo;

public class SliderVo {
	
	public static final long serialVersionUID = 25L;
	
	private String SLIDER_CONTENT;	//슬라이더 내용
	private String SLIDER_DATE;		//슬라이더 날짜
	private String SLIDER_NO;		//슬라이더 번호
	private String SLIDER_ORNAME;	//슬라이더 원본명
	private String SLIDER_RENAME;	//슬라이더 고유명
	private String SLIDER_TITLE;	//슬라이더 제목
	private String UPLOAD_YYMM;		//업로드 년월
	private char SLIDER_CATE;		//슬라이더 구분
	private char SLIDER_BG;			//슬라이더 배경 사용유무
	
	public SliderVo() {}

	public SliderVo(String sLIDER_CONTENT, String sLIDER_DATE, String sLIDER_NO, String sLIDER_ORNAME,
			String sLIDER_RENAME, String sLIDER_TITLE, String uPLOAD_YYMM, char sLIDER_CATE, char sLIDER_BG) {
		super();
		SLIDER_CONTENT = sLIDER_CONTENT;
		SLIDER_DATE = sLIDER_DATE;
		SLIDER_NO = sLIDER_NO;
		SLIDER_ORNAME = sLIDER_ORNAME;
		SLIDER_RENAME = sLIDER_RENAME;
		SLIDER_TITLE = sLIDER_TITLE;
		UPLOAD_YYMM = uPLOAD_YYMM;
		SLIDER_CATE = sLIDER_CATE;
		SLIDER_BG = sLIDER_BG;
	}

	public String getSLIDER_CONTENT() {
		return SLIDER_CONTENT;
	}

	public void setSLIDER_CONTENT(String sLIDER_CONTENT) {
		SLIDER_CONTENT = sLIDER_CONTENT;
	}

	public String getSLIDER_DATE() {
		return SLIDER_DATE;
	}

	public void setSLIDER_DATE(String sLIDER_DATE) {
		SLIDER_DATE = sLIDER_DATE;
	}

	public String getSLIDER_NO() {
		return SLIDER_NO;
	}

	public void setSLIDER_NO(String sLIDER_NO) {
		SLIDER_NO = sLIDER_NO;
	}

	public String getSLIDER_ORNAME() {
		return SLIDER_ORNAME;
	}

	public void setSLIDER_ORNAME(String sLIDER_ORNAME) {
		SLIDER_ORNAME = sLIDER_ORNAME;
	}

	public String getSLIDER_RENAME() {
		return SLIDER_RENAME;
	}

	public void setSLIDER_RENAME(String sLIDER_RENAME) {
		SLIDER_RENAME = sLIDER_RENAME;
	}

	public String getSLIDER_TITLE() {
		return SLIDER_TITLE;
	}

	public void setSLIDER_TITLE(String sLIDER_TITLE) {
		SLIDER_TITLE = sLIDER_TITLE;
	}

	public String getUPLOAD_YYMM() {
		return UPLOAD_YYMM;
	}

	public void setUPLOAD_YYMM(String uPLOAD_YYMM) {
		UPLOAD_YYMM = uPLOAD_YYMM;
	}

	public char getSLIDER_CATE() {
		return SLIDER_CATE;
	}

	public void setSLIDER_CATE(char sLIDER_CATE) {
		SLIDER_CATE = sLIDER_CATE;
	}

	public char getSLIDER_BG() {
		return SLIDER_BG;
	}

	public void setSLIDER_BG(char sLIDER_BG) {
		SLIDER_BG = sLIDER_BG;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "SliderVo [SLIDER_CONTENT=" + SLIDER_CONTENT + ", SLIDER_DATE=" + SLIDER_DATE + ", SLIDER_NO="
				+ SLIDER_NO + ", SLIDER_ORNAME=" + SLIDER_ORNAME + ", SLIDER_RENAME=" + SLIDER_RENAME
				+ ", SLIDER_TITLE=" + SLIDER_TITLE + ", UPLOAD_YYMM=" + UPLOAD_YYMM + ", SLIDER_CATE=" + SLIDER_CATE
				+ ", SLIDER_BG=" + SLIDER_BG + "]";
	}


}
