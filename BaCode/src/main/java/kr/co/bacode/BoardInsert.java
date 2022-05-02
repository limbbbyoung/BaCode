package kr.co.bacode;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.bacode.domain.BoardDAO;
import kr.co.bacode.domain.userDAO;

/**
 * Servlet implementation class BoardInsert
 */
@WebServlet("/boardInsert")
public class BoardInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardInsert() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		// boardList로 돌아가거나 내 상품 목록으로 이동하기(일단 메인 검색창으로)
		response.sendRedirect("http://localhost:52525/BaCode/user/mainSearch.jsp");
	}

}
