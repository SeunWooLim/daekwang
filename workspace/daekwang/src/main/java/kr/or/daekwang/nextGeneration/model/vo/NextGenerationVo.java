package kr.or.daekwang.nextGeneration.model.vo;

public class NextGenerationVo {
	public static final long serialVersionUID = 15L;
	
	private int DEPT_NO;				//부서번호
	private String DEPT_NAME;			//부서명
	private String EDU_TITLE;			//교육표어
	private String MAIN_WORDS;			//주제말씀
	private String WORSHIP_OBJECT;		//예배대상
	private String WORSHIP_TIME;		//예배시간
	private String WORSHIP_AREA;		//예배장소
	private String DEPT_VISION;			//비전
	private String DEPT_MISSION;		//핵심사역
	private String DEPT_LEADER;			//지도
	private String DEPT_HEADER;			//부장
	private String DEPT_DIRECTOR;		//부감, 청년부회장
	private String DEPT_BUDIRECTOR;		//부회장
	private String DEPT_MANAGER;		//총무
	private String DEPT_WRITER;			//서기
	private String DEPT_ACCOUNTANT;		//회계
	private String DEPT_MEMBER;			//구성원
	private String DEPT_PHOTO_ORNAME;	//사진원본명
	private String DEPT_PHOTO_RENAME;	//사진고유명
	private String DEPT_UPLOAD_YYMM;	//업로드년월
	
	public NextGenerationVo() {
		
	}

	public NextGenerationVo(int dEPT_NO, String dEPT_NAME, String eDU_TITLE, String mAIN_WORDS, String wORSHIP_OBJECT,
			String wORSHIP_TIME, String wORSHIP_AREA, String dEPT_VISION, String dEPT_MISSION, String dEPT_LEADER,
			String dEPT_HEADER, String dEPT_DIRECTOR, String dEPT_BUDIRECTOR, String dEPT_MANAGER, String dEPT_WRITER,
			String dEPT_ACCOUNTANT, String dEPT_MEMBER, String dEPT_PHOTO_ORNAME, String dEPT_PHOTO_RENAME,
			String dEPT_UPLOAD_YYMM) {
		super();
		DEPT_NO = dEPT_NO;
		DEPT_NAME = dEPT_NAME;
		EDU_TITLE = eDU_TITLE;
		MAIN_WORDS = mAIN_WORDS;
		WORSHIP_OBJECT = wORSHIP_OBJECT;
		WORSHIP_TIME = wORSHIP_TIME;
		WORSHIP_AREA = wORSHIP_AREA;
		DEPT_VISION = dEPT_VISION;
		DEPT_MISSION = dEPT_MISSION;
		DEPT_LEADER = dEPT_LEADER;
		DEPT_HEADER = dEPT_HEADER;
		DEPT_DIRECTOR = dEPT_DIRECTOR;
		DEPT_BUDIRECTOR = dEPT_BUDIRECTOR;
		DEPT_MANAGER = dEPT_MANAGER;
		DEPT_WRITER = dEPT_WRITER;
		DEPT_ACCOUNTANT = dEPT_ACCOUNTANT;
		DEPT_MEMBER = dEPT_MEMBER;
		DEPT_PHOTO_ORNAME = dEPT_PHOTO_ORNAME;
		DEPT_PHOTO_RENAME = dEPT_PHOTO_RENAME;
		DEPT_UPLOAD_YYMM = dEPT_UPLOAD_YYMM;
	}

	public int getDEPT_NO() {
		return DEPT_NO;
	}

	public void setDEPT_NO(int dEPT_NO) {
		DEPT_NO = dEPT_NO;
	}

	public String getDEPT_NAME() {
		return DEPT_NAME;
	}

	public void setDEPT_NAME(String dEPT_NAME) {
		DEPT_NAME = dEPT_NAME;
	}

	public String getEDU_TITLE() {
		return EDU_TITLE;
	}

	public void setEDU_TITLE(String eDU_TITLE) {
		EDU_TITLE = eDU_TITLE;
	}

	public String getMAIN_WORDS() {
		return MAIN_WORDS;
	}

	public void setMAIN_WORDS(String mAIN_WORDS) {
		MAIN_WORDS = mAIN_WORDS;
	}

	public String getWORSHIP_OBJECT() {
		return WORSHIP_OBJECT;
	}

	public void setWORSHIP_OBJECT(String wORSHIP_OBJECT) {
		WORSHIP_OBJECT = wORSHIP_OBJECT;
	}

	public String getWORSHIP_TIME() {
		return WORSHIP_TIME;
	}

	public void setWORSHIP_TIME(String wORSHIP_TIME) {
		WORSHIP_TIME = wORSHIP_TIME;
	}

	public String getWORSHIP_AREA() {
		return WORSHIP_AREA;
	}

	public void setWORSHIP_AREA(String wORSHIP_AREA) {
		WORSHIP_AREA = wORSHIP_AREA;
	}

	public String getDEPT_VISION() {
		return DEPT_VISION;
	}

	public void setDEPT_VISION(String dEPT_VISION) {
		DEPT_VISION = dEPT_VISION;
	}

	public String getDEPT_MISSION() {
		return DEPT_MISSION;
	}

	public void setDEPT_MISSION(String dEPT_MISSION) {
		DEPT_MISSION = dEPT_MISSION;
	}

	public String getDEPT_LEADER() {
		return DEPT_LEADER;
	}

	public void setDEPT_LEADER(String dEPT_LEADER) {
		DEPT_LEADER = dEPT_LEADER;
	}

	public String getDEPT_HEADER() {
		return DEPT_HEADER;
	}

	public void setDEPT_HEADER(String dEPT_HEADER) {
		DEPT_HEADER = dEPT_HEADER;
	}

	public String getDEPT_DIRECTOR() {
		return DEPT_DIRECTOR;
	}

	public void setDEPT_DIRECTOR(String dEPT_DIRECTOR) {
		DEPT_DIRECTOR = dEPT_DIRECTOR;
	}

	public String getDEPT_BUDIRECTOR() {
		return DEPT_BUDIRECTOR;
	}

	public void setDEPT_BUDIRECTOR(String dEPT_BUDIRECTOR) {
		DEPT_BUDIRECTOR = dEPT_BUDIRECTOR;
	}

	public String getDEPT_MANAGER() {
		return DEPT_MANAGER;
	}

	public void setDEPT_MANAGER(String dEPT_MANAGER) {
		DEPT_MANAGER = dEPT_MANAGER;
	}

	public String getDEPT_WRITER() {
		return DEPT_WRITER;
	}

	public void setDEPT_WRITER(String dEPT_WRITER) {
		DEPT_WRITER = dEPT_WRITER;
	}

	public String getDEPT_ACCOUNTANT() {
		return DEPT_ACCOUNTANT;
	}

	public void setDEPT_ACCOUNTANT(String dEPT_ACCOUNTANT) {
		DEPT_ACCOUNTANT = dEPT_ACCOUNTANT;
	}

	public String getDEPT_MEMBER() {
		return DEPT_MEMBER;
	}

	public void setDEPT_MEMBER(String dEPT_MEMBER) {
		DEPT_MEMBER = dEPT_MEMBER;
	}

	public String getDEPT_PHOTO_ORNAME() {
		return DEPT_PHOTO_ORNAME;
	}

	public void setDEPT_PHOTO_ORNAME(String dEPT_PHOTO_ORNAME) {
		DEPT_PHOTO_ORNAME = dEPT_PHOTO_ORNAME;
	}

	public String getDEPT_PHOTO_RENAME() {
		return DEPT_PHOTO_RENAME;
	}

	public void setDEPT_PHOTO_RENAME(String dEPT_PHOTO_RENAME) {
		DEPT_PHOTO_RENAME = dEPT_PHOTO_RENAME;
	}

	public String getDEPT_UPLOAD_YYMM() {
		return DEPT_UPLOAD_YYMM;
	}

	public void setDEPT_UPLOAD_YYMM(String dEPT_UPLOAD_YYMM) {
		DEPT_UPLOAD_YYMM = dEPT_UPLOAD_YYMM;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "NextGenerationVo [DEPT_NO=" + DEPT_NO + ", DEPT_NAME=" + DEPT_NAME + ", EDU_TITLE=" + EDU_TITLE
				+ ", MAIN_WORDS=" + MAIN_WORDS + ", WORSHIP_OBJECT=" + WORSHIP_OBJECT + ", WORSHIP_TIME=" + WORSHIP_TIME
				+ ", WORSHIP_AREA=" + WORSHIP_AREA + ", DEPT_VISION=" + DEPT_VISION + ", DEPT_MISSION=" + DEPT_MISSION
				+ ", DEPT_LEADER=" + DEPT_LEADER + ", DEPT_HEADER=" + DEPT_HEADER + ", DEPT_DIRECTOR=" + DEPT_DIRECTOR
				+ ", DEPT_BUDIRECTOR=" + DEPT_BUDIRECTOR + ", DEPT_MANAGER=" + DEPT_MANAGER + ", DEPT_WRITER="
				+ DEPT_WRITER + ", DEPT_ACCOUNTANT=" + DEPT_ACCOUNTANT + ", DEPT_MEMBER=" + DEPT_MEMBER
				+ ", DEPT_PHOTO_ORNAME=" + DEPT_PHOTO_ORNAME + ", DEPT_PHOTO_RENAME=" + DEPT_PHOTO_RENAME
				+ ", DEPT_UPLOAD_YYMM=" + DEPT_UPLOAD_YYMM + "]";
	}

	
}
