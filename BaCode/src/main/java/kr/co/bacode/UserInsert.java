package kr.co.bacode;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bacode.domain.userDAO;
/**
 * Servlet implementation class userInsert
 */
@WebServlet("/userInsert")
public class UserInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// 접속 디버깅
		System.out.println("/userInsert 접속");
		// DAO 생성 및 싱글턴 패턴 
		userDAO dao = userDAO.getInstance();
        // Form에서 데이터 받아오기
		String uId = request.getParameter("uId");
		String uPw = request.getParameter("uPw");
		String uName = request.getParameter("uName");
		String email = request.getParameter("email");
		String pNum = request.getParameter("pNum");
		String addr = request.getParameter("addr");
		String nckName = request.getParameter("uckName");
		// DAO에서 회원가입 메서드 실행
		dao.joinUser(uId, uPw, uName, email, pNum, addr, nckName);
		// 회원가입 성공시 Welcome창으로 리다이렉트
		response.sendRedirect("http://localhost:52525/BaCode/user/userWelcome.jsp");
	}

}
