package kr.co.bacode.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import kr.co.bacode.reviewservice.GetReviewDetailService;
import kr.co.bacode.reviewservice.GetReviewListService;
import kr.co.bacode.reviewservice.IReviewService;
import kr.co.bacode.reviewservice.ReviewInsertFormService;
import kr.co.bacode.reviewservice.ReviewInsertService;
import kr.co.bacode.reviewservice.ReviewUpdateFormService;
import kr.co.bacode.reviewservice.ReviewUpdateService;

/**
 * Servlet implementation class ReviewController
 */
@WebServlet("*.review")
public class ReviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewController() {
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
		IReviewService sv = null;
		
		if(uri.equals("/BaCode/getReviewList.review")) {
			sv = new GetReviewListService();
			sv.execute(request, response);
			ui = "/review/getReviewList.jsp";
		} else if (uri.equals("/BaCode/getReviewDetail.review")) {
			sv = new GetReviewDetailService();
			sv.execute(request, response);
			ui = "/review/getReviewDetail.jsp?rvNum=" + request.getParameter("rvNum");
		} else if(uri.equals("/BaCode/reviewInsertForm.review")) {
			sv = new ReviewInsertFormService();
			sv.execute(request, response);
			ui = "/review/reviewInsertForm.jsp";
		} else if(uri.equals("/BaCode/reviewInsert.review")) {
			sv = new ReviewInsertService();
			sv.execute(request, response);
			ui = "getReviewList.review";
		} else if(uri.equals("/BaCode/reviewUpdateForm.review")) {
			sv = new ReviewUpdateFormService();
			sv.execute(request, response);
			ui = "/review/reviewUpdateForm.jsp";
		} else if(uri.equals("/BaCode/reviewUpdate.review")) {
			sv = new ReviewUpdateService();
			sv.execute(request, response);
			ui = "getReviewDetail.review?rvNum=" + request.getParameter("rvNum");
		
		RequestDispatcher dp = request.getRequestDispatcher(ui);
		dp.forward(request, response);
	}
	}
}
