package kr.co.bacode;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bacode.domain.BoardDAO;
import kr.co.bacode.domain.BoardVO;

/**
 * Servlet implementation class GetBoardList
 */
@WebServlet("/getBoardList")
public class GetBoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetBoardList() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO bdao = BoardDAO.getInstance();
		List<BoardVO> boardList = bdao.getBoardList();
		System.out.println(boardList);
		request.setAttribute("boardList", boardList);
		RequestDispatcher dp = request.getRequestDispatcher("/user/getBoardList.jsp");
		dp.forward(request, response);
	}
}
