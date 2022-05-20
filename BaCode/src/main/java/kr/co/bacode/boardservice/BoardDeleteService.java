package kr.co.bacode.boardservice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bacode.domain.BoardDAO;

public class BoardDeleteService implements IBoardService {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strPostNum = request.getParameter("postNum");
		int postNum = Integer.parseInt(strPostNum);
		BoardDAO dao = BoardDAO.getInstance();
		dao.boardDelete(postNum);
		
	}

}
