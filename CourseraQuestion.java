import java.util.HashSet;
import java.util.Set;
import java.util.*;

/*By: Japa Swadia
Question 1 : Ashley loves numbers; count numbers with no repeated digits.*/


public class CourseraQuestion {
	
	public static void countNumbers(int[][] arr)
	{
		for(int i=0; i<= arr.length-1; i++)
		{
			
			int count = 0;
			for(int j=arr[i][0]; j<=arr[i][1]; j++)
			{
				int digits = 0;
				Set<Integer> set = new HashSet<Integer>();
				int val = j;
				while(val>0)
				{
					int temp = val%10;
					set.add(temp);
					val = val/10;
					digits++;
				}
				if(digits == 1)
					count++;
				if(digits>1 && set.size() > 1)
					count++;
					
			}
			System.out.println(count);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a = new int[][]{{1,11}, {210,370}};
		
		countNumbers(a);

	}

}
