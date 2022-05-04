package kr.co.bacode.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
	
	public void insertPick (int pkNum, int postNum, String uId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			String sql = "INSERT INTO pickTbl VALUES(?, ?, pkBdate=now(), ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pkNum);
			pstmt.setInt(2, postNum);
			pstmt.setString(3, uId);
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
}
