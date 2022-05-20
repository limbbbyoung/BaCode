package kr.co.bacode.boardservice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.bacode.domain.BoardDAO;

public class BoardInsertService implements IBoardService {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		request.setCharacterEncoding("utf-8");
		// 접속 디버깅
		System.out.println("/boardInsert 접속");
		// DAO 생성 및 싱글턴 패턴 
		BoardDAO bdao = BoardDAO.getInstance();
        // Form에서 Parameter로 관련된 값 받아오기
		String uId = (String)session.getAttribute("s_id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String categori = request.getParameter("categori");
		// BoardDAO에서 게시판 등록 메서드 실행
		bdao.insertBoard(uId, title, content, categori);
		
	}

}
