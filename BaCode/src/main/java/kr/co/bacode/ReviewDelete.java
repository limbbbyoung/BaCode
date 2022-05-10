package kr.co.bacode;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bacode.domain.BoardDAO;
import kr.co.bacode.domain.ReviewDAO;

/**
 * Servlet implementation class ReviewDelete
 */
@WebServlet("/reviewDelete")
public class ReviewDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strReviewNum = request.getParameter("rvNum");
		int reviewNum = Integer.parseInt(strReviewNum);
		ReviewDAO dao = ReviewDAO.getInstance();
		dao.reviewDelete(reviewNum);
		response.sendRedirect("http://localhost:52525/BaCode/getReviewList");
	}

}
