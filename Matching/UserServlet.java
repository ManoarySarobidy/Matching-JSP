package servlet;

import java.sql.*;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import object.*;
import sql.*;

public class UserServlet extends HttpServlet{
	public void doPost( HttpServletRequest request, HttpServletResponse response ) throws IOException,ServletException{
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		String sex = request.getParameter("sexe");
		// Eto amzay le mamorona clé primaire tampoka sy clé oanle olona
		User user = new User( userName , password );
		user.setSexe(sex);
		Connection connection = null;
		try{
			connection = (new Connect()).getOracle();
			user.setIdUser( user.createPrimaryKey(connection) );
			user.insert( connection );
			// azo eto ny idUser de ndao atao anaty servlet
			ServletContext session = request.getServletContext();
			session.setAttribute("id",user.getIdUser());
			RequestDispatcher dispatcher = request.getRequestDispatcher("Inscription.jsp");
			dispatcher.forward(request,response);
		}catch (Exception e) {
			PrintWriter out = response.getWriter();
			out.println(e);
			e.printStackTrace();
		}finally{
			try{
				if( connection != null ){
					connection.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}