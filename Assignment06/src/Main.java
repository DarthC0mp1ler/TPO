import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;

@WebServlet("/add")
public class Main extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        String comp1 = req.getParameter("component1");
        String comp2 = req.getParameter("component2");

        if(comp1.matches("-?[0-9]+") && comp1.matches("-?[0-9]+")) {
            BigInteger component1 = new BigInteger(comp1);
            BigInteger component2 = new BigInteger(comp2);
            BigInteger sum = component1.add(component2);
            PrintWriter printWriter = res.getWriter();
            printWriter.write("{ \"sum\": " + sum.toString()+" }");
            printWriter.close();
        }
        else {
            PrintWriter printWriter = res.getWriter();
            printWriter.write("{ \"sum\": nothing }");
            printWriter.close();
            }
    }
}
