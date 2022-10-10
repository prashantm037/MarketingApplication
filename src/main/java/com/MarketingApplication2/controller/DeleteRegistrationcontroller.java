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

@WebServlet("/delete")
public class DeleteRegistrationcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public DeleteRegistrationcontroller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String email = request.getParameter("email");
	
	DAOService service=new DAOServiceImpl();
	service.connectDB();
	
	service.DeleteRegistration(email);
	
	 ResultSet result = service.getAllRegistration();
     
     request.setAttribute("result", result);
     RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/ShowRegistration.jsp");
     rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
