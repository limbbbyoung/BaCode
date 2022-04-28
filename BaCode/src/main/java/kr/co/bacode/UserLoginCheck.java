package kr.co.bacode;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.bacode.domain.userDAO;
import kr.co.bacode.domain.userVO;

/**
 * Servlet implementation class userLoginCheck
 */
@WebServlet("/userLoginCheck")
public class UserLoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// 濡쒓렇�씤�뤌�뿉�꽌 諛쏆븘�삩 id, pw
		String formId = request.getParameter("userId");
		String formPw = request.getParameter("userPw");
		System.out.println(formId);
		// db�뿉�꽌 諛쏆븘�삩 id,pw 誘몃━ �꽑�뼵
		String dbId = null;
		String dbPw = null;
		String reUrl = null;
		// dao �깮�꽦
		userDAO dao = userDAO.getInstance();
		
		// dao�쓽 login check硫붿냼�뱶 �샇異�
		userVO user = dao.userLoginCheck(formId);
		
		// user紐⑸줉�뿉�꽌 id媛��졇�삤怨� 留뚯빟 �뾾�떎硫� null媛믪씠 ���옣�맖 
		dbId = user.getuId(); 
		System.out.println(dbId);
		dbPw = user.getuPw();
		
		if(dbId != null && formId.equals(dbId)) {
			if(formPw.equals(dbPw)) {
				System.out.println("濡쒓렇�씤�뿉 �꽦怨듯븯���뒿�땲�떎.");
				reUrl = "http://localhost:52525/BaCode/user/mainSearch.jsp";
				HttpSession session = request.getSession();
				session.setAttribute("s_id", formId);
			} else { 
				System.out.println("鍮꾨�踰덊샇媛� ���졇�뒿�땲�떎.");
				reUrl = "http://localhost:52525/BaCode/user/loginIdPwFail.jsp";
			}
		} else {
			System.out.println("�븘�씠�뵒媛� ���졇�뒿�땲�떎.");
			reUrl = "http://localhost:52525/BaCode/user/loginIdPwFail.jsp";
		}
		
		response.sendRedirect(reUrl);
	}

}
