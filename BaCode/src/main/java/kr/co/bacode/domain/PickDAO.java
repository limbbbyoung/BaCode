package kr.co.bacode.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class PickDAO {
	private DataSource ds;
	
	private static PickDAO pdao = new PickDAO();
	
	private PickDAO() {
		try {
			Context ct = new InitialContext();
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// 싱글턴 패턴
	public static PickDAO getInstance() {
		if(pdao == null) {
			pdao = new PickDAO();
		}
		return pdao;
	}
	
	public void insertPick (int postNum, String uId, String title) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			String sql = "INSERT INTO pickTbl(postnum, uid, pick_title) VALUES(?, ?, ?)";
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
	} // insertPick 종료지점
	
	// pick 테이블 전체 조회
	public List<PickVO> getPickList(String uId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<PickVO> pickList = new ArrayList<>();
		try {
			con = ds.getConnection();
			String sql = "SELECT * FROM pickTbl WHERE uid= ? ORDER BY pk_num DESC";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, uId);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				PickVO pick = new PickVO();
				pick.setPkNum(rs.getInt(1));
				pick.setPkBdate(rs.getDate(2));
				pick.setPostNum(rs.getInt(3));
				pick.setuId(rs.getString(4));
				pick.setPkTitle(rs.getString(5));
				pickList.add(pick);
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
		return pickList;
	} // getPickList 종료지점
	
	public PickVO getPickList(int postNum, String uid) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PickVO pick = new PickVO();
		try {
			con = ds.getConnection();
			String sql = "SELECT * FROM pickTbl WHERE postnum=? and uid=?" ;
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, postNum);
			pstmt.setString(2, uid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				pick.setPkNum(rs.getInt(1));
				pick.setPkBdate(rs.getDate(2));
				pick.setPostNum(rs.getInt(3));
				pick.setuId(rs.getString(4));
				pick.setPkTitle(rs.getString(5));
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
		return pick;
	}
}
