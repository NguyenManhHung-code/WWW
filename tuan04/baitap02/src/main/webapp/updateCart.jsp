<%@ page import="iuh.fit.se.model.CartItem,java.util.*" %>
<%
    List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
    if(cart != null){
        String deleteId = request.getParameter("delete");
        if(deleteId != null){
            cart.removeIf(item -> item.getProduct().getId().equals(deleteId));
        } else {
            String[] ids = request.getParameterValues("id");
            String[] qtys = request.getParameterValues("qty");
            for(int i=0;i<ids.length;i++){
                for(CartItem item: cart){
                    if(item.getProduct().getId().equals(ids[i])){
                        item.setQuantity(Integer.parseInt(qtys[i]));
                    }
                }
            }
        }
        session.setAttribute("cart", cart);
    }
    response.sendRedirect("cart.jsp");
%>
