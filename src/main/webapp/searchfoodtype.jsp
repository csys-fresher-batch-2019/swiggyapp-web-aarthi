<%@ page import="swiggyhotel.dao.FoodItemsDAO" %>
<%@ page import="swiggyhotel.dao.DAOFactory" %>
<%@ page import="swiggyhotel.model.FoodDetails" %>
<%@ page import="swiggyhotel.dao.RatingDAO" %>
<%@ page import="swiggyhotel.dao.DAOFactory" %>
<%@ page import="swiggyhotel.model.RatingDetails" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<form action="listfoods.jsp">

<%
FoodItemsDAO ob=DAOFactory.getFoodItemsDAO();
  List<FoodDetails> l=new ArrayList<FoodDetails>();
  l= ob.getFoodsDetailsBySearchName("itemname");
  
  %>
<div class="text-block">
<input type="text" name="itemname" > 
  


<button type="submit" >search</button>
<%
for (FoodDetails f : l) {%>


<div class="left">
<div class="card-desk">
<div class="card" style="width: 18rem;height: 22rem;">
 <img src="assets/images/<%=f.images %>" class="card-img-top" alt="..." height="180" width="150">
  <div class="card-body">
  <h5 class="card-title"><%=f.itemId%> &nbsp <%=f.itemName %> &nbsp Rs.<%=f.price %><input type="hidden" name="price_<%=f.itemId%>" value="<%=f.price%>"></h5>
    <h5 class="card-title"><span class ="btn btn-success btn-sm"><%=f.foodType %>   </span> &nbsp <input type="checkbox" name="itemId" id="ItemId_<%=f.itemId%>"
onchange="disable(<%=f.itemId%>)"value="<%=f.itemId%>">  &nbsp <select name="qty_<%=f.itemId%>"
onchange="disable(<%=f.itemId%>)" autofocus>
<option value="0">0</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
<option value="4">4</option>
<option value="5">5</option>
<option value="6">6</option>
</select>
<script>
function disable(itemId) {


var ch = document.getElementById("ItemId_" + itemId);
if (ch.checked){
ch.checked=false;
}
else{ 
ch.checked=true;
}
}
</script>




 </h5>
    <% RatingDAO obj=DAOFactory.getRatingDAO();  %>
    <h5 class="card-title">Ratings:
    
    <% int rating=obj.getItemRatings(f.itemName);
    %>
  	<jsp:include page="ratings.jsp">
  		<jsp:param value="<%=rating %>" name="rating"/>
  	</jsp:include> 
    
     </h5>
   
  
    </div>
  </div>
  
  </div>
  </div> 
<%} %>


</form>