package servlet;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import object.*;
import java.sql.*;
import sql.Connect;
import formulary.Formulaire;
import java.lang.reflect.*;

public class InfoServlet extends HttpServlet{
	public void doPost( HttpServletRequest request , HttpServletResponse response  ) throws IOException, ServletException{
		Info info = new Info();
		double[] valeur = new double[7];
		valeur[0] = Double.valueOf( String.valueOf(request.getParameter("Salaire")) );
		valeur[1] = Double.valueOf( String.valueOf(request.getParameter("Nationalite")) );
		valeur[2] = Double.valueOf( String.valueOf(request.getParameter("Finoana")) );
		valeur[3] = Double.valueOf( String.valueOf(request.getParameter("Diplome")) );
		valeur[4] = Double.valueOf( String.valueOf(request.getParameter("Fumeur")) );
		valeur[5] = Double.valueOf( String.valueOf(request.getParameter("Teinte")) );
		valeur[6] = Double.valueOf( String.valueOf(request.getParameter("Taille")) );
		Connection connection = null;
		try{
			ServletContext context = request.getServletContext();
			String idUser = (String)context.getAttribute("id");
			connection = (new Connect()).getOracle();
			Field[] fields = info.getClass().getDeclaredFields();
			for( int i = 1 ; i < fields.length-1 ; i++ ){
				Method method = info.getClass().getMethod( "set" + info.toUpperFirst(fields[i].getName()) , Double.TYPE);
				method.invoke( info , valeur[ i - 1 ] );
			}

			info.setIdUser(idUser);
			info.setIdInfo(info.createPrimaryKey(connection));
			info.insert(connection);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Criterial.jsp");
			dispatcher.forward( request , response );

		}catch (Exception e) {
			PrintWriter out = response.getWriter();
			out.println(e);
		}finally{
				try{
					if(connection!=null)
						connection.close();
				}catch(Exception e){}
		}
		
	} 
}