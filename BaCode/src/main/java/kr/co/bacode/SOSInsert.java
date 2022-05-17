package kr.co.bacode;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.bacode.domain.BoardDAO;
import kr.co.bacode.domain.SOSDAO;

/**
 * Servlet implementation class SOSInsert
 */
@WebServlet("/SOSInsert")
public class SOSInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SOSInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("utf-8");
		// 접속 디버깅
		System.out.println("/SOSInsert 접속");
		// DAO 생성 및 싱글턴 패턴 
		SOSDAO sdao = SOSDAO.getInstance();
        // Form에서 Parameter로 관련된 값 받아오기
		String strpostNum = request.getParameter("postNum");
		int postNum = Integer.parseInt(strpostNum);
		String stTitle = request.getParameter("stTitle");
		String stContent = request.getParameter("stContent");
		String uId = (String)session.getAttribute("s_id");
		// BoardDAO에서 게시판 등록 메서드 실행
		sdao.insertSOS(postNum, stTitle, stContent, uId);
		// 메인 검색창으로
		response.sendRedirect("http://localhost:52525/BaCode/SOS/SOSSuccess.jsp");
	}

}
