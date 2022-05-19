package kr.co.bacode.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class SOSDAO {
	private DataSource ds;
    // DAO 생성
	private static SOSDAO sdao = new SOSDAO();
	
	private SOSDAO() {
		try {
			Context ct = new InitialContext();
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	// 싱글턴 패턴
	public static SOSDAO getInstance() {
		if(sdao == null) {
			sdao = new SOSDAO();
		}
		return sdao;
	}
	
	    // 신고글 목록 보러가기
		public List<SOSVO> getSOSList(int pageNum) {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			List<SOSVO> SOSList = new ArrayList<>();
			try {
				con = ds.getConnection();
				int limitNum = (pageNum -1)*10;
				String sql = "SELECT * FROM sosTbl ORDER BY st_num DESC limit ?, 10";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, limitNum);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					SOSVO sos = new SOSVO();
					sos.setStNum(rs.getInt(1));
					sos.setPostNum(rs.getInt(2));
					sos.setStTitle(rs.getString(3));
					sos.setStContent(rs.getString(4));
					sos.setStBdate(rs.getDate(5));
					sos.setStMdate(rs.getDate(6));
					sos.setuId(rs.getString(7));
					sos.setPostCheck(rs.getBoolean(8));
					SOSList.add(sos);
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
			return SOSList;
		}
		
		// 신고글 등록 
		public void insertSOS(int postNum, String stTitle, String stContent, String uId) {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = ds.getConnection();
				String sql = "INSERT INTO sosTbl(postnum, st_title, st_content, uid) VALUES(?, ?, ?, ?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, postNum);
				pstmt.setString(2, stTitle);
				pstmt.setString(3, stContent);
				pstmt.setString(4, uId);
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
		} // insertSOS 끝나는 지점
		
		// 전체 게시글의 갯수를 가져오는 메서드
		public int getSOSCount() {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int SOSCount = 0;
			try {
				con = ds.getConnection();
				String sql = "SELECT count(*) FROM sosTbl";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();	

				if(rs.next()) {
					SOSCount = rs.getInt(1);
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
			return SOSCount;
		} // getSOSCount 메서드 끝나는 지점
		
		// Detail 기능
		public SOSVO getSOSDetail(int stNum) {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			SOSVO sos = new SOSVO();
		
			try {
				con = ds.getConnection();
				String sql = "SELECT * FROM sosTbl WHERE st_num=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, stNum);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					sos.setStNum(rs.getInt(1));
					sos.setPostNum(rs.getInt(2));
					sos.setStTitle(rs.getString(3));
					sos.setStContent(rs.getString(4));
					sos.setStBdate(rs.getDate(5));
					sos.setStMdate(rs.getDate(6));
					sos.setuId(rs.getString(7));
					sos.setPostCheck(rs.getBoolean(8));
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
			return sos;
		} // getSOSDetail 종료지점
		
		// SOSSuccess 기능 중 postcheck DB 적용(신고 완료 기능)
		public int SOSSuccessUpdate(int stNum){
			Connection con = null;
			PreparedStatement pstmt = null; 
			int success = 0;
			try {
				con = ds.getConnection();
				String sql = "UPDATE sosTbl SET postcheck=? WHERE st_num=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, 1);
				pstmt.setInt(2, stNum);
				success = 1;
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
			}  return success;
		} // SOSSuccessUpdate 종료지점

		
		/*// getSOSPostCheck
		public Boolean getSOSPostCheck(int stNum) {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			Boolean checkNum = false;
			try {
				con = ds.getConnection();
				String sql = "SELECT (postcheck) FROM sosTbl WHERE st_num=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, stNum);
				rs = pstmt.executeQuery();
				if(rs.next()){
					
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
			return checkNum;
		} // getSOSPostCheck 종료지점*/
}
