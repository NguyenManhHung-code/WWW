package iuh.fit.se;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name = "paramServlet",
        value = "/param-servlet",
        initParams = {
                @WebInitParam(name = "initMessage", value = "This is an init-param message")
        }
)
public class ParamServlet extends HttpServlet {
    private String initMessage;

    @Override
    public void init(ServletConfig config){
        initMessage = config.getInitParameter("initMessage");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        out.println("Init-Param Message: " + initMessage);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        ServletContext context = getServletContext();
        String contextMessage = context.getInitParameter("contextMessage");
        out.println("Context-Param Message: " + contextMessage);
    }
}
