package kr.co.bacode.buyservice;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.bacode.domain.BoardButtonDTO;
import kr.co.bacode.domain.BoardDAO;
import kr.co.bacode.domain.BuyDAO;
import kr.co.bacode.domain.BuyVO;

public class GetBuyListService implements IBuyService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String uId = (String)session.getAttribute("s_id");
		String strPostNum = request.getParameter("postNum");
		//int postNum = Integer.parseInt(strPostNum);
		String strPageNum = request.getParameter("pageNum");
		int pageNum = 1;
		if(strPageNum != null) {
		    pageNum = Integer.parseInt(strPageNum);
		} 
		BuyDAO dao = BuyDAO.getInstance();
		int buyCount = dao.getBuyCount(uId);
	    BoardButtonDTO buttons = new BoardButtonDTO(buyCount, pageNum); 
	    request.setAttribute("buttons", buttons);
	    
	    List<BuyVO> buyList = dao.getBuyList(uId, pageNum);
		System.out.println(buyList);
		
		
		BoardDAO boardDao = BoardDAO.getInstance();
		// BoardVO board = boardDao.getBoardDetail(postNum);

		// request.setAttribute("board" , board);
		request.setAttribute("buyList", buyList);
	}
}
