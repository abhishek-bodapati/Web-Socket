package com.websockets;

import java.io.IOException;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/login")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public UserServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    static RequestDispatcher rd;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		response.getWriter();
		
		HttpSession session = request.getSession(true);
		String username = request.getParameter("username");
		session.setAttribute("username", username);
		
		if(username != null && username.equals("doctor")) {
			rd = request.getRequestDispatcher("/doctor.jsp");
			rd.forward(request, response);
		}
		
		else if(username != null && username.equals("ambulance")) {
			rd = request.getRequestDispatcher("/ambulance.jsp");
			rd.forward(request, response);
		}
		
		else if(username != null) {
			rd = request.getRequestDispatcher("/patient.jsp");
			rd.forward(request, response);
		}
	}

}
