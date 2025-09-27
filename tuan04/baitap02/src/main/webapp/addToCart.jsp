<%@ page import="iuh.fit.se.model.CartItem,iuh.fit.se.model.Product,java.util.*" %>

<%
  String id = request.getParameter("id");
  String name = request.getParameter("name");
  double price = Double.parseDouble(request.getParameter("price"));
  int qty = Integer.parseInt(request.getParameter("qty"));

  // KHÔNG cần: HttpSession session = request.getSession();
  List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
  if(cart == null){
    cart = new ArrayList<>();
  }

  boolean found = false;
  for(CartItem item : cart){
    if(item.getProduct().getId().equals(id)){
      item.setQuantity(item.getQuantity() + qty);
      found = true;
      break;
    }
  }
  if(!found){
    cart.add(new CartItem(new Product(id,name,price), qty));
  }

  session.setAttribute("cart", cart);
  response.sendRedirect("cart.jsp");
%>
