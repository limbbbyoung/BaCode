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
	
	// 자기 찜목록 조회 기능
	public List<PickVO> getPickList(String uId, int pageNum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<PickVO> pickList = new ArrayList<>();
		try {
			con = ds.getConnection();
			int limitNum = (pageNum -1)*10;
			String sql = "SELECT * FROM pickTbl WHERE uid= ? ORDER BY pk_num DESC limit ?, 10";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, uId);
			pstmt.setInt(2, limitNum);
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
	// 내 찜 게시글의 갯수를 가져오는 메서드
	public int getPickCount(String uId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int pickCount = 0;
		try {
			con = ds.getConnection();
			String sql = "SELECT count(*) FROM pickTbl WHERE uid=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, uId);
			rs = pstmt.executeQuery();	
			
			if(rs.next()) {
				pickCount = rs.getInt(1);
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
		return pickCount;
	}
	
	// pick 취소하기 기능
	public void pickDelete(int pkNum, String pickTitle){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			String sql = "DELETE FROM pickTbl WHERE pk_num=? and pick_title=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pkNum);
			pstmt.setString(2, pickTitle);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
				pstmt.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	} // pick 취소 기능구문 종료지점
}
