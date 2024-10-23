package com.yash.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

import com.yash.DAO.UserDAO;
import com.yash.DB.DBConnect;
import com.yash.entities.User;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
         String name=request.getParameter("uname");
         String email=request.getParameter("email");
         String password=request.getParameter("password");
         
         
         User us=new User();
         us.setName(name);
         us.setEmail(email);
         us.setPassword(password);
         
         UserDAO dao=new UserDAO(DBConnect.getConnection());
         boolean f=dao.userRegister(us);
         
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
