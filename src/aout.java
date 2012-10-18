import java.util.*;

class aout 
{
	static Scanner input = new Scanner(System.in);
	static int[][] pictures = new int[1000][1000];
	static double sweep = 0;
	
	public static void main(String[] args)
	{
	     while(input.hasNext())
	     {
	    	 int runner = input.nextInt();
	    	 int adamx  = input.nextInt();
	    	 int adamy = input.nextInt();
	    	 double theta = input.nextInt();

	    	 int[] list2 = new int[runner*2];

	    	 for(int y = 0; y < runner*2; y++)
	    	 {
	    		 list2[y] = input.nextInt();
	    	 }
	    	 
	    	 for(int y = 0; y < runner*2; y++)
	    	 {
	    		 if(y%2==0){
	    			 list2[y] = list2[y]-adamx;
	    		 } else {
	    			 list2[y] = list2[y]-adamy;
	    		 }
	    	 }
	    	 
	    	 radar(runner, list2,theta);
	    	 
	    	 //SolveProblem(list1, list2);
	    	 
	    	 //System.out.println("Case " + x + ":" + SolveProblem();
	    	 //for(int r = 0; r < 3; r++)
	    	// {
	    	//	 System.out.print(list1[r] + " ");
	    		 
	    	// }
//	    	 System.out.println();
//	    	 for(int t = 0; t < runner*2; t++)
//	    	 {
//	    		 System.out.print(list2[t] + " ");
//	    		 
//	    	 }
	     } 
	}
	
	public static double calcangle(int x, int y)
	{		
		int absx = Math.abs(x);
		int absy = Math.abs(y);
		if(x==0)
		{
			if(y>0){
				return 90;
			}
			if(y<0){
				return 270;
			}
		}
		if(x>0){
			if(y>0){
				return Math.atan(absy/absx)*(180/Math.PI);
			}
			if(y<0){
				return Math.atan(absy/absx)*(180/Math.PI)+270;
			}
		}
		if(x<0){
			if(y>0){
				return Math.atan(absy/absx)*(180/Math.PI)+90;
			}
			if(y<0){
				return Math.atan(absy/absx)*(180/Math.PI)+180;
			}
		}
		if(y==0){
			if(x>0){
				return 0.0;
			}
			if(x<0){
				return 180.0;
			}
		}
		
		return 0.0;
	}
	
	public static void radar(int runner, int[] list, double theta)
	{
		int i = 0;
		double lastangle=1000;
		for(int y = 0; y < runner; y++)
   	 	{
			
			double currangle = calcangle(list[y], list[y+1]);
			
			if (lastangle==1000){

				lastangle = currangle;
				
				pictures[i][y]= list[y];
				pictures[i][y+1]=list[y+1];
			}
			else {
				
				if(currangle-lastangle<=theta){
					lastangle = currangle;
					pictures[i][y*2]= list[y];
					pictures[i][y*2+1]=list[y+1];
				}
				if(currangle-lastangle>theta){
					lastangle = currangle;
					i++;
				}
			}
   	 	}
		System.out.printf("%d \n", i+1);
		System.out.printf("%f ", Math.atan(1.0/4)*(180/Math.PI));
	}
//	//public static void SolveProblem(int[] list1, int[] list2)
//	//{
//		
//	}


}
