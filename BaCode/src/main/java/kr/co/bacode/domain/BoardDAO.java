package kr.co.bacode.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {
	private DataSource ds;
    // DAO 생성
	private static BoardDAO bdao = new BoardDAO();
	
	private BoardDAO() {
		try {
			Context ct = new InitialContext();
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	// 싱글턴 패턴
	public static BoardDAO getInstance() {
		if(bdao == null) {
			bdao = new BoardDAO();
		}
		return bdao;
	}
	// 게시판 글 등록 
	public void insertBoard(String uId, String title, String content, String catego) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			String sql = "INSERT INTO userTbl(uid, title, content, catego) VALUES(?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, uId);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			pstmt.setString(4, catego);
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
	} // insertBoard 끝나는 지점
	
}
