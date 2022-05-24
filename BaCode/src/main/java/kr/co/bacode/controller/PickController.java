package kr.co.bacode.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bacode.SOSService.GetSOSListService;
import kr.co.bacode.boardservice.BoardDeleteService;
import kr.co.bacode.buyservice.BuyInsertService;
import kr.co.bacode.pickservice.GetPickListService;
import kr.co.bacode.pickservice.IPickService;
import kr.co.bacode.pickservice.PickDeleteService;
import kr.co.bacode.pickservice.PickInsertService;

/**
 * Servlet implementation class PickController
 */
@WebServlet("*.pick")
public class PickController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PickController() {
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
		IPickService sv = null;
		if(uri.equals("/BaCode/getPickList.pick")) {
			sv = new GetPickListService();
			sv.execute(request, response);
			ui = "/pick/getPickList.jsp";
		} else if(uri.equals("/BaCode/pickInsert.pick")) {
			sv = new PickInsertService();
			sv.execute(request, response);
			ui = "/board/boardDetail.jsp?postnum=" + request.getParameter("postnum");
		} else if(uri.equals("/BaCode/pickDelete.pick")) {
			sv = new PickDeleteService();
			sv.execute(request, response);
			ui = "/board/boardDetail.jsp?postnum=" + request.getParameter("postnum");
		}
		RequestDispatcher dp = request.getRequestDispatcher(ui);
		dp.forward(request, response);
}
}
