package kr.co.bacode.boardservice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bacode.domain.BoardDAO;

public class BoardUpdateService implements IBoardService {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String catego = request.getParameter("catego");
		String strPostNum = request.getParameter("postnum");
		int postNum = Integer.parseInt(strPostNum);
		BoardDAO dao = BoardDAO.getInstance();
		dao.boardUpdate(title, content, catego, postNum);
		
	}

}
