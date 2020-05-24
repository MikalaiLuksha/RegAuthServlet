package servlet;

import domain.Operation;
import service.ServiceCalc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ResultServlet", urlPatterns = "/result")

public class ResultServlet extends HttpServlet {

    ServiceCalc serviceCalc = new ServiceCalc();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("currentUser") == null){
            resp.getWriter().println("Error");
        }
        else {
            String operation = req.getParameter("operation");
            List<Operation> result = (List<Operation>) req.getSession().getAttribute("resultCalc");
            resp.getWriter().println(result);
            List <Operation> resultSth = serviceCalc.calcResult(operation, result);
            resp.getWriter().println(resultSth);
        }
    }
}
