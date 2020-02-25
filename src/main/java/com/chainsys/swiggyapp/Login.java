package com.chainsys.swiggyapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import swiggyhotel.dao.DAOFactory;
import swiggyhotel.dao.UsersDAO;
import swiggyhotel.model.DbException;
import swiggyhotel.model.UserDetails;


public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		UsersDAO ob = DAOFactory.getUsersDAO();
		HttpSession session=request.getSession();
		
		boolean inserted=false;
		String name = request.getParameter("name");
		PrintWriter out = response.getWriter();
		Long phoneNo = Long.parseLong(request.getParameter("number"));
		try {
			String a=ob.login(name,phoneNo);
			out.println(a);
			if(a.equals("Welcome"+" "+name))
			{
				response.sendRedirect("listfoods.jsp");
				session.setAttribute("name",name);
				session.setAttribute("phoneno",phoneNo);
				
			}
			else
			{
				response.sendRedirect("login.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*if(inserted)
		{
			/*RequestDispatcher dispatch=request.getRequestDispatcher("orderfood.jsp");
			dispatch.forward(request,response);*/
			/*response.sendRedirect("orderfood.jsp");
		}
		else
		{
		/*RequestDispatcher dispatch=request.getRequestDispatcher("login.jsp");
		dispatch.forward(request,response);*/
			//response.sendRedirect("login.jsp");
		//}
		 try {
			int userId=ob.getUserId(name, phoneNo);
			session.setAttribute("UserId",userId);
			//request.setAttribute("ID",userId);
		} catch (DbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
	}

	

}
