package kr.co.bacode.reviewservice;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bacode.domain.BoardButtonDTO;
import kr.co.bacode.domain.ReviewDAO;
import kr.co.bacode.domain.ReviewVO;

public class GetReviewListService implements IReviewService {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strPageNum = request.getParameter("pageNum");
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
	}

}
