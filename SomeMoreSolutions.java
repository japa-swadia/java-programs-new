import java.util.*;

//1. reverse integer
//2. longest common prefix
//3. happy number
//4. count numbers with non-repeating digits
//5. compare version numbers


public class SomeMoreSolutions {
	public static boolean isHappier(int n)
	{
		if(n == 1)
			return true;
		
		return isHappier(n, null);
	}
	public static boolean isHappier(int n, HashSet<Integer> visited)
	{
		if(n == 1)
			return true;
		
		if(visited == null)
			visited = new HashSet<Integer>();
		
		if(visited.contains(n))
			return false;
		
		int sq = 0;
		visited.add(n);
		
		while(n > 0)
		{
			int temp = n%10;
			sq += temp*temp;
			n = n/10;
		}
		
		return isHappier(sq, visited);
	}
	public static boolean isHappy(int n, HashSet<Integer> visited)
	{
		
		if(n == 1)
			return true;
		if (visited==null)
				visited = new HashSet<Integer>();
		if(visited.contains(n))
			return false;
		
		int sq = 0;
		visited.add(n);
	
		while(n > 0)
			{
				int temp = n%10;
				sq += temp*temp;
				n = n/10;
			}
		
		return isHappy(sq, visited);
						
	}
	
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
	
	public static int compareVersions(String version1, String version2)
	{
		String[] v1 = version1.split("\\.");
		String[] v2 = version2.split("\\.");
		
		
		int v12;
		int v11 = Integer.parseInt(v1[0]);
		if(v1.length < 2)
		{
			v12 = 0;
		}
		else
			v12 = Integer.parseInt(v1[1]);
		
		int v21 = Integer.parseInt(v2[0]);
		int v22;
		if(v2.length < 2)
			v22 = 0;
		else
			v22 = Integer.parseInt(v2[1]);
		
		
		if(v11 > v21)
			return 1;
		
		else if(v11 < v21)
			return -1;
		
		else
			if(v11 == v21)
			{
				if(v12 < v22)
					return -1;
				else if(v12 > v22)
					return 1;
				else
					return 0;
			}
		
		
		return 0;
	}

	public static int reverseInt(int x)
	{
		int res = 0;
		boolean flag = false;
		if(x < 0)
		{
			x = 0 - x;
			flag = true;
		}
		int p = x;
		while(p > 0)
		{
			int digit = p%10;
			p = p/10;
			res = res*10 + digit;
		}
		
		
		if(flag)
			return 0 - res;
		
		return res;
	}
	public static void main(String[] args) {
		
		String s = "1.5";
		String[] sp = s.split(".");
		for(String str:sp)
		{
			System.out.println(str);
			System.out.println("nn");
		}
		
		int num1 = 151;
		int num2 = -974;
		
		int pal = 151;
		
		int reverse = reverseInt(num1);
		System.out.println(reverse);
		if( pal == reverse)
			System.out.println("Palindrome integer");
		
		// TODO Auto-generated method stub
		
		int version = compareVersions("1", "1.0");
		System.out.println(version);
		
		
		/*int[][] a = new int[][]{{1,11}, {210,270}};
		
		countNumbers(a);*/
		
		boolean happy = isHappy(20, null);
		if(happy)
		{
			System.out.println("YES");
		}
		else
		{
			System.out.println("NO");
		}
		
		boolean happier = isHappier(19, null);
		if(happier)
		{
			System.out.println("YES");
		}
		else
		{
			System.out.println("NO");
		}

	}

}
