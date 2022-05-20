package kr.co.bacode.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ManagerDAO {
	private DataSource ds;
    // DAO 생성
	private static ManagerDAO mdao = new ManagerDAO();
	
	private ManagerDAO() {
		try {
			Context ct = new InitialContext();
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	// 싱글턴 패턴
	public static ManagerDAO getInstance() {
		if(mdao == null) {
			mdao = new ManagerDAO();
		}
		return mdao;
	}
	
	// getManagerList
	public List<ManagerVO> getManagerList(int pageNum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ManagerVO> managerList = new ArrayList<>();
		try {
			con = ds.getConnection();
			int limitNum = (pageNum -1)*10;
			String sql = "SELECT * FROM managerTbl ORDER BY mng_num DESC limit ?, 10";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, limitNum);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ManagerVO manager = new ManagerVO();
				manager.setMngNum(rs.getInt(1));
				manager.setuId(rs.getString(2));
				manager.setBdate(rs.getDate(3));
				managerList.add(manager);
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
		return managerList;
	} // getManagerList 끝나는 지점
	
	// getManagerDetail
	public ManagerVO getManagerDetail(String uId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ManagerVO manager = new ManagerVO();
		
		try {
			con = ds.getConnection();
			String sql = "SELECT * FROM managerTbl WHERE uid=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, uId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				manager.setMngNum(rs.getInt(1));
				manager.setuId(rs.getString(2));
				manager.setBdate(rs.getDate(3));
				}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				pstmt.close();
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return manager;
	} // getManagerDetail 종료지점
	
	

}
