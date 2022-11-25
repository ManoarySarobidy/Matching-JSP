package servlet;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

import object.*;
import java.util.TreeMap;

public class MatchServlet extends HttpServlet{
	public void doPost( HttpServletRequest request , HttpServletResponse response ) throws ServletException, IOException{
		// mamorona match
		User user = (User)request.getServletContext().getAttribute("User");
		PrintWriter out = response.getWriter();
		// out.println(user.toString());
		try{
			Match match = new Match(user);
			TreeMap<Double,User> compatible = match.match();
			ServletContext context = request.getServletContext();
			context.setAttribute("match",compatible);
			RequestDispatcher dispatcher = request.getRequestDispatcher("ShowList.jsp");
			dispatcher.forward( request , response );

		}
		catch (Exception e) {
			// PrintWriter out = response.getWriter();
			out.println(e);
		}
	}
}