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
	
	public void insertPick (int postNum, String uId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			String sql = "INSERT INTO pickTbl(postnum, uid) VALUES(?, ?)";
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
	} // insertPick 종료지점
	
	// pick 테이블 전체 조회
	public List<PickVO> getPickList() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<PickVO> pickList = new ArrayList<>();
		try {
			con = ds.getConnection();
			String sql = "SELECT * FROM pickTbl ORDER BY pk_num DESC";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				PickVO pick = new PickVO();
				pick.setPkNum(rs.getInt(1));
				pick.setPkBdate(rs.getDate(2));
				pick.setPostNum(rs.getInt(3));
				pick.setuId(rs.getString(4));
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
	
	public List<PickVO> getPickIdList(String uid, int postNum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<PickVO> pickIdList = new ArrayList<>();
		try {
			con = ds.getConnection();
			String sql = "SELECT * FROM pickTbl WHERE uid=? and postnum=?" ;
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				PickVO pick = new PickVO();
				pick.setuId(rs.getString(1));
				pickIdList.add(pick);
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
		return pickIdList;
	}
}
