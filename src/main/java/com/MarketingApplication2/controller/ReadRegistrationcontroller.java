package com.MarketingApplication2.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.MarketingApplication2.model.DAOService;
import com.MarketingApplication2.model.DAOServiceImpl;

@WebServlet("/listall")
public class ReadRegistrationcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ReadRegistrationcontroller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession(false);
		     if (session.getAttribute("email")!=null) {
		    	 session.setMaxInactiveInterval(10);
		    	 DAOService service=new DAOServiceImpl();
			      service.connectDB();
			      
			      ResultSet result = service.getAllRegistration();
			      
			      request.setAttribute("result", result);
			      RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/ShowRegistration.jsp");
			      rd.forward(request, response);
		     }else {
		    	 RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		         rd.forward(request, response);
		     }
		} catch (Exception e) {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
	         rd.forward(request, response);
		}
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	}

}
