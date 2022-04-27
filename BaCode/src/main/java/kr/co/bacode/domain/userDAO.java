package kr.co.bacode.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class userDAO {
	private DataSource ds;
	    // DAO 생성
		private static userDAO dao = new userDAO();
		
		private userDAO() {
			try {
				Context ct = new InitialContext();
				ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }
		// 싱글턴 패턴
		public static userDAO getInstance() {
			if(dao == null) {
				dao = new userDAO();
			}
			return dao;
		}
		// joinUser(임병영)
		public void joinUser(String uId, String uPw, String uName, String email, String pNum, String addr, String nckName) {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = ds.getConnection();
				String sql = "INSERT INTO userTbl(uid, upw, uname, email, p_num, addr, nck_name) VALUES(?, ?, ?, ?, ?, ?, ?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, uId);
				pstmt.setString(2, uPw);
				pstmt.setString(3, uName);
				pstmt.setString(4, email);
				pstmt.setString(5, pNum);
				pstmt.setString(6, addr);
				pstmt.setString(7, nckName);
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
		}
		// userUpdate(박재현님)
		public void userUpdate(String uId, String uPw, String uName, String email, String pNum, String addr, String nckName) {
    		Connection con = null;
    		PreparedStatement pstmt = null;
    		try {
    			
    			con = ds.getConnection();
    			String up = "UPDATE userTbl SET upw=?, uname=?, email=?, p_num=?, addr=?, nck_name=? WHERE uid = ?";
    			pstmt  = con.prepareStatement(up);
    			pstmt.setString(1, uPw);
    			pstmt.setString(2, uName);
    			pstmt.setString(3, email);
    			pstmt.setString(4, pNum);
    			pstmt.setString(5, addr);
    			pstmt.setString(6, nckName);
    			pstmt.setString(7, uId);
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
		// userDelete(박재현님)
    	public void userDelete(String uId){
    		Connection con = null;
    		PreparedStatement pstmt = null;
    		try {
    			// 연결해주세요.
    			con = ds.getConnection();
    			String sql = "DELETE FROM userTbl WHERE uid = ?";
    			pstmt = con.prepareStatement(sql);

    			pstmt.setString(1, uId);

    			pstmt.executeUpdate();
    		}catch(Exception e) {
    			e.printStackTrace();
    		}finally {
    			try {
    			// con, pstmt 닫기
    				con.close();
    				pstmt.close();
    			} catch(Exception e) {
    				e.printStackTrace();
    			}
    		}
    	}
    	// userDetail(박재현님)
    	public userVO getUserDetail(String uId) {
    		Connection con = null;
    		PreparedStatement pstmt = null;
    		ResultSet rs = null;
    		userVO user = new userVO();
    		try {

    			con = ds.getConnection();
    			String sql = "SELECT * FROM userTbl WHERE uid = ?";
    			pstmt = con.prepareStatement(sql);
    			pstmt.setString(1, uId); 
    			rs = pstmt.executeQuery();
    			if(rs.next()) {
    				user.setuId(rs.getString(1));
    				user.setuPw(rs.getString(2));
    				user.setuName(rs.getString(3));
    				user.setEmail(rs.getString(4));
    				user.setHeart(rs.getInt(5));
    				user.setpNum(rs.getString(6));
    				user.setAddr(rs.getString(7));
    				user.setNckName(rs.getString(8));
    			} 
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
    		return user;
    	}
    	// LoginCheck(이충현님)
    	public userVO userLoginCheck(String userId) {
        	Connection con = null;
        	ResultSet rs = null;
        	PreparedStatement pstmt = null;
        	
        	userVO user = new userVO();
        
        	try {
        		con = ds.getConnection();
        		
        		String sql = "SELECT * FROM usertbl WHERE uid=?";  
        		pstmt = con.prepareStatement(sql);
        		pstmt.setString(1, userId);
        		rs = pstmt.executeQuery(); 
        		System.out.println("데이터 입력 전 : " + user);
        		if(rs.next()); {
        			user.setuId(rs.getString(1));
            		user.setuPw(rs.getString(2));
        		}
        		System.out.println("데이터 입력 후 : " + user);
        	} catch (Exception e) {
        		e.printStackTrace();
        	} finally {
        		try {
        			con.close();
        			rs.close();
        			pstmt.close();
        		} catch(Exception e) {
        			e.printStackTrace();
        		}
        	}
        	return user;
        } // userLoginCheck 끝나는 지점

}
