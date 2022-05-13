package kr.co.bacode.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BuyDAO {
	private DataSource ds;
    // DAO 생성
	private static BuyDAO dao = new BuyDAO();
	
	private BuyDAO() {
		try {
			Context ct = new InitialContext();
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	// 싱글턴 패턴
	public static BuyDAO getInstance() {
		if(dao == null) {
			dao = new BuyDAO();
		}
		return dao;
	}
	// insertBuy 시작
	public void insertBuy (int postNum, String uId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			String sql = "INSERT INTO buyTbl(postnum, uid) VALUES(?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, postNum);
			pstmt.setString(2, uId);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				pstmt.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	} // insertBuy 종료
	
	// getBuyList  buy 정보주는 기능
	public BuyVO getBuyList(int postNum, String uid) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BuyVO buy = new BuyVO();
		try {
			con = ds.getConnection();
			String sql = "SELECT * FROM buyTbl WHERE postnum=? and uid=?" ;
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, postNum);
			pstmt.setString(2, uid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				buy.setBuyNum(rs.getInt(1));
				buy.setuId(rs.getString(2));
				buy.setPostNum(rs.getInt(3));
				buy.setBuyBdate(rs.getDate(4));
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
		return buy;
	}
}
