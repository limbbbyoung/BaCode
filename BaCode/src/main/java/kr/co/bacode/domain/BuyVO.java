package kr.co.bacode.domain;

import java.util.Date;

public class BuyVO {
		private int buyNum;
		private String uId;
		private int postNum;
		private Date buyBdate;
		private String buyTitle;
		public int getBuyNum() {
			return buyNum;
		}
		public void setBuyNum(int buyNum) {
			this.buyNum = buyNum;
		}
		public String getuId() {
			return uId;
		}
		public void setuId(String uId) {
			this.uId = uId;
		}
		public int getPostNum() {
			return postNum;
		}
		public void setPostNum(int postNum) {
			this.postNum = postNum;
		}
		public Date getBuyBdate() {
			return buyBdate;
		}
		public void setBuyBdate(Date buyBdate) {
			this.buyBdate = buyBdate;
		}
		public String getBuyTitle() {
			return buyTitle;
		}
		public void setBuyTitle(String buyTitle) {
			this.buyTitle = buyTitle;
		}
		@Override
		public String toString() {
			return "BuyVO [buyNum=" + buyNum + ", uId=" + uId + ", postNum=" + postNum + ", buyBdate=" + buyBdate
					+ ", buyTitle=" + buyTitle + "]";
		}

}
