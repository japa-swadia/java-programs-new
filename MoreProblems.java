import java.util.*;
import java.io.*;

//1. matching words from two strings
//2. find if there is a triplet in the array such that a+b+c=0
//3. length of largest consecutive sequence
//4. remove duplicates from array II (at most 2 allowed)
//5. contains nearby duplicate

public class MoreProblems {
	
	public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		
		if(nums == null || nums.length < 2 || k <= 0 || t < 0)
			return false;
		
		TreeSet<Long> set = new TreeSet<Long>();
		for(int i=0; i<nums.length; i++)
		{
			long n = (long)nums[i];
			
			if((set.floor(n) != null && n <= t + set.floor(n)) || (set.ceiling(n) != null && set.ceiling(n) <= t + n))
			{
				return true;
			}
			set.add(n);
			
			if(i >= k)
				set.remove((long)nums[i-k]);
		}
      
        return false;
	}

	
	public static int removeDuplicates(int[] nums)
	{
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for(int i=0;i<nums.length;i++)
		{
			if(hm.containsKey(nums[i]))
			{
				hm.put(nums[i], hm.get(nums[i])+1);
			}
			else
			{
				hm.put(nums[i], 1);
			}
		}
		
		int count = 0;
		for(int k:hm.keySet())
		{
			if(hm.get(k)>=2)
			{
				count+=2;
			}
			else
			{
				count++;
			}
		}
		return count;
	}
	
	public static int removeDuplicates2(int[] nums) {
	    int i = 0;
	    for (int n : nums)
	        if (i < 2 || n > nums[i-2])
	            nums[i++] = n;
	    return i;
	}
	
	public static int largestConsecutiveSeq(int[] arr)
	{
		Set<Integer> set = new HashSet<Integer>();
		int max = 0;
		 for(int i=0;i<arr.length;i++)
		 {
			 set.add(arr[i]);
		 }
		 
		 for(int i=0;i<arr.length;i++)
		 {
			 int count = 1;
			 
			 int num = arr[i];
			 while(set.contains(--num))
			 {
				 count++;
				 set.remove(num);
			 }
			 
			 num = arr[i];
			 while(set.contains(++num))
			 {
				 count++;
				 set.remove(num);
			 }
			 max = Math.max(max,  count);
		 }
		 return max;
	}
	
	/*public static boolean hasTriplet(int[] array)
	{
		//int[] arr = quicksort(array,array[0], array[array.length-1]);
		Arrays.sort(array);
		
		int len = array.length;
		for(int i=0;i<len-2;i++)
		{
			int j = i + 1;
			int k = len-1;
			while(j<k)
			{
				if(array[i] + array[j] + array[k] == 0)
					return true;
			}
		}
		return false;
	}*/
	
	public static ArrayList<String> findMatchingWords(String s1, String s2)
	{
		String[] words1 = s1.split(" ");
		String[] words2 = s2.split(" ");
		
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> matchlist = new ArrayList<String>();
		for(int i=0;i<words1.length;i++)
		{
			list.add(words1[i]);
		}
		for(int j=0;j<words2.length;j++)
		{
			if(list.contains(words2[j]))
			{
				matchlist.add(words2[j]);
			}
		}
		
		return matchlist;
		
	
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "hello hi there bye";
		String t = "hi please come bye";
		ArrayList<String> match = findMatchingWords(s,t);
		
		System.out.println(match.toString());
		
		/*int[] a = {1,4,2,0,-1,8};
		boolean answer = hasTriplet(a);
		if(answer)
			System.out.println("YES");
		else
			System.out.println("NO");*/
		
		int[] array = {-1,8,4,1,0,-1,5,9,7,6,3};
		int largest = largestConsecutiveSeq(array);
		System.out.println(largest);
		
		int[] numbers = {1,1,1,2};
		int newlen = removeDuplicates(numbers);
		int newlen2 = removeDuplicates2(numbers);
		System.out.println(newlen);
		System.out.println(newlen2);
		
		int[] nums = {1,3,1};
		if(containsNearbyAlmostDuplicate(nums, 1, 1))
		{
			System.out.println("YES");
		}
		else
		{
			System.out.println("NO");							
			
		}

	}

}
