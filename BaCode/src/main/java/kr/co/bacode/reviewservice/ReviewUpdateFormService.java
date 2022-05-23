package kr.co.bacode.reviewservice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bacode.domain.ReviewDAO;
import kr.co.bacode.domain.ReviewVO;

public class ReviewUpdateFormService implements IReviewService {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strReviewNum = request.getParameter("rvNum");
		int reviewNum = Integer.parseInt(strReviewNum);
		ReviewDAO dao = ReviewDAO.getInstance();
		ReviewVO review  = dao.getReviewDetail(reviewNum);
		request.setAttribute("review", review);
	}

}
