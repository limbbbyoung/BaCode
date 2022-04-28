package kr.co.bacode.domain;

import java.sql.Date;

public class BoardVO {
	private String uId;
    private String title;
    private String content;
    private Date bdate;
    private Date mdate;
    private String catego;
    private int heart_num;
    private int hit;
    
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getBdate() {
		return bdate;
	}
	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}
	public Date getMdate() {
		return mdate;
	}
	public void setMdate(Date mdate) {
		this.mdate = mdate;
	}
	public String getCatego() {
		return catego;
	}
	public void setCatego(String catego) {
		this.catego = catego;
	}
	public int getHeart_num() {
		return heart_num;
	}
	public void setHeart_num(int heart_num) {
		this.heart_num = heart_num;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	@Override
	public String toString() {
		return "BoardVO [uId=" + uId + ", title=" + title + ", content=" + content + ", bdate=" + bdate + ", mdate="
				+ mdate + ", catego=" + catego + ", heart_num=" + heart_num + ", hit=" + hit + "]";
	}
    
}
