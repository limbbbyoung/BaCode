package kr.co.bacode.pickservice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bacode.domain.BoardDAO;
import kr.co.bacode.domain.BoardVO;
import kr.co.bacode.domain.PickDAO;

public class PickDeleteService implements IPickService {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strPkNum = request.getParameter("pkNum");
		String pickTitle = request.getParameter("pickTitle");
		int pkNum = Integer.parseInt(strPkNum);
		PickDAO dao = PickDAO.getInstance();
		dao.pickDelete(pkNum, pickTitle);
		
		
		String strPostNum = request.getParameter("postNum");
		int postNum = Integer.parseInt(strPostNum);
		BoardDAO dao1 = BoardDAO.getInstance();
		BoardVO board = dao1.getBoardDetail(postNum);
		request.setAttribute("board" , board);
	}

}
