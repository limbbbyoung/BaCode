package kr.co.bacode.buyservice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.bacode.domain.BoardDAO;
import kr.co.bacode.domain.BoardVO;
import kr.co.bacode.domain.BuyDAO;
import kr.co.bacode.domain.BuyVO;


public class BuyInsertService implements IBuyService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("utf-8");
		
		// buyinsert 불러오기
		String strPostNum = request.getParameter("postNum");
		int postNum = Integer.parseInt(strPostNum);
		String uId = (String)session.getAttribute("s_id");
		String title = request.getParameter("title");
		BuyDAO dao = BuyDAO.getInstance();
		dao.insertBuy(postNum, uId, title);
		BuyVO buy = dao.getBuyList(postNum, uId);
		
		// Detail 페이지로 가기위한 boardDAO 생성
		BoardDAO boardDao = BoardDAO.getInstance();
		BoardVO board = boardDao.getBoardDetail(postNum);
		request.setAttribute("board" , board);
		
		request.setAttribute("buy" , buy);
	}

}
