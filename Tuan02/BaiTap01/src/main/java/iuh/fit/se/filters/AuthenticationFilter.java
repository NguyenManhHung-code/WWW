package iuh.fit.se.filters;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class AuthenticationFilter extends HttpFilter implements Filter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String usernameFilter = this.getFilterConfig().getInitParameter("username");
        String passwordFilter = this.getFilterConfig().getInitParameter("password");
        if (username.equals(usernameFilter) && password.equals(passwordFilter)){
            chain.doFilter(req, res);
        }else{
            PrintWriter writer = res.getWriter();
            writer.println("Incorrect information entered!");
            writer.close();
        }
    }
}
