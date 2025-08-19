package p1;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.ServletException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String name =request.getParameter("name");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String id = request.getParameter("id");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection
					("jdbc:mysql://localhost:3306/myapp","root","test@123");
			Statement stmnt =con.createStatement();
			stmnt.executeUpdate("insert into registration values"
					+ "('"+id+"','"+name+"','"+email+"','"+mobile+"')");
			
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}