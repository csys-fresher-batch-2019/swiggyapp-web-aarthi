

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swiggyhotel.dao.DAOFactory;
import swiggyhotel.dao.FoodItemsDAO;
import swiggyhotel.dao.UsersDAO;
import swiggyhotel.dao.impl.FoodItemsDAOImpl;
import swiggyhotel.model.DbException;


public class AddFood extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FoodItemsDAO ob = DAOFactory.getFoodItemsDAO();
		PrintWriter out=response.getWriter();
		String itemName=request.getParameter("itemname");
		String foodType=request.getParameter("foodtype");
		int price=Integer.parseInt(request.getParameter("price"));
		
		int menuId=Integer.parseInt(request.getParameter("menuid"));
		String images=request.getParameter("images");
		try {
			ob.insertItems(itemName,foodType,price, menuId, images);
			out.print("<a href='swiggy.jsp'>home</a>");
		} catch (DbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
	

}
