package p1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

@WebServlet("/UpdateRegistrationServlet")
public class UpdateRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public UpdateRegistrationServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/myapp", "root", "test@123");
			Statement stmnt = con.createStatement();
			
			stmnt.executeUpdate(
					"update registration set mobile='"+mobile+"'"
							+ " where email='"+email+"'");
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
