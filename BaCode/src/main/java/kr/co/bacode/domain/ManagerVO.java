package kr.co.bacode.domain;

import java.sql.Date;

public class ManagerVO {
	private int mngNum;
	private String uId;
	private Date bdate;
	
	public int getMngNum() {
		return mngNum;
	}
	public void setMngNum(int mngNum) {
		this.mngNum = mngNum;
	}
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	public Date getBdate() {
		return bdate;
	}
	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}
	
	@Override
	public String toString() {
		return "ManagerVO [mngNum=" + mngNum + ", uId=" + uId + ", bdate=" + bdate + "]";
	}
	
	

}
