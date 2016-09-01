

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




public class RegServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	Connection con;
	Statement st;
	
	public void init() throws ServletException {
		try {
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","tejasri");
			st=con.createStatement();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
    
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
	PrintWriter pw=response.getWriter();
	String firstname=request.getParameter("firstname");
	String lastname=request.getParameter("lastname");
	String email=request.getParameter("email");
	String password=request.getParameter("password");
	String mobileno=request.getParameter("mobileno");
	try {
		int i = st.executeUpdate("insert into register values('"+firstname+"','"+lastname+"','"+email+"','"+password+"','"+mobileno+"')");
		if(i!=0)
		{
			pw.print("successfullly registerd");
		}
		else{
			pw.print("sorry try again");
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
			
	}

}
