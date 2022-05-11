package kr.co.bacode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bacode.domain.ReviewDAO;


/**
 * Servlet implementation class ReviewUpdate
 */
@WebServlet("/reviewUpdate")
public class ReviewUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String strReviewNum = request.getParameter("rvNum");
		int reviewNum = Integer.parseInt(strReviewNum);
		ReviewDAO dao = ReviewDAO.getInstance();
		dao.reviewUpdate(title, content, reviewNum);
		response.sendRedirect("http://localhost:52525/BaCode/getReviewDetail?rvNum=" + reviewNum);
	}

}
