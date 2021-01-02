package miniproject;

public class inflationcal {

	public inflationcal() {
		// TODO Auto-generated constructor stub
	}
	
	float inf(int cpi_previousyear, int cpi_thisyear)
	{
		 float inflation_rate=0;
		
		 
		float half_value=0;
		
		half_value=cpi_thisyear -cpi_previousyear;
		
		inflation_rate=(half_value/cpi_previousyear)*100;
	 	
	 	return  inflation_rate;
		
		
	
	}	

}
