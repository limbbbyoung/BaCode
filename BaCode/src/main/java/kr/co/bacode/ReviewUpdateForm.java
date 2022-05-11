package kr.co.bacode;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bacode.domain.ReviewDAO;
import kr.co.bacode.domain.ReviewVO;

/**
 * Servlet implementation class ReviewUpdateForm
 */
@WebServlet("/reviewUpdateForm")
public class ReviewUpdateForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewUpdateForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String strReviewNum = request.getParameter("rvNum");
		int reviewNum = Integer.parseInt(strReviewNum);
		ReviewDAO dao = ReviewDAO.getInstance();
		ReviewVO review  = dao.getReviewDetail(reviewNum);
		request.setAttribute("review", review);
		RequestDispatcher dp = request.getRequestDispatcher("/review/reviewUpdateForm.jsp");
		dp.forward(request, response);
	}

}
