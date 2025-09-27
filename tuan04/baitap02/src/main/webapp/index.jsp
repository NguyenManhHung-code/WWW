<%@ page import="iuh.fit.se.model.Product" %>
<%@ page import="java.util.*" %>
<%
    List<Product> products = new ArrayList<>();
    products.add(new Product("PRO01","Nokia Lumia",99000));
    products.add(new Product("PRO02","BlackBerry Passport",48000));
    products.add(new Product("PRO03","Sony Xperia Z5",52000));
    products.add(new Product("PRO04","HTC One M9",83000));
    products.add(new Product("PRO05","Samsung Galaxy Note 5",71000));
    products.add(new Product("PRO06","iPhone 7 jet-black Plus",120000));
%>
<h2>Product List</h2>
<a href="cart.jsp">View Cart</a>
<table border="1">
    <tr><th>Name</th><th>Price</th><th>Quantity</th><th></th></tr>
    <% for(Product p : products){ %>
    <tr>
        <form action="addToCart.jsp" method="post">
            <td><%=p.getName()%></td>
            <td>$<%=p.getPrice()%></td>
            <td>
                <input type="hidden" name="id" value="<%=p.getId()%>"/>
                <input type="hidden" name="name" value="<%=p.getName()%>"/>
                <input type="hidden" name="price" value="<%=p.getPrice()%>"/>
                <input type="number" name="qty" value="1" min="1"/>
            </td>
            <td><input type="submit" value="Add To Cart"/></td>
        </form>
    </tr>
    <% } %>
</table>
