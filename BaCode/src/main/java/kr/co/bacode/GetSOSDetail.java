package kr.co.bacode;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.bacode.domain.BoardDAO;
import kr.co.bacode.domain.BoardVO;
import kr.co.bacode.domain.PickDAO;
import kr.co.bacode.domain.PickVO;
import kr.co.bacode.domain.SOSDAO;
import kr.co.bacode.domain.SOSVO;

/**
 * Servlet implementation class GetSOSDetail
 */
@WebServlet("/getSOSDetail")
public class GetSOSDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetSOSDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strStNum = request.getParameter("stNum");
		int stNum = Integer.parseInt(strStNum);
		System.out.println("조회된 번호 : " + stNum);  
		SOSDAO sdao = SOSDAO.getInstance();
		
		SOSVO SOS = sdao.getSOSDetail(stNum);
		request.setAttribute("SOS" , SOS);
		RequestDispatcher dp = request.getRequestDispatcher("/SOS/SOSDetail.jsp");
		dp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
