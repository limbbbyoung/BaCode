package kr.co.bacode.pickservice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bacode.domain.BoardDAO;
import kr.co.bacode.domain.BoardVO;
import kr.co.bacode.domain.PickDAO;
import kr.co.bacode.domain.PickVO;

public class PickInsertService implements IPickService {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO dao1 = BoardDAO.getInstance();
		
		String pickUid = request.getParameter("pickId");
		String strPickNum = request.getParameter("postNum");
		String title = request.getParameter("title");
		int pickNum = Integer.parseInt(strPickNum);
		PickDAO dao = PickDAO.getInstance();
		dao.insertPick(pickNum, pickUid, title);
		
		BoardVO board = dao1.getBoardDetail(pickNum);
		request.setAttribute("board" , board);
		
		PickVO pick = dao.getPickList(pickNum, pickUid);
		request.setAttribute("pick", pick);
	}

}
