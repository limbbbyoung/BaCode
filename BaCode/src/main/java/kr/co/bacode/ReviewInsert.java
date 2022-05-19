package kr.co.bacode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.bacode.domain.ReviewDAO;

/**
 * Servlet implementation class ReviewInsert
 */
@WebServlet("/reviewInsert")
public class ReviewInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewInsert() {
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
		System.out.println("/reviewInsert 접속");
		// DAO 생성 및 싱글턴 패턴 
		ReviewDAO dao = ReviewDAO.getInstance();
		String angry = request.getParameter("angry");
		System.out.println(angry);
		String selUid = request.getParameter("selUid");
		String strPostNum = request.getParameter("postNum");
		int postNum = Integer.parseInt(strPostNum);
		String uId = (String)session.getAttribute("s_id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		// ReviewDAO에서 게시판 등록 메서드 실행
		dao.insertReview(postNum, uId, title, content);
		response.sendRedirect("http://localhost:52525/BaCode/getReviewList");
	}

}
