package com.chainsys.swiggyapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import swiggyhotel.dao.DAOFactory;
import swiggyhotel.dao.RatingDAO;
import swiggyhotel.model.DbException;
import swiggyhotel.model.RatingDetails;

/**
 * Servlet implementation class InsertRating
 */
public class InsertRating extends HttpServlet {
	private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	  PrintWriter out=response.getWriter();
	    	
	    	List<Integer> listw=(List<Integer>)request.getAttribute("items");
	     	for(Integer b:listw){
	     	out.print(b);
	     	}
			    
			     
			    
			    	 
			     
			    
			    	 /*try {
			    		 if(number!=0)
					     {
			    	 
			    		// String itemName="null";
			    	        int count=0,itemId=0;
			    	        
			    	      //  Integer id=(Integer)ses.getAttribute("ID");
			    	        
			    	        RatingDetails ob=new RatingDetails();
			    	        RatingDAO obj=DAOFactory.getRatingDAO();
			    	        ob.ratingPoints=number;
			    	       // Integer userId=(Integer)request.getAttribute("ID");
			    	       // ob.userId=id;
			    	    	List<Integer> a=(List<Integer>)request.getAttribute("listItems");
			    	    	//List<String> b=(List<String>)request.getAttribute("lists");
			    			//for(String v1:lists){
			    					// itemName=lists.get(count);	
			    					//Integer number=Integer.parseInt(request.getParameter("number"));
			    	    	//Integer number=0;
			    	    	 for(Integer v2:a)
			    	    		 
			    		     {
			    	    		 itemId=a.get(count);
			    		    	 ob.itemId=itemId;
						obj.insertRatings(ob);
					} 
			    	    	 count++;}}
			     catch (DbException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();}*/
			     }
    }
					
			     
			     
	     
		
		
	
	
	

	


