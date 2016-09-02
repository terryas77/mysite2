package kr.co.saramin.mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MVCUtil {
	public static void redirect(HttpServletRequest request, HttpServletResponse response, String url)
		throws ServletException, IOException {
		response.sendRedirect(url);
	}

	public static void forward(HttpServletRequest request, HttpServletResponse response, String path)
		throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

	public static Long validLong( String value, Long defaultValue ) {
		return ( value != null && value.matches("[-+]?\\d*\\.?\\d+") ) ? Long.parseLong( value ) : defaultValue;
	}
	
	public static Integer validInt( String value, Integer defaultValue ) {
		return ( value != null && value.matches("[-+]?\\d*\\.?\\d+") ) ? Integer.parseInt( value ) : defaultValue;
	}
	
}
