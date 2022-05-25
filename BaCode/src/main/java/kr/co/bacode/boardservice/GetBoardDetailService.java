package kr.co.bacode.boardservice;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.bacode.domain.BoardDAO;
import kr.co.bacode.domain.BoardVO;
import kr.co.bacode.domain.BuyDAO;
import kr.co.bacode.domain.BuyVO;
import kr.co.bacode.domain.PickDAO;
import kr.co.bacode.domain.PickVO;

public class GetBoardDetailService implements IBoardService {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strBoardNum = request.getParameter("postnum");
		int boardNum = Integer.parseInt(strBoardNum);
		System.out.println("조회된 번호 : " + boardNum);  
		BoardDAO dao = BoardDAO.getInstance();
		// 조회수 증가
		dao.upHit(boardNum);
		
		HttpSession session = request.getSession();
		String pickUid = (String)session.getAttribute("s_id");
		
		PickDAO dao1 = PickDAO.getInstance();
		PickVO pick = dao1.getPickList(boardNum, pickUid);
		request.setAttribute("pick", pick);
		
		BoardVO board = dao.getBoardDetail(boardNum);
		request.setAttribute("board" , board);
		
		BuyDAO bdao = BuyDAO.getInstance();
		List<BuyVO> allbuy = bdao.getAllBuyList();
		request.setAttribute("allbuy", allbuy);
		System.out.println(allbuy);
	}

}
