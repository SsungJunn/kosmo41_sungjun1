public class Quiz06 {

	public static void main(String[] args) {
		int[][] arr = new int[3][9];		
		
		
		for(int i = 0; i < arr.length; i++)
		{
			for(int j = 0; j < arr[i].length; j++)
			{		
					arr[i][j] = (i+2)*(j+1);
					System.out.print((i+2) + " x " + (j+1) + " = " + arr[i][j] + "\t");
			}
			System.out.println();
		}		
	}
}


/*
for(int i = 0; i < arr.length; i++)
{
	for(int j = 0; j < arr.length; j++)
	{		
	System.out.print(arr[i][j] + "\t");
	}
	System.out.println();
}
*/