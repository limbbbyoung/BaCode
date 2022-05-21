package kr.co.bacode.domain;

import java.sql.Date;

public class PickVO {
	private int pkNum;
	private Date pkBdate;
	private int postNum;
	private String uId;
	private String pkTitle;
	public int getPkNum() {
		return pkNum;
	}
	public void setPkNum(int pkNum) {
		this.pkNum = pkNum;
	}
	public Date getPkBdate() {
		return pkBdate;
	}
	public void setPkBdate(Date pkBdate) {
		this.pkBdate = pkBdate;
	}
	public int getPostNum() {
		return postNum;
	}
	public void setPostNum(int postNum) {
		this.postNum = postNum;
	}
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	public String getPkTitle() {
		return pkTitle;
	}
	public void setPkTitle(String pkTitle) {
		this.pkTitle = pkTitle;
	}
	@Override
	public String toString() {
		return "PickVO [pkNum=" + pkNum + ", pkBdate=" + pkBdate + ", postNum=" + postNum + ", uId=" + uId
				+ ", pkTitle=" + pkTitle + "]";
	}

}
