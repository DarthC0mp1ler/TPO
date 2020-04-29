package Implementation.listeners;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;

@WebListener
public class RequestListener implements ServletRequestListener, ServletContextListener {

	private static final Logger LOGGER;
	private static final Random RANDOM;
	private static final List<Level> LEVELS;

	private static int CURRENT_LEVEL = 0;

	static {
		LOGGER = Logger.getLogger(RequestListener.class.getName());
		RANDOM = new Random();
		LEVELS = Arrays.asList(Level.SEVERE, Level.OFF);
	}

	private static void loggerLevel() {
		Level level = LEVELS.get(CURRENT_LEVEL);
		CURRENT_LEVEL = (CURRENT_LEVEL + 1) % LEVELS.size();
		LOGGER.setLevel(level);
	}

	private String constructMessage(ServletRequest request){
		String messg = "\n\t{";
		messg+="\n\t\t"+ request.getServerName()+":"+request.getServerPort() +" " + request.getProtocol();
		messg+="\n\t\tHost: " + request.getServerName();
		messg+="\n\t\tContent-Type: " + request.getContentType();
		messg+="\n\t\tContent-Length: " + request.getContentLength()+"\n";

		Enumeration<String> en = request.getParameterNames();
		while(en.hasMoreElements()){
			messg+="\n\t\t" + request.getParameter(en.nextElement());
		}
		messg+="\n\n\t}";
		return messg;
	}

	public void requestInitialized(ServletRequestEvent ev) {
		loggerLevel();
		LOGGER.severe("\n>>>>REQUEST INITIALIZED" + constructMessage(ev.getServletRequest()));
	}

	public void requestDestroyed(ServletRequestEvent ev) {
		LOGGER.severe("<<<<REQUEST DESTROYED: \n" + ev.getSource().toString());
	}

	public void contextInitialized(ServletContextEvent evt){
		loggerLevel();
		LOGGER.fine(">>>>CONTEXT INITIALIZED" + evt.toString());
	}

	public void contextDestroyed(ServletContextEvent evt){
		LOGGER.severe("<<<<CONTEXT DESTROYED" + evt.toString());
	}
}