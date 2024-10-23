package com.yash.servlet;
import jakarta.servlet.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import com.yash.DAO.OwnerDAO;
import com.yash.DB.DBConnect;
import com.yash.entities.Owner;

@WebServlet("/ownerLoginServlet")
public class ownerLoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");

		OwnerDAO dao=new OwnerDAO(DBConnect.getConnection());
		Owner user=dao.getLogin(email, password);
		
		if(user!=null) {
			
			 HttpSession session=request.getSession();
        	 session.setAttribute("owner-ob","user");
        	 response.sendRedirect("ownerDashboard.jsp");
        	 
//			 PrintWriter out=response.getWriter();
//             out.print("Login successfully"); 
        	 
		}else {
//			 PrintWriter out=response.getWriter();
//             out.print("invalid email and password"); 
		}
	}

}
