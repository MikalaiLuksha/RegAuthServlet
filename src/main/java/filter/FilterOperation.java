package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter (filterName = "FilterOperation", servletNames = {"CalcServlet", "ResultServlet"})

public class FilterOperation extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String operation = req.getParameter("operation");
        if (operation.equals("plus")||operation.equals("minus")||operation.equals("div")||operation.equals("times")||operation.equals("all")){
            chain.doFilter(req, res);
        }
        else {
            res.getWriter().println("Incorrect operation");
        }

    }
}
