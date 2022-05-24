package kr.co.bacode.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bacode.buyservice.BuyInsertService;
import kr.co.bacode.buyservice.GetBuyListService;
import kr.co.bacode.buyservice.IBuyService;



/**
 * Servlet implementation class BuyController
 */
@WebServlet("*.buy")
public class BuyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyController() {
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
		IBuyService sv = null;
		
		if(uri.equals("/BaCode/getBuyList.buy")) {
			sv = new GetBuyListService();
			sv.execute(request, response);
			ui = "/buy/getBuyList.jsp";
		} else if(uri.equals("/BaCode/buyInsert.buy")) {
			sv = new BuyInsertService();
			sv.execute(request, response);
			ui = "/buy/buySuccess.jsp";
		}
		RequestDispatcher dp = request.getRequestDispatcher(ui);
		dp.forward(request, response);
	}
}