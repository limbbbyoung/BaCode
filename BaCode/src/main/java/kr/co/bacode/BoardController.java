package kr.co.bacode;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bacode.boardservice.BoardDeleteService;
import kr.co.bacode.boardservice.BoardInsertFormService;
import kr.co.bacode.boardservice.BoardInsertService;
import kr.co.bacode.boardservice.BoardUpdateFormService;
import kr.co.bacode.boardservice.BoardUpdateService;
import kr.co.bacode.boardservice.GetBoardDetailService;
import kr.co.bacode.boardservice.GetBoardListService;
import kr.co.bacode.boardservice.IBoardService;
import kr.co.bacode.domain.userDAO;

/**
 * Servlet implementation class BoardController
 */
@WebServlet("*.board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}
	
	protected void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String ui = null;
		userDAO dao = userDAO.getInstance();
		IBoardService sv = null;
		
		if(uri.equals("/BaCode/getBoardList.board")) {
			sv = new GetBoardListService();
			sv.execute(request, response);
			ui = "/board/getBoardList.jsp";
		} else if (uri.equals("/BaCode/getBoardDetail.board")) {
			sv = new GetBoardDetailService();
			sv.execute(request, response);
			ui = "/board/boardDetail.jsp?postnum=" + request.getParameter("postnum");
		} else if(uri.equals("/BaCode/boardInsertForm.board")) {
			sv = new BoardInsertFormService();
			sv.execute(request, response);
			ui = "/board/boardInsertForm.jsp";
		} else if(uri.equals("/BaCode/boardInsert.board")) {
			sv = new BoardInsertService();
			sv.execute(request, response);
			ui = "getBoardList.board";
		} else if(uri.equals("/BaCode/boardUpdateForm.board")) {
			sv = new BoardUpdateFormService();
			sv.execute(request, response);
			ui = "/board/boardUpdateForm.jsp";
		} else if(uri.equals("/BaCode/boardUpdate.board")) {
			sv = new BoardUpdateService();
			sv.execute(request, response);
			ui = "getBoardDetail.board?postnum=" + request.getParameter("postnum");
		} else if(uri.equals("/BaCode/boardDelete.board")) {
			sv = new BoardDeleteService();
			sv.execute(request, response);
			ui = "getBoardList.board";
		}
		
		RequestDispatcher dp = request.getRequestDispatcher(ui);
		dp.forward(request, response);
	}
}
