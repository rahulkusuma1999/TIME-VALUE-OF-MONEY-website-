package miniproject;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class inflationrate
 */
public class inflationrate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public inflationrate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		

		
		Connection con=dbconnection.connection();
		 int  cpi_previousyear =Integer.parseInt(request.getParameter("cpi_previousyear"));
		 int cpi_thisyear = Integer.parseInt(request.getParameter("cpi_thisyear"));
		 
		 
		 
		 try{
		 	   PreparedStatement pstmt= con.prepareStatement("select *from inflationrate where cpi_thisyear=?");
		 	   pstmt.setInt(1,cpi_thisyear );
				 ResultSet rs=pstmt.executeQuery(); 
					 
				 
				 //while(rs.next())
				 
				 	 PreparedStatement pstmt1= con.prepareStatement("insert into inflationrate values(?,?)");
				 	 pstmt1.setInt(1,cpi_previousyear);
				 	 pstmt1.setInt(2,cpi_thisyear);     
				   
				 	  int i = pstmt1.executeUpdate();
				 	inflationcal obj=new inflationcal();
				 	double x=obj.inf(cpi_previousyear,cpi_thisyear);
				 	 
				 	  response.setContentType("text/html");
				 	  java.sql.Statement stmt1=con.createStatement();
				 	  ResultSet rs1=stmt1.executeQuery("select *from inflationrate");
				     PrintWriter out=response.getWriter();	
				   
				    // out.print("<html><head><style='text/css'>{.h1{color:red;}}</style></head>");
				     out.println("<body style='background-color:black'>");				     
				     
				     out.println(" <h1 style='text-align:center'> <br> <br> <br> <font color=white>The inflation rate of the year is "+x+"% </h1></font>");
				 	 out.println("<center>");
				     out.println("<ul>");
				     out.println("<h1> <li style='list-style-type:none;' style='margin-left: 500px'; ><a  style='text-decoration:none' href='inflation2.html'>Home</a></li>  </h1>");
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
