import java.io.*;
import java.util.*;

//1. find max sum in a contiguous sub array in an array
//2. find minimal difference between two ;pairs in unsorted array
//3. find length of longest increasing subsequence

public class MaxSumSubarray {
	
	public int longestIncSubseq(int[] n)
	{
		if(n == null || n.length == 0)
			return 0;
		if(n.length == 1)
			return 1;
		
		
		
		return 0;
	}
	
	public static int findMinDiff(int[] nums)
	{
		if(nums == null || nums.length == 0 || nums.length == 1)
			return 0;
		
		Arrays.sort(nums);
		
		int min_diff = Integer.MAX_VALUE;
		for(int i = 0; i < nums.length - 1; i++)
		{
			int cur_diff = nums[i+1] - nums[i];
			if( cur_diff < min_diff)
				min_diff = cur_diff;
		}
		
		return min_diff;
	}
	
	public static int findMaxSum(int[] a)
	{
		int current_sum = a[0];
		int max_sum = a[0];
		
		for(int i=1;i<a.length;i++)
		{
			current_sum = Math.max(current_sum+a[i], a[i]);
			max_sum = Math.max(max_sum, current_sum);
		}
		
		return max_sum;
	}
	
	public static int findMaxSumCtci(int[] a)
	{
		int current_sum = 0;
		int max_sum = 0;
		
		for(int i=0;i<a.length;i++)
		{
			current_sum = current_sum + a[i];
			if(max_sum < current_sum)
			{
				max_sum = current_sum;
			}
			else if(current_sum < 0)
			{
				current_sum = 0;
			}
			
		}
		return max_sum;
	}
	
	public static int findMaxSumCtci2(int[] a)
	{
		int current_sum = a[0];
		int max_sum = a[0];
		
		for(int i=1;i<a.length;i++)
		{
			
			current_sum = current_sum + a[i];
			if(a[i] > current_sum)
			{
				current_sum = a[i];
			}
			
			if(max_sum < current_sum)
			{
				max_sum = current_sum;
			}
			
			
		}
		return max_sum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] n = {-1,-2,3,0,-5,4,0,1,-7};
		int max = findMaxSum(n);
		int max2 = findMaxSumCtci(n);
		int max3 = findMaxSumCtci2(n);
		System.out.println(max);
		System.out.println(max2);
		System.out.println(max3);
		
		int[] numbers = {20,4,16,1,9, -1};
		int ldiff = findMinDiff(numbers);
		System.out.println(ldiff);
		
		int[] seq = {10, 9, 2, 5, 3, 7, 101, 18};
		//int seq_len = longestInc

	}

}
