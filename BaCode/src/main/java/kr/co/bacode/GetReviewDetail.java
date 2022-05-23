package kr.co.bacode;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bacode.domain.BoardDAO;
import kr.co.bacode.domain.BoardVO;
import kr.co.bacode.domain.ReviewDAO;
import kr.co.bacode.domain.ReviewVO;

/**
 * Servlet implementation class GetReviewDetail
 */
@WebServlet("/getReviewDetail")
public class GetReviewDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetReviewDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strReviewNum = request.getParameter("rvNum");
		int reviewNum = Integer.parseInt(strReviewNum);
		System.out.println("조회된 번호 : " + reviewNum);  
		ReviewDAO rdao = ReviewDAO.getInstance();
		ReviewVO review = rdao.getReviewDetail(reviewNum);
		BoardDAO dao = BoardDAO.getInstance();
		BoardVO board = dao.getBoardDetail(reviewNum);
		request.setAttribute("board" , board);
		System.out.println(board);
		request.setAttribute("review" , review);
		RequestDispatcher dp = request.getRequestDispatcher("/review/reviewDetail.jsp");
		dp.forward(request, response);
	}

}

