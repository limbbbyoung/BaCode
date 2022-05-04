package kr.co.bacode.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ReviewDAO {
	private DataSource ds;
    // DAO 생성
	private static ReviewDAO dao = new ReviewDAO();
	
	private ReviewDAO() {
		try {
			Context ct = new InitialContext();
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	// 싱글턴 패턴
	public static ReviewDAO getInstance() {
		if(dao == null) {
			dao = new ReviewDAO();
		}
		return dao;
	}
	public void insertReview(int postNum, String uId, String title, String content) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			String sql = "INSERT INTO reviewTbl(postnum, uid, title, content) VALUES(?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, postNum);
			pstmt.setString(2, uId);
			pstmt.setString(3, title);
			pstmt.setString(4, content);
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally { 
			try {
				con.close();
				pstmt.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}	
	} // insertReview 끝나는 지점
	
	// 리뷰 리스트 보기
	public List<ReviewVO> getReviewList() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ReviewVO> reviewList = new ArrayList<>();
		try {
			con = ds.getConnection();
			String sql = "SELECT * FROM reviewTbl ORDER BY rv_num DESC";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ReviewVO review = new ReviewVO();
				review.setRvNum(rs.getInt(1));
				review.setPostNum(rs.getInt(2));
				review.setuId(rs.getString(3));
				review.setRvTitle(rs.getString(4));
				review.setRvContent(rs.getString(5));
				review.setRvBdate(rs.getDate(6));
				review.setRvUdate(rs.getDate(7));
				reviewList.add(review);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally { 
			try {
			con.close();
			pstmt.close();
			rs.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return reviewList;
	} // 리뷰 리스트 끝나는 지점
}
