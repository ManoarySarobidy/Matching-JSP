package servlet;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import object.User;
public class Login extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		// nde andao alaina le user de tediavina any izay manana an'ilay mot de passe sy login
		String username = request.getParameter("username"); 
		String password = request.getParameter("password"); 
		User user = new User();
		try{
			user.login( username , password );
			ServletContext session = request.getServletContext();
			session.setAttribute("User" , user);
			RequestDispatcher dispatcher = request.getRequestDispatcher("match");
			dispatcher.forward( request, response );	
		}catch (Exception e) {
			PrintWriter out = response.getWriter();
			out.println( e );
			// response.sendRedirect("index.jsp");
		}
	}
}