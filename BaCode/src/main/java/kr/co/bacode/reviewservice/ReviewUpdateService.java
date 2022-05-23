package kr.co.bacode.reviewservice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bacode.domain.ReviewDAO;

public class ReviewUpdateService implements IReviewService {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String strReviewNum = request.getParameter("rvNum");
		int reviewNum = Integer.parseInt(strReviewNum);
		ReviewDAO dao = ReviewDAO.getInstance();
		dao.reviewUpdate(title, content, reviewNum);
	}

}
