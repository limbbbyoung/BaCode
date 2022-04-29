package kr.co.bacode.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
	
	// 게시판 리스트 보기
	public List<BoardVO> getBoardList() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardVO> boardList = new ArrayList<>();
		try {
			con = ds.getConnection();
			String sql = "SELECT * FROM tradeTbl ORDER BY postnum DESC";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardVO boardUser = new BoardVO();
				boardUser.setPostNum(rs.getInt(1));
				boardUser.setuId(rs.getString(2));
				boardUser.setTitle(rs.getString(3));
				boardUser.setContent(rs.getString(4));
				boardUser.setBdate(rs.getDate(5));
				boardUser.setMdate(rs.getDate(6));
				boardUser.setCatego(rs.getString(7));
				boardUser.setHeart_num(rs.getInt(8));
				boardUser.setHit(rs.getInt(9));
				boardList.add(boardUser);
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
		return boardList;
	}
		
	}
	

