package tp.mri.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ChatServlet
 */
@WebServlet("/ChatServlet")
public class ChatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private StringBuffer chatContent;
	private String welcome;
	/**
     * @see HttpServlet#HttpServlet()
     */
    public ChatServlet() {
    	super();
    	chatContent = new StringBuffer();
    }
    
    public void init(ServletConfig sc) throws ServletException{
    	super.init(sc);
    	ServletContext scon = sc.getServletContext();
    	welcome = scon.getInitParameter("welcome");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		if(session.getAttribute("user") == null){
			response.sendRedirect("login.html");
		}else{
			
		}

    	RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
    	String action = request.getParameter("action");
    	Date date = new Date();

    	if (action != null && action.equals("submit")) {
    		chatContent.append("<div>").append(date.toString()+" "+session.getAttribute("user")).append("> ").append(request.getParameter("ligne")).append("</div>");
    	}
    	request.setAttribute("welcome", this.welcome);
    	request.setAttribute("content", chatContent.toString());
    	rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
