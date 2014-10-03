package servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.DispatcherServlet;

public class MyServlet extends DispatcherServlet {

	@Override
	protected void doService(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		System.out.println("////////////////doService call!" + request.getRequestURL() + "?" +request.getQueryString());
		super.doService(request, response);
		
	}
	
	
	
}
