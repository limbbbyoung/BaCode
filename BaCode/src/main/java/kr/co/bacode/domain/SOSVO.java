package kr.co.bacode.domain;

import java.sql.Date;
import java.util.List;

public class SOSVO {
	private int stNum;
	private int postNum;
	private String stTitle;
    private String stContent;
    private Date stBdate;
    private Date stMdate;
	private String uId;
    private boolean postCheck;
    
	public int getStNum() {
		return stNum;
	}
	public void setStNum(int stNum) {
		this.stNum = stNum;
	}
	public int getPostNum() {
		return postNum;
	}
	public void setPostNum(int postNum) {
		this.postNum = postNum;
	}
	public String getStTitle() {
		return stTitle;
	}
	public void setStTitle(String stTitle) {
		this.stTitle = stTitle;
	}
	public String getStContent() {
		return stContent;
	}
	public void setStContent(String stContent) {
		this.stContent = stContent;
	}
	public Date getStBdate() {
		return stBdate;
	}
	public void setStBdate(Date stBdate) {
		this.stBdate = stBdate;
	}
	public Date getStMdate() {
		return stMdate;
	}
	public void setStMdate(Date stMdate) {
		this.stMdate = stMdate;
	}
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	public boolean isPostCheck() {
		return postCheck;
	}
	public void setPostCheck(boolean postCheck) {
		this.postCheck = postCheck;
	}
	
	@Override
	public String toString() {
		return "SosVO [stNum=" + stNum + ", postNum=" + postNum + ", stTitle=" + stTitle + ", stContent=" + stContent
				+ ", stBdate=" + stBdate + ", stMdate=" + stMdate + ", uId=" + uId + ", postCheck=" + postCheck + "]";
	}
    
}
