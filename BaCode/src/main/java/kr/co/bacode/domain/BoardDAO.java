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
			String sql = "INSERT INTO tradeTbl(uid, title, content, catego) VALUES(?, ?, ?, ?)";
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
	public List<BoardVO> getBoardList(int pageNum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardVO> boardList = new ArrayList<>();
		try {
			con = ds.getConnection();
			int limitNum = (pageNum -1)*10;
			String sql = "SELECT * FROM tradeTbl ORDER BY postnum DESC limit ?, 10";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, limitNum);
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
	// Update 기능을 수행하는 소스코드
	public void boardUpdate(String title, String content, String catego, int postNum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			
			con = ds.getConnection();
			String up = "UPDATE tradeTbl SET title=?, content=?, uDate=now(), catego=? WHERE postnum=?";
			pstmt  = con.prepareStatement(up);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setString(3, catego);
			pstmt.setInt(4, postNum);
			pstmt.executeUpdate();
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			try {
				con.close();
				pstmt.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
			}
		}
	// Detail 기능
	public BoardVO getBoardDetail(int boardNum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		BoardVO board = new BoardVO();
		
		try {
			con = ds.getConnection();
			String sql = "SELECT * FROM tradeTbl WHERE postnum=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, boardNum);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				board.setPostNum(rs.getInt(1));
				board.setuId(rs.getString(2));
				board.setTitle(rs.getString(3));
				board.setContent(rs.getString(4));
				board.setBdate(rs.getDate(5));
				board.setMdate(rs.getDate(6));
				board.setCatego(rs.getString(7));
				board.setHeart_num(rs.getInt(8));
				board.setHit(rs.getInt(9));
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
		return board;
	} // getBoardDetail 종료지점
	// delete 기능
	public void boardDelete(int postNum){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			String sql = "DELETE FROM tradeTbl WHERE postnum = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, postNum);
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
	} // delete 종료지점
	
	// 조회수 기능 관련 메서드
	public void upHit(int boardNum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			String sql = "UPDATE tradeTbl SET hit = hit + 1 WHERE postnum=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, boardNum);
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
	} // 조회수 증가 로직 끝
	
	// 전체 게시글의 갯수를 가져오는 메서드
	public int getBoardCount() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int boardCount = 0;
		try {
			con = ds.getConnection();
			String sql = "SELECT count(*) FROM tradeTbl";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();	

			if(rs.next()) {
				boardCount = rs.getInt(1);
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
		return boardCount;
	} // getBoardCount 메서드 끝나는 지점
	
	// 카테고리의 글만 불러오기
	public List<BoardVO> getBoardListCatego(String catego, int pageNum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardVO> boardList = new ArrayList<>();
		try {
			con = ds.getConnection();
			int limitNum = (pageNum -1)*10;
			String sql = "SELECT * FROM tradeTbl WHERE catego = ? ORDER BY postnum DESC limit ?, 10";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, catego);
			pstmt.setInt(2, limitNum);
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
	
	// 카테고리별 글 불러오기시 필요한 글 갯수 메서드
	public int getBoardCountCatego(String catego) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int boardCount = 0;
		try {
			con = ds.getConnection();
			String sql = "SELECT count(*) FROM tradeTbl WHERE catego=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, catego);
			rs = pstmt.executeQuery();	

			if(rs.next()) {
				boardCount = rs.getInt(1);
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
		return boardCount;
	} // getBoardCountCatego 메서드 끝나는 지점
	
}
	

