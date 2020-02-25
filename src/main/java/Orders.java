

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import swiggyhotel.dao.DAOFactory;
import swiggyhotel.dao.OrderItemDAO;
import swiggyhotel.dao.OrdersDAO;
import swiggyhotel.model.DbException;
import swiggyhotel.model.OrderDetails;
import swiggyhotel.model.OrderItems;


public class Orders extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ses=request.getSession(false);
		OrdersDAO a=DAOFactory.getOrdersDAO();
		//OrderItemDAO b=DAOFactory.getOrderItemDAO();
		OrderDetails x=new OrderDetails();
		//OrderItems ab=new OrderItems();
		LocalDateTime orderTime  = LocalDateTime.now();
		x.setOrderedDate(orderTime);
		request.setAttribute("orderdate",orderTime);
		//ab.orderedDate=orderTime;
	    LocalDateTime approxDeliveryTime = orderTime.plusHours(1);
	    x.setApproxDeliveryTime(approxDeliveryTime);
	    //ab.approxDeliveryTime=approxDeliveryTime;
	    request.setAttribute("approxdate",approxDeliveryTime);
	    Integer id=(Integer)ses.getAttribute("UserId");
	    //System.out.print(id);
	    x.setUserId(id);
	   // ab.userId=id;
	    request.setAttribute("uid",id);
	    request.setAttribute("date",orderTime);
	    request.setAttribute("approx",approxDeliveryTime);
		try {
			int orderId = a.insertOrders(x);
			request.setAttribute("order",orderId);
			//System.out.println(orderId);
			RequestDispatcher d = request.getRequestDispatcher("orders.jsp?orderId=" + orderId);
			d.forward(request, response);
		} catch (DbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	

}
