package kr.co.bacode.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
	public void insertBuy (int postNum, String uId, String title) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			String sql = "INSERT INTO buyTbl(postnum, uid, buy_title) VALUES(?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, postNum);
			pstmt.setString(2, uId);
			pstmt.setString(3, title);
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
	public BuyVO getBuyList(int postNum, String uId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BuyVO buy = new BuyVO();
		try {
			con = ds.getConnection();
			String sql = "SELECT * FROM buyTbl WHERE postnum=? and uid=?" ;
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, postNum);
			pstmt.setString(2, uId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				buy.setBuyNum(rs.getInt(1));
				buy.setuId(rs.getString(2));
				buy.setPostNum(rs.getInt(3));
				buy.setBuyBdate(rs.getDate(4));
				buy.setBuyTitle(rs.getString(5));
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
	// 게시판에서 구매목록 불러오는 메서드
	public List<BuyVO> getBuyList(String uId, int pageNum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BuyVO> buyList = new ArrayList<>();
		try {
			con = ds.getConnection();
			int limitNum = (pageNum -1)*10;
			String sql = "SELECT * FROM buyTbl WHERE uid= ? ORDER BY buyNum DESC limit ?, 10";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, uId);
			pstmt.setInt(2, limitNum);
			rs = pstmt.executeQuery();		
			while(rs.next()) {
				BuyVO buy = new BuyVO();
				buy.setBuyNum(rs.getInt(1));
				buy.setuId(rs.getString(2));
				buy.setPostNum(rs.getInt(3));
				buy.setBuyBdate(rs.getDate(4));
				buy.setBuyTitle(rs.getString(5));
				buyList.add(buy);
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
		return buyList;
	}
	// 내 구매 게시글의 갯수를 가져오는 메서드
	public int getBuyCount(String uId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int buyCount = 0;
		try {
			con = ds.getConnection();
			String sql = "SELECT count(*) FROM buyTbl WHERE uid=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, uId);
			rs = pstmt.executeQuery();	
			
			if(rs.next()) {
				buyCount = rs.getInt(1);
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
		return buyCount;
	}
}
