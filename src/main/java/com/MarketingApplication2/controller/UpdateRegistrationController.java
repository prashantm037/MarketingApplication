package com.MarketingApplication2.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.MarketingApplication2.model.DAOService;
import com.MarketingApplication2.model.DAOServiceImpl;

@WebServlet("/update")
public class UpdateRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UpdateRegistrationController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  String email = request.getParameter("email");
	  String mobile = request.getParameter("mobile");
	  
	  request.setAttribute("email", email);
	  request.setAttribute("mobile", mobile);
	  
	  RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/UpdateRegistration.jsp");
      rd.forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		
		DAOService service =new DAOServiceImpl();
		service.connectDB();
		
		
		service.UpdateRegistration(email, mobile);
		
		ResultSet result = service.getAllRegistration();
	      
	      request.setAttribute("result", result);
	      RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/ShowRegistration.jsp");
	      rd.forward(request, response);
	
	}

}
