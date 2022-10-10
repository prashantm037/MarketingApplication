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

@WebServlet("/save")
public class saveRegistrationcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public saveRegistrationcontroller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/CreateRegistration.jsp");
		  rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
    	HttpSession session = request.getSession(false);
        if (session.getAttribute("email")!=null) {
       	 session.setMaxInactiveInterval(10);
          String name = request.getParameter("name");
      	  String city = request.getParameter("city");
      	  String email = request.getParameter("email");
      	  String mobile = request.getParameter("mobile");
      	  
      	  DAOService service=new DAOServiceImpl();
      	  service.connectDB();
      	  
      	  service.saveRegistration(name, city, email, mobile);
      	  
      	  request.setAttribute("msg", "your Registration is Done Thank you!...");
      	  RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/CreateRegistration.jsp");
      	  rd.forward(request, response);
   	} else {
   		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
           rd.forward(request, response);

   	}
	} catch (Exception e) {
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
        rd.forward(request, response);
	}
	 
	}

}
