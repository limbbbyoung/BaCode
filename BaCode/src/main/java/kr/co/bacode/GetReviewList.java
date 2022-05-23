package kr.co.bacode;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bacode.domain.BoardButtonDTO;
import kr.co.bacode.domain.BoardDAO;
import kr.co.bacode.domain.BoardVO;
import kr.co.bacode.domain.ReviewDAO;
import kr.co.bacode.domain.ReviewVO;
import kr.co.bacode.domain.SOSDAO;
import kr.co.bacode.domain.SOSVO;

/**
 * Servlet implementation class GetReviewList
 */
@WebServlet("/getReviewList")
public class GetReviewList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetReviewList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 페이징 처리
		/* String strPageNum = request.getParameter("pageNum");
		int pageNum = 1;
		if(strPageNum != null) {
		    pageNum = Integer.parseInt(strPageNum);
		} 
		ReviewDAO dao = ReviewDAO.getInstance();
		int reviewCount = dao.getReviewCount();
	    BoardButtonDTO buttons = new BoardButtonDTO(reviewCount, pageNum); 
	    request.setAttribute("buttons", buttons);
	    
	    List<ReviewVO> reviewList = dao.getReviewList(pageNum);
		System.out.println(reviewList);
		request.setAttribute("reviewList", reviewList);
		RequestDispatcher dp = request.getRequestDispatcher("/review/getReviewList.jsp");
		dp.forward(request, response); */
	}


}
