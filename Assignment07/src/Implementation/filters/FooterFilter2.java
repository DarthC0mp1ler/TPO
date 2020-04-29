package Implementation.filters;

import Implementation.StringResponseWrapper;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


@WebFilter(filterName = "footer2", urlPatterns = { "*.servlett"})
public class FooterFilter2 implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse originalResponse,
			FilterChain chain) throws IOException, ServletException {
		StringResponseWrapper wrapperResponse = new StringResponseWrapper(originalResponse);
		// we pass our wrapper response to servlet instead of orignal response
		chain.doFilter(request, wrapperResponse);
		// we append the content written by the servlet to the original response
		appendServletGeneratedResponse(originalResponse, wrapperResponse);
		// we append the footer to the original response
		appendFooter(request, originalResponse);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}
	
	private void appendServletGeneratedResponse(ServletResponse originalResponse, StringResponseWrapper wrapperResponse) throws IOException { 
		String wrapperContent = wrapperResponse.content();
		PrintWriter originalResponseWriter = originalResponse.getWriter();
		originalResponseWriter.print(wrapperContent);
	}
	
	private void appendFooter(ServletRequest request, ServletResponse response) throws IOException {
		PrintWriter writer = response.getWriter();
		Locale locale = request.getLocale();
		DateFormat df = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.MEDIUM, locale);
		writer.println("\nFOOTER 2 CONTENT START (" + df.format(new Date()) + ") FOOTER 2 CONTENT END");
		writer.close();
	}
}