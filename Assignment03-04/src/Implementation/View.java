package Implementation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/result")
public class View extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Model attributeModel = (Model)req.getAttribute("model");
        HttpSession session = req.getSession();
        Model sessionModel = (Model)session.getAttribute("model");

        if(attributeModel == null || sessionModel == null){
            String message = String.format("%s%s",req.getContextPath(),req.getServletPath());
            res.sendError(400,message);
            return;
        }

        PrintWriter writer = res.getWriter();
        String resp = "<p>attribute res: " + attributeModel.getResult() + ";</p><p>session res: " + sessionModel.getResult() + ";</p>";
        writer.println(HtmlBuilder.getHtmlResponce(resp));
    }
}
