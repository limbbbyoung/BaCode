package kr.co.bacode.domain;

import java.util.Date;

public class BuyVO {
		private int buyNum;
		private String uId;
		private int postNum;
		private Date buyBdate;
		
		public int getBuyNum() {
			return buyNum;
		}
		public void setBuyNum(int buyNum) {
			this.buyNum = buyNum;
		}
		public Date getBuyBdate() {
			return buyBdate;
		}
		public void setBuyBdate(Date buyBdate) {
			this.buyBdate = buyBdate;
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
		@Override
		public String toString() {
			return "BuyVO [buyNum=" + buyNum + ", buyBdate=" + buyBdate + ", postNum=" + postNum + ", uId=" + uId + "]";
		}
		
		
}
