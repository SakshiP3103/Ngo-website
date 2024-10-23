package com.yash.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

import com.yash.DAO.OwnerDAO;
import com.yash.DB.DBConnect;
import com.yash.entities.Owner;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/ownerRegisterServlet")
public class ownerRegisterServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
         String name=request.getParameter("uname");
         String email=request.getParameter("email");
         String password=request.getParameter("password");
         
         
         Owner us=new Owner();
         us.setName(name);
         us.setEmail(email);
         us.setPassword(password);
         
         OwnerDAO dao=new OwnerDAO(DBConnect.getConnection());
         boolean f=dao.OwnerRegister(us);
         
         if(true) {
//        	 PrintWriter out=response.getWriter();
//        	 out.print("data inserted sucessfully");
//        	 
        	 
        	 HttpSession session=request.getSession();
        	 session.setAttribute("reg-msg","registration done successfully");
        	 response.sendRedirect("register.jsp");
        	 
         }else {
//         	 PrintWriter out=response.getWriter();
//        	 out.print("data not inserted "); 
        	 
        	 
        	 HttpSession session=request.getSession();
        	 session.setAttribute("reg-msg","registration not done successfully");
        	 response.sendRedirect("register.jsp");
         }
	}

}
