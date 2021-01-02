package miniproject;
import java.lang.Math; 
import java.io.IOException;
import java.io.PrintWriter;
import java.security.Timestamp;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class main
 */
public class main extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public main() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		Connection con=dbconnection.connection();
		 int  current_value =Integer.parseInt(request.getParameter("current_val"));
		 int years = Integer.parseInt(request.getParameter("years"));
		 
		 
		 
		 try{
		 	   PreparedStatement pstmt= con.prepareStatement("select *from moneyvalue where current_value=?");
		 	   pstmt.setInt(1, current_value);
				 ResultSet rs=pstmt.executeQuery(); 
					 
				 
				 //while(rs.next())
				 
				 	 PreparedStatement pstmt1= con.prepareStatement("insert into moneyvalue values(?,?)");
				 	 pstmt1.setInt(1,current_value);
				 	 pstmt1.setInt(2,years);
				 	  int i = pstmt1.executeUpdate();
				 	claculation obj=new claculation();
				 	double x=obj.cal(current_value,years);
				 	 
				 	response.setContentType("text/html");
				 	  java.sql.Statement stmt1=con.createStatement();
				 	  ResultSet rs1=stmt1.executeQuery("select * from moneyvalue");
				     PrintWriter out=response.getWriter();		 	 
				     out.println("<body style='background-color:black;'>"); 
				     out.println(" <h1 style='text-align:center'> <br> <br> <br> <font color=white>After "+years+" years the things which were purchased in "+current_value+" will cost you :"+x+"</font></h1>");
				 	 out.println("<center>");
				     out.println("<ul>");
				     out.println("<h1> <li style='list-style-type:none;' style='margin-left: 500px'; ><a  style='text-decoration:none' href='tvm.html'>Home</a></li>  </h1>");
				 	 out.println("</ul>");
				 	 out.println("</center>");
				 	 out.println("</body> ");
				 	 out.println("</html>");
				 	  
				 	 
				 	 
				 
		    }catch(SQLException e)
		    {
		    	e.printStackTrace();
		    }
		    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
