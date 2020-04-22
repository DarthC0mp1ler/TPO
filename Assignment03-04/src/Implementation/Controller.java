package Implementation;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.math.BigInteger;

@WebServlet("/add")
public class Controller extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BigInteger bigInteger = null,bigInteger1 = null;
        if(req.getParameter("component1").matches("-?[0-9]+") && req.getParameter("component2").matches("-?[0-9]+")) {
            bigInteger = new BigInteger(req.getParameter("component1"));
            bigInteger1 = new BigInteger(req.getParameter("component2"));
        }

            Model model = Logic.add(bigInteger,bigInteger1);

            req.setAttribute("model",model);
            HttpSession session = req.getSession();
            session.setAttribute("model",model);

            ServletContext context = getServletContext();
            RequestDispatcher dispatcher = context.getRequestDispatcher("/result");

            dispatcher.forward(req,resp);
    }
}
