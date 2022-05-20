package kr.co.bacode.boardservice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bacode.domain.BoardDAO;
import kr.co.bacode.domain.BoardVO;

public class BoardUpdateFormService implements IBoardService {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String strPostNum = request.getParameter("postnum");
		int postNum = Integer.parseInt(strPostNum);
		BoardDAO dao = BoardDAO.getInstance();
		BoardVO board  = dao.getBoardDetail(postNum);
		request.setAttribute("board", board);
		
	}

}
