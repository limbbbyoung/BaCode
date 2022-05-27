package kr.co.bacode.reviewservice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bacode.domain.BoardDAO;
import kr.co.bacode.domain.BoardVO;
import kr.co.bacode.domain.ReviewDAO;
import kr.co.bacode.domain.ReviewVO;

public class GetReviewDetailService implements IReviewService {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strReviewNum = request.getParameter("rvNum");
		int reviewNum = Integer.parseInt(strReviewNum);
		System.out.println("조회된 번호 : " + reviewNum);  
		ReviewDAO rdao = ReviewDAO.getInstance();
		ReviewVO review = rdao.getReviewDetail(reviewNum);
		BoardDAO dao = BoardDAO.getInstance();
		BoardVO board = dao.getBoardDetail(review.getPostNum());
		request.setAttribute("board" , board);
		System.out.println(board);
		request.setAttribute("review" , review);
	}

}
