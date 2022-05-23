package kr.co.bacode.reviewservice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.bacode.domain.BoardDAO;
import kr.co.bacode.domain.BoardVO;

public class ReviewInsertFormService implements IReviewService {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession();
		 String uId = (String)session.getAttribute("s_id");
		 String strPostNum = request.getParameter("postNum");
		 int postNum = Integer.parseInt(strPostNum);
		 BoardDAO dao = BoardDAO.getInstance();
		 BoardVO board = dao.getBoardDetail(postNum);
		 request.setAttribute("board" , board);
		 request.setAttribute("uId", uId);
		 request.setAttribute("postNum", postNum);
	}

}

