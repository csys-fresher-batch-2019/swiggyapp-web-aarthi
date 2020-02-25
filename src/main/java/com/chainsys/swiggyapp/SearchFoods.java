package com.chainsys.swiggyapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import swiggyhotel.dao.DAOFactory;
import swiggyhotel.dao.FoodItemsDAO;
import swiggyhotel.dao.OrderItemDAO;
import swiggyhotel.dao.OrdersDAO;
import swiggyhotel.dao.impl.DiscountDAOImpl;
import swiggyhotel.model.DbException;
import swiggyhotel.model.FoodDetails;
import swiggyhotel.model.ItemList;
import swiggyhotel.model.OrderDetails;
import swiggyhotel.model.OrderItemDetails;


public class SearchFoods extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FoodItemsDAO ob1=DAOFactory.getFoodItemsDAO();
		PrintWriter out=response.getWriter();
		String searchName=request.getParameter("itemname");
		  List<FoodDetails> l=new ArrayList<FoodDetails>();
		  try {
			  String itemName=ob1.toUpp(searchName);
			l= ob1.getFoodsDetailsBySearchName(itemName);
			request.setAttribute("searchlist",l);
						 RequestDispatcher d = request.getRequestDispatcher("listfoods.jsp");
			  d.forward(request, response);
		  }

		 catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		}
		  
		  
		//  RequestDispatcher d = request.getRequestDispatcher("listfoods4.jsp");
		  //d.forward(request, response);
		 
			
	}

	
