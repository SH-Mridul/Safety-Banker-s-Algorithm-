package DeadLockSafetyAlgo;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int[][] allocation = new int[5][3];
		int[][] max = new int[5][3];
		int[] avilable = new int[3];
		int[][] mid = new int[5][3];
		boolean[] finish = new boolean[5];
		String safe = "";
		
		for(int i = 0; i<allocation.length; i++)
		{
			for(int j = 0; j<allocation[i].length; j++)
			{
				if(j == 0)
				{
					//getting allocation value
					System.out.print("Enter P-"+i+" allocation value for A:");
					allocation[i][j] =  input.nextInt();
					
					//getting max value
					System.out.print("Enter P-"+i+" Max value for A:");
					max[i][j] =  input.nextInt();
					
					//calculating mid value
					mid[i][j] = max[i][j] - allocation[i][j];
				}
				
				if(j == 1)
				{
					//getting allocation value
					System.out.print("Enter P-"+i+" allocation value for B:");
					allocation[i][j] =  input.nextInt();
					
					//getting max value
					System.out.print("Enter P-"+i+" Max value for B:");
					max[i][j] =  input.nextInt();
					
					//calculating mid value
					mid[i][j] = max[i][j] - allocation[i][j];
				}
				
				if(j == 2)
				{
					
					//getting allocation value
					System.out.print("Enter P-"+i+" allocation value for C:");
					allocation[i][j] =  input.nextInt();
					
					//getting max value
					System.out.print("Enter P-"+i+" Max value for C:");
					max[i][j] =  input.nextInt();
					
					//calculating mid value
					mid[i][j] = max[i][j] - allocation[i][j];
				}
				
			}
		}
		
		System.out.println("--------------------------------------------------------");
		
		
		//getting available value
		for(int i = 0; i<3; i++)
		{
			if(i == 0)
			{
				System.out.print("Enter Available value for A:");	
				avilable[i] = input.nextInt();
			}
			
			if(i == 1)
			{
				System.out.print("Enter Available value for B:");	
				avilable[i] = input.nextInt();
			}
			
			if(i == 2)
			{
				System.out.print("Enter Available value for C:");	
				avilable[i] = input.nextInt();
			}
			
		}
		
		
		int index = 0;
		int counter = 0;
		
		while(!checkFinish(finish))
		{
			if(index<allocation.length) {
				if(finish[index] == false && check(avilable,mid[index]))
				{
					finish[index] = true;
					
					for(int i = 0; i<avilable.length; i++)
					{
						avilable[i] += allocation[index][i];
					}
					
					
					counter++;
					if(counter == 5)
						safe+= "P"+index;
					else
						safe+= "P"+index+"--->";
				}
				
				index++;
			}else {
				index = 0;
			}
		}
		
		
		System.out.println("----------------------------------------------------------------------");
		System.out.println(safe);
		
		input.close();
		
	}
	
	
	//check avaiable or not
	public static boolean check(int[] avaiable, int[] mid)
	{
		boolean flag = false;
		
		for(int i = 0; i<avaiable.length; i++)
		{
			if(mid[i]<= avaiable[i]) {
				flag = true;
			}else {
				return false;
			}
		}
		
		return flag;
	}
	
	
	//check finish
	public static boolean checkFinish(boolean[] finish)
	{
		int count = 0;
		
		for(int i = 0; i<finish.length; i++)
		{
			if(finish[i])
				count++;
		}
		
		if(count == finish.length)
			return true;
		
		return false;
	}
}
