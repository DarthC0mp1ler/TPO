package Implementation;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/date")
public class DateServlet extends HttpServlet {

	private static final long serialVersionUID = -2712472245534060897L;

	private static final DateFormat FORMAT;

	static {
		FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	}

	private static final String DATE = "date";

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Enumeration<String> en = request.getParameterNames();
		while(en.hasMoreElements()){
			if(request.getParameter(en.nextElement()).equals("date")) {
				PrintWriter writer = response.getWriter();
				writer.write("{ \"" + DATE + "\": \"" + date() + "\" }");
				writer.close();
			}
		}


	}

	private static String date() {
		Date date = new Date();
		return FORMAT.format(date);
	}
}
