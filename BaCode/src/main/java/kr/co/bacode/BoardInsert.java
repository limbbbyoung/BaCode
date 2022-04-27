package kr.co.bacode;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		request.setCharacterEncoding("utf-8");
		// 접속 디버깅
		System.out.println("/boardInsert 접속");
		// DAO 생성 및 싱글턴 패턴 
		userDAO dao = userDAO.getInstance();
        // Form에서 데이터 받아오기
        // Parameter로 관련된 값 받아오기
		// DAO에서 회원가입 메서드 실행
		// dao.boardInsert 메서드 실행
		// 회원가입 성공시 Welcome창으로 리다이렉트
		// boardList로 돌아가거나 내 상품 목록으로 이동하기
	}

}
