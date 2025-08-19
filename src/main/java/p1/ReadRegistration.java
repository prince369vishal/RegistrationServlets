package p1;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet("/ReadRegistration")
public class ReadRegistration extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
	PrintWriter out =	response.getWriter();
	response.setContentType("text/html");
	
try {
	 Class.forName("com.mysql.cj.jdbc.Driver");
	 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myapp", "root", "test@123");
	 
	 Statement stmnt = con.createStatement();
	 ResultSet result=stmnt.executeQuery("select * from registration");
	 
	 while(result.next()) {
		 out.println(result.getString(1));
		 out.println(result.getString(2));
		 out.println(result.getString(3));
	 }
	 
	 con.close();

} catch (Exception e) {
}	 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
