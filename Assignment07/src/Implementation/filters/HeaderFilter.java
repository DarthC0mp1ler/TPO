package Implementation.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(filterName = "header1", urlPatterns = { "*.html", "*.servlet" })
//@WebFilter(filterName = "header1", urlPatterns = { "/*" })
//@WebFilter(filterName = "header1", urlPatterns = { "*.html" })
public class HeaderFilter implements Filter {

	private static final String HEADER = "<html><head>" //
			+ "<script src=\"/Assignment07/scripts/jquery.js\"></script>" //
			+ "<script src=\"/Assignment07/scripts/index.js\"></script>" //
			+ "</head><body>";
	
	private static final String HEADER_CONTENT = "<br>HEADER</br>";
	
	public void init(FilterConfig fConfig) throws ServletException {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		PrintWriter writer = response.getWriter();
		writer.write(HEADER);
		writer.write(HEADER_CONTENT);
		chain.doFilter(request, response);
		// writer.write("Header-1\n");
	}
}