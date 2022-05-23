package kr.co.bacode.reviewservice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.bacode.domain.ReviewDAO;
import kr.co.bacode.domain.userDAO;

public class ReviewInsertService implements IReviewService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		// 접속 디버깅
		System.out.println("/reviewInsert 접속");
		// DAO 생성 및 싱글턴 패턴 
		ReviewDAO dao = ReviewDAO.getInstance();
		userDAO uDao = userDAO.getInstance();
		String btnradio = request.getParameter("btnradio");
		System.out.println(btnradio);
		String selUid = request.getParameter("selUid");
		String strPostNum = request.getParameter("postNum");
		int postNum = Integer.parseInt(strPostNum);
		String uId = (String)session.getAttribute("s_id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		// ReviewDAO에서 게시판 등록 메서드 실행
		dao.insertReview(postNum, uId, title, content);
		
		if (btnradio.equals("angry")) {
		 uDao.downHeart(selUid);
		} else if(btnradio.equals("heartEyes")) {
			uDao.upHeart(selUid);
		} 
	}
}
