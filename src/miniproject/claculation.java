package miniproject;

public class claculation {

	public claculation() {
		// TODO Auto-generated constructor stub
	}
	int cal(int current_value, int years)
	{
		int future_value=0;
		 double arg1=0;
		  double half_value;
		 
		half_value=(1+0.055);
	 	 arg1=Math.pow(half_value,years);
	 	
	 	return future_value=(int) ((current_value)*(arg1));
		
		
	}
	

}
