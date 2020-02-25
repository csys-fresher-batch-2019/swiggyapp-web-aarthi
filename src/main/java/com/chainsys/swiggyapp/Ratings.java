package com.chainsys.swiggyapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swiggyhotel.dao.DAOFactory;
import swiggyhotel.dao.RatingDAO;
import swiggyhotel.model.DbException;

/**
 * Servlet implementation class Ratings
 */
public class Ratings extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String checked=checked();
		out.print(checked);
		String unchecked=unchecked();
		out.print(unchecked);
		RatingDAO obj=DAOFactory.getRatingDAO(); 
		
		try {
			float rating = obj.getItemRatings(request.getParameter("itemName"));
			float x=5-rating;
		} catch (DbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
   
	public String checked()
	{
		
		return("<span class='fa fa-star checked'></span>");
	}
	public String unchecked()
	{
		return("<span class='fa fa-star'></span>");
	}

	

}
