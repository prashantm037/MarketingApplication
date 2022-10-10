package com.MarketingApplication2.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.MarketingApplication2.model.DAOService;
import com.MarketingApplication2.model.DAOServiceImpl;

@WebServlet("/login")
public class logincontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public logincontroller() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String email = request.getParameter("email");
	String password = request.getParameter("password");
	
	DAOService service=new DAOServiceImpl();
	service.connectDB();
	
	boolean status = service.varify(email, password);
	try {
		if (status==true) {
			
			HttpSession session = request.getSession(true);
			session.setAttribute("email", "email");
			
			session.setMaxInactiveInterval(10);
			 RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/CreateRegistration.jsp");
			  rd.forward(request, response);
		} else {
	         request.setAttribute("error", "Invalid Username/Password");
	         RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
	         rd.forward(request, response);
		}
	} catch (Exception e) {
		 RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
         rd.forward(request, response);
	}
	
	
	
	}

}
