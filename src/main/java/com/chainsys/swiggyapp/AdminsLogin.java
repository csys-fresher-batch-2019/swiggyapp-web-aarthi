package com.chainsys.swiggyapp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swiggyhotel.dao.DAOFactory;
import swiggyhotel.dao.UsersDAO;

/**
 * Servlet implementation class AdminsLogin
 */
public class AdminsLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsersDAO ob = DAOFactory.getUsersDAO();
		
		String userName=request.getParameter("username");
		 String passWord=request.getParameter("password");
		 try {
				String msg=ob.adminLogin(userName,passWord);
				//out.println(msg);
				if(msg.equals("Welcome"))
				{
					response.sendRedirect("AddFoods.jsp");
					
				}
				else
				{
					response.sendRedirect("AdminLogin.jsp");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
	
	}

	
	

}
