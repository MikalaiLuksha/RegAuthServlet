package servlet;

import domain.Operation;
import service.ServiceCalc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CalcServlet", urlPatterns = "/calc")

public class CalcServlet extends HttpServlet {

    private ServiceCalc serviceCalc = new ServiceCalc();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


            if (req.getSession().getAttribute("resultCalc") == null) {
                req.getSession().setAttribute("resultCalc", new ArrayList<>());
            }
                double num1 = Double.parseDouble(req.getParameter("num1"));
                double num2 = Double.parseDouble(req.getParameter("num2"));
                String operation = req.getParameter("operation");
                double num3 = serviceCalc.calculation(operation, num1, num2);
                Operation operation1 = new Operation(operation, num1, num2, num3);
                resp.getWriter().println(operation1);
                List<Operation> result = (List<Operation>) req.getSession().getAttribute("resultCalc");
                result.add(operation1);


    }
}
