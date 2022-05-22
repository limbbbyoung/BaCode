package kr.co.bacode.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bacode.SOSService.ISOSService;
import kr.co.bacode.SOSService.getSOSDetailService;
import kr.co.bacode.SOSService.getSOSListService;
import kr.co.bacode.domain.SOSDAO;
import kr.co.bacode.domain.userDAO;

/**
 * Servlet implementation class BoardController
 */
@WebServlet("*.SOS")
public class SOSController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SOSController() {
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
		SOSDAO sdao = sdao.getInstance();
		ISOSService sv = null;
		
		if(uri.equals("/BaCode/getSOSList.SOS")) {
			sv = new getSOSListService();
			sv.execute(request, response);
			ui = "/SOS/getSOSList.jsp";
		} else if (uri.equals("/BaCode/getSOSDetail.SOS")) {
			sv = new getSOSDetailService();
			sv.execute(request, response);
			ui = "/SOS/SOSDetail.jsp?stNum=" + request.getParameter("stNum");
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
