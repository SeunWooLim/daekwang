package kr.or.daekwang.admin.model.vo;

public class AdminVo {
	public static final long serialVersionUID = 23L;
	
	private int RNUM;
	
	
	public AdminVo(){}


	public AdminVo(int rNUM) {
		super();
		RNUM = rNUM;
	}


	public int getRNUM() {
		return RNUM;
	}


	public void setRNUM(int rNUM) {
		RNUM = rNUM;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "AdminVo [RNUM=" + RNUM + "]";
	}
	
	
}
