

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import swiggyhotel.dao.DAOFactory;
import swiggyhotel.dao.OrderItemDAO;
import swiggyhotel.dao.UsersDAO;
import swiggyhotel.dao.impl.DiscountDAOImpl;
import swiggyhotel.model.DbException;
import swiggyhotel.model.ItemList;
import swiggyhotel.model.OrderItemDetails;


public class OrderItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsersDAO obj=DAOFactory.getUsersDAO();
		HttpSession session=request.getSession(false);
		String name=(String)session.getAttribute("name");
		Long phoneno=(Long)session.getAttribute("phoneno");
		int usersid=0,orderId1=0;
		try {
			usersid = obj.getUserId(name,phoneno);
			 orderId1=obj.getOrderId(usersid);
		} catch (DbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    OrderItemDAO ob=DAOFactory.getOrderItemDAO();
		//List<Integer> quans=new ArrayList<Integer>();
		//List<Integer> amount=new ArrayList<Integer>();
		//List<ItemList> list=new ArrayList<ItemList>();
		String[] items=request.getParameterValues("itemId");
		System.out.println("Items:" + items);
		//Integer TotalAmount=0;
		
		
		//request.setAttribute("item",items);
		//RequestDispatcher dispatch=request.getRequestDispatcher("OrderItem");
		//dispatch.forward(request, response);
		// ob.insertorderitems(a);
		//int itemid=0;
		for(String itemId:items)
		{  
			String qty=request.getParameter("qty_"+itemId);
			Integer quantity=Integer.parseInt(qty);
			if(quantity>0)
			{
		      //quans.add(quantity);
		    DiscountDAOImpl dob=new DiscountDAOImpl();
		    String price=request.getParameter("price_"+itemId);
			Integer total=Integer.parseInt(price)*quantity;
		    
				try {
					
					OrderItemDetails a = new OrderItemDetails();
					a.setOrderId(orderId1);
					System.out.println(a.getOrderId());
					a.setItemId(Integer.parseInt(itemId));
					System.out.println(a.getItemId());
					a.setQuantity(quantity);
					System.out.println(a.getQuantity());
					a.setTotalAmounts(total);
					System.out.println(a.getTotalAmounts());
					LocalDateTime orderTime  = LocalDateTime.now();
					a.setOrderDate(orderTime);
					//a.status="ordered";
					ob.insertorderitems(a);
					
					
					//ItemList itemList = dob.getItemList(Integer.parseInt(itemId));
					//list.add(itemList);
				} catch (DbException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		    
			
			
			
			}
		
		}
	}
	}

