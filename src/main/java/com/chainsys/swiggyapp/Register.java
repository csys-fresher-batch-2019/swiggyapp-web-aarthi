package com.chainsys.swiggyapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swiggyhotel.dao.DAOFactory;
import swiggyhotel.dao.UsersDAO;
import swiggyhotel.model.UserDetails;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UsersDAO ob = DAOFactory.getUsersDAO();
		UserDetails obj = new UserDetails();
		PrintWriter out = response.getWriter();
		obj.setUserName(request.getParameter("name"));
		// System.out.println("<html><body>"+"Welcome "+name+"</body></html>");
		
		out.println(obj.getUserName());
		obj.setPhoneNo(Long.parseLong(request.getParameter("phoneno")));
		out.println(obj.getPhoneNo());
		obj.setAddress(request.getParameter("address"));
		out.println(obj.getAddress());
		obj.setCity(request.getParameter("cities"));
		out.println(obj.getCity());
		try {
			ob.insertUserInfo(obj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher d = request.getRequestDispatcher("login.jsp");
		d.forward(request, response);
	}


}
