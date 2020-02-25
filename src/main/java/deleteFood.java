

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swiggyhotel.dao.DAOFactory;
import swiggyhotel.dao.FoodItemsDAO;
import swiggyhotel.model.DbException;

/**
 * Servlet implementation class deleteFood
 */
public class deleteFood extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 PrintWriter out=response.getWriter();
		 FoodItemsDAO ob=DAOFactory.getFoodItemsDAO();
		 String itemName=request.getParameter("itemname");
		 try {
			ob.deleteFoods(itemName);
			out.print("<a href='swiggy.jsp'>home</a>");
		} catch (DbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	

}
