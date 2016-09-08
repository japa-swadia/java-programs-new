import java.io.*;
import java.util.*;

//1. remove duplicate elements from array
//2. check if array contain duplicates such that difference of their indices are at most (given) k
//3. longest common prefix
//4. sort array of strings such that all anagrams are grouped together

public class DupChars {
	
	//sort strings
	public static String sortChars(String s)
	{
		char[] chars = s.toCharArray();
		Arrays.sort(chars);
		
		return new String(chars);
	}
	
	//group anagrams together
	public static String[] sortAnagrams(String[] arr)
	{
		if(arr.length == 0 || arr.length== 1)
			return arr;
		
		HashMap<String, LinkedList<String>> map = new HashMap<String, LinkedList<String>>();
		for(String s : arr)
		{
			String key = sortChars(s);
			if(!map.containsKey(key))
			{
				map.put(key, new LinkedList<String>());
			}
			LinkedList<String> value = map.get(key);
			value.push(s);
		}
		
		int index = 0;
		String[] sortedArr = new String[arr.length];
		for(String k : map.keySet())
		{
			LinkedList<String> sortedList = map.get(k);
			for(String t : sortedList)
			{
				sortedArr[index++] = t;
			}
		}
		
		return sortedArr;
	}
	
	
	public static String longestCommonPrefix(String[] strs)
	{
		if(strs == null || strs.length < 0)
			return null;
		
		String prefix = strs[0];
		for(int i = 1; i < strs.length; i++)
		{
			int j = 0;
			while(j < prefix.length() && strs[i].charAt(j) == prefix.charAt(j))
			{
				j++;
			}
			if(j == 0)
				return " ";
			
			prefix = prefix.substring(0,  j);
		}
		
		return prefix;
	}
	
	public static boolean containsNearbyDuplicate(int[] nums, int k)
	{
		HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
		
		for(int i=0;i<nums.length;i++)
		{
			if(hmap.containsKey(nums[i]) && (i-hmap.get(nums[i]))<=k)
			{
				return true;
			}
			else
			{
				hmap.put(nums[i], i);
			}
		}
		return false;
		
		
	}
	
	public static void removeDups(int[] arr)
	{
		Set<Integer> hset = new HashSet<Integer>();
		
		for(int i=0;i<arr.length;i++)
		{
			if(!hset.contains(arr[i]))
			{
				hset.add(arr[i]);
			}
		}
		
		Iterator iter = hset.iterator();
		while(iter.hasNext())
		{
			System.out.println(" "+iter.next());
		}
		
		

	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = {1,2,2,4,4,5,5,6,7,7,8,8,9,9,9,9,0};
		removeDups(numbers);
		
		int[] numbers2 = {2,6,5,4,1,4};
		boolean answer = containsNearbyDuplicate(numbers2, 3);
		if(answer)
			System.out.println("yes");
		else
			System.out.println("no");
		
		String[] strings = {"leets", "leetcode", "leeco", "leestocde"};
		String lcp = longestCommonPrefix(strings);
		System.out.println(lcp);

	}

}
