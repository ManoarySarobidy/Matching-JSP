package servlet;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.lang.reflect.*;
import object.*;
import sql.Connect;


public class CriterialServlet extends HttpServlet{
	public void doPost( HttpServletRequest request , HttpServletResponse response ) throws IOException, ServletException{
		// ato no migerer anle critere reny
		double[] value = new double[7];
		value[0] = Double.valueOf( String.valueOf( request.getParameter("salary") ) );
		value[1] = Double.valueOf( String.valueOf( request.getParameter("nationality") ) );
		value[2] = Double.valueOf( String.valueOf( request.getParameter("finoana") ) );
		value[3] = Double.valueOf( String.valueOf( request.getParameter("diplome") ) );
		value[4] = Double.valueOf( String.valueOf( request.getParameter("mifoka") ) );
		value[5] = Double.valueOf( String.valueOf( request.getParameter("teinte") ) );
		value[6] = Double.valueOf( String.valueOf( request.getParameter("longeur") ) );
		
		Annexe annexe = new Annexe();
		String idUser = (String)request.getServletContext().getAttribute("id");
		Connection connection = null;
		try{
			connection = new Connect().getOracle(); 
			Field[] fields = annexe.getClass().getDeclaredFields();
			for( int i = 1; i < fields.length -1 ; i++ ){
				Method method = annexe.getClass().getMethod( "set" + annexe.toUpperFirst(fields[i].getName()) , Double.TYPE);
				method.invoke( annexe , value[ i - 1 ] );
			}
			annexe.setIdUser(idUser);
			annexe.setIdAnnexe( annexe.createPrimaryKey(connection) );
			annexe.insert(connection);

			// de mila foronina le user 
			User user = new User(idUser);
			user = user.getUser();

			ServletContext context = request.getServletContext();
			context.setAttribute("User",user);
			RequestDispatcher dispatcher = request.getRequestDispatcher("match");
			dispatcher.forward(request,response);
		}catch (Exception e) {
			PrintWriter out = response.getWriter();
			out.println( e );
		}finally{
			if(connection!=null){
				try{
					connection.close();
				}
				catch (Exception e) {}
			}
		}
	}
}