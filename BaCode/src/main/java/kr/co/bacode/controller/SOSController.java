package kr.co.bacode.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bacode.SOSService.ISOSService;
import kr.co.bacode.SOSService.SOSInsertFormService;
import kr.co.bacode.SOSService.SOSInsertService;
import kr.co.bacode.SOSService.SOSSuccessService;
import kr.co.bacode.SOSService.GetSOSDetailService;
import kr.co.bacode.SOSService.GetSOSListService;
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
		ISOSService sv = null;
		
		if(uri.equals("/BaCode/getSOSList.SOS")) {
			sv = new GetSOSListService();
			sv.execute(request, response);
			ui = "/SOS/getSOSList.jsp";
		} else if (uri.equals("/BaCode/getSOSDetail.SOS")) {
			sv = new GetSOSDetailService();
			sv.execute(request, response);
			ui = "/SOS/SOSDetail.jsp?stNum=" + request.getParameter("stNum");
		} else if(uri.equals("/BaCode/SOSInsertForm.SOS")) {
			sv = new SOSInsertFormService();
			sv.execute(request, response);
			ui = "/SOS/SOSInsertForm.jsp";
		} else if(uri.equals("/BaCode/SOSInsert.SOS")) {
			sv = new SOSInsertService();
			sv.execute(request, response);
			ui = "/SOS/SOSSuccess.jsp";
		} else if(uri.equals("/BaCode/SOSSuccess.SOS")) {
			sv = new SOSSuccessService();
			System.out.println("처리완료했습니다.");
			sv.execute(request, response);
			ui = "/getSOSList.SOS";
		} 
		
		RequestDispatcher dp = request.getRequestDispatcher(ui);
		dp.forward(request, response);
	}
}
