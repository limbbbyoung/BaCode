package kr.co.bacode.domain;

import java.sql.Date;

public class ReviewVO {
	private int rvNum;
	private int postNum;
	private String uId;
	private String rvTitle;
	private String rvContent;
	private Date rvBdate;
	private Date rvUdate;
	public int getRvNum() {
		return rvNum;
	}
	public void setRvNum(int rvNum) {
		this.rvNum = rvNum;
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
	public String getRvTitle() {
		return rvTitle;
	}
	public void setRvTitle(String rvTitle) {
		this.rvTitle = rvTitle;
	}
	public String getRvContent() {
		return rvContent;
	}
	public void setRvContent(String rvContent) {
		this.rvContent = rvContent;
	}
	public Date getRvBdate() {
		return rvBdate;
	}
	public void setRvBdate(Date rvBdate) {
		this.rvBdate = rvBdate;
	}
	public Date getRvUdate() {
		return rvUdate;
	}
	public void setRvUdate(Date rvUdate) {
		this.rvUdate = rvUdate;
	}
	@Override
	public String toString() {
		return "ReviewVO [rvNum=" + rvNum + ", postNum=" + postNum + ", uId=" + uId + ", rvTitle=" + rvTitle
				+ ", rvContent=" + rvContent + ", rvBdate=" + rvBdate + ", rvUdate=" + rvUdate + "]";
	}
	
	
}
