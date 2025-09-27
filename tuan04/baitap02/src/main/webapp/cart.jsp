<%@ page import="iuh.fit.se.model.CartItem,java.util.*" %>
<h2>Shopping Cart</h2>
<a href="index.jsp">Back to Shop</a>
<%
    List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
    if(cart == null || cart.isEmpty()){
%>
<p>Cart is currently empty - Subtotal: $0.0</p>
<% } else { %>
<form action="updateCart.jsp" method="post">
    <table border="1">
        <tr><th>Model Description</th><th>Quantity</th><th>Unit Price</th><th>Total</th><th></th></tr>
        <%
            double sum = 0;
            for(int i=0;i<cart.size();i++){
                CartItem c = cart.get(i);
                sum += c.getTotal();
        %>
        <tr>
            <td><%=c.getProduct().getName()%></td>
            <td>
                <input type="hidden" name="id" value="<%=c.getProduct().getId()%>"/>
                <input type="number" name="qty" value="<%=c.getQuantity()%>" min="1"/>
            </td>
            <td>$<%=c.getProduct().getPrice()%></td>
            <td>$<%=c.getTotal()%></td>
            <td><button type="submit" name="delete" value="<%=c.getProduct().getId()%>">Delete</button></td>
        </tr>
        <% } %>
    </table>
    <p>Subtotal: $<%=sum%></p>
    <input type="submit" value="Update Quantities"/>
</form>
<% } %>
