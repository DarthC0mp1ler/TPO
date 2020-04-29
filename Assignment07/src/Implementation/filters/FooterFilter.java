package Implementation.filters;

import Implementation.StringResponseWrapper;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(filterName = "footer1", urlPatterns = { "*.servlet"  })
public class FooterFilter implements Filter {

	private static final String FOOTER_CONTENT = //
			"<div id=\"date\"></div>" //
					+ "</body></html>";
	public void init(FilterConfig fConfig) throws ServletException {
	}
	
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse originalResponse, FilterChain chain)
			throws IOException, ServletException {
		StringResponseWrapper wrapperResponse = new StringResponseWrapper(originalResponse);
		// we pass our wrapper response to servlet instead of orignal response
		chain.doFilter(request, wrapperResponse);
		// we append the content written by the servlet to the original response
		appendServletGeneratedResponse(originalResponse, wrapperResponse);
		// we append the footer to the original response
		appendFooter(request, originalResponse);
	}

	private void appendServletGeneratedResponse(ServletResponse originalResponse, StringResponseWrapper wrapperResponse)
			throws IOException {
		String wrapperContent = wrapperResponse.content();
		PrintWriter originalResponseWriter = originalResponse.getWriter();
		originalResponseWriter.print(wrapperContent);
	}

	private void appendFooter(ServletRequest request, ServletResponse response) throws IOException {
		PrintWriter writer = response.getWriter();
		// Locale locale = request.getLocale();
		// DateFormat df = DateFormat.getDateTimeInstance(DateFormat.LONG,
		// DateFormat.MEDIUM, locale);
		// writer.println("\n Footer 1 - " + df.format(new Date()));
		writer.println(FOOTER_CONTENT);
		writer.close();
	}
}