import java.util.*;
import java.io.*;

//1. binary addition
//2. Backtracking - Subsets
//3. create balanced BST from sorted array
//4. angle between hour and minute hand in analog clock
//5. fibonacci series


public class MorePractice {
	public static int[] fibonacciIterative(int num)
	{
		int[] fibonacci;
		
		if(num == 1)
		{
			return new int[]{0};
		}
		else if(num == 2)
		{
			return new int[]{0,1};
		}
		else
		{
			fibonacci = new int[num];
			fibonacci[0] = 0;
			fibonacci[1] = 1;
			
			
			for(int i = 2; i<num; i++)
			{
				fibonacci[i] = fibonacci[i-2] + fibonacci[i-1];
			}
		}
		
		return fibonacci;
	}
	
	public static int fibonacciRecursive(int num)
	{
		if(num == 1 || num == 2)
		{
			return 1;
		}
		
		else
		{
			return fibonacciRecursive(num-1) + fibonacciRecursive(num-2);
		}
	}
	
	
	public static int findAngle(int h, int m) 
	{
		if(h > 12 || m > 60)
		{
			System.out.println("Invalid hour/minute value");
			return 0;
		}
		if(h == 12)
		{
			h = 0;
		}
		
		if(m == 60)
		{
			m = 0;
			h = (h+1)%12;
		}
		
		int hour_angle = (int) ((h*60 + m)*0.5);
		int minute_angle = m*6;
		
		int angle = Math.abs(hour_angle - minute_angle);
		
		return angle;
	}
	
	public TreeNode createBST(int[] arr)
	{
		if(arr.length == 0)
			return null;
		
		return createBST(arr, 0, arr.length-1);
	}
	
	public TreeNode createBST(int[] arr, int start, int end)
	{
		if(start > end)
			return null;
		
		int mid = (start + end)/2;
		TreeNode root = new TreeNode(arr[mid]);
		root.left = createBST(arr, start, mid-1);
		root.right = createBST(arr, mid+1, end);
		
		return root;
		
	}
	
	public static List<List<Integer>> subsets(int[] nums) {
	    List<List<Integer>> list = new ArrayList<>();
	    Arrays.sort(nums);
	    backtrack(list, new ArrayList<>(), nums, 0);
	    return list;
	}

	private static void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
	    list.add(new ArrayList<>(tempList));
	    for(int i = start; i < nums.length; i++){
	        tempList.add(nums[i]);
	        backtrack(list, tempList, nums, i + 1);
	        tempList.remove(tempList.size() - 1);
	    }
	}
	public static String addBinary(String a, String b)
	{
		if(a==null || a.length()==0)
			return b;
		if(b==null || b.length()==0)
			return a;
		
		int lenA = a.length()-1;
		int lenB = b.length()-1;
		
		int carry = 0;
		StringBuilder sb = new StringBuilder();
		
		while(lenA>=0 || lenB>=0)
		{
			int var_a = 0;
			int var_b = 0;
			
			if(lenA>=0)
			{
				var_a = a.charAt(lenA) == 0 ? 0:1;
				lenA--;
			}
			if(lenB>=0)
			{
				var_b = b.charAt(lenB) == 0 ? 0:1;
				lenB--;
			}
			
			int sum = var_a + var_b + carry;
			if(sum>=2)
			{
				sb.append(String.valueOf(sum-2));
				carry = 1;
			}
			else
			{
				sb.append(String.valueOf(sum));
				carry = 0;
			}
		}
		if(carry == 1)
		{
			sb.append("1");
		}
		String addition = sb.reverse().toString();
		
		return addition;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "11";
		String t = "1";
		
		String answer = addBinary(s,t);
		System.out.println(answer);
		
		int angle = findAngle(5, 30);
		System.out.println(angle);
		
		int[] result = fibonacciIterative(4);
		for(int i=0;i<result.length;i++)
		{
			System.out.print(result[i]+" "+"\n");
		}
		
		int number = 4;
		for(int j=1; j<number; j++)
		{
			System.out.print(fibonacciRecursive(j)+" ");
		}

	}

}
