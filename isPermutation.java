import java.io.*;
import java.util.*;

public class isPermutation {
	
	public static boolean isPerm(String s, String t)
	{
		if(s.length()!=t.length())
		{
			return false;
		}
		char[] s_arr = s.toCharArray();
		char[] t_arr = t.toCharArray();
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		for(char c : s_arr)
		{
			if(map.containsKey(c))
			{
				map.put(c, map.get(c) + 1);
			}
			else
			{
				map.put(c, 1);
			}
		}
		
		for(char c: t_arr)
		{
			if(map.containsKey(c))
			{
				map.put(c, map.get(c) - 1);
			}
		}
		for(char ch : map.keySet())
		{
			if(map.get(ch) != 0)
				return false;
		}
		
		return true;
	}
	
	public static boolean checkPermutation(String s, String t)
	{
		if(s.length()!=t.length())
		{
			return false;
		}
		
		Map<Character, Integer> hmap1 = new HashMap<Character, Integer>();
		Map<Character, Integer> hmap2 = new HashMap<Character, Integer>();
		
		for(int i = 0;i<s.length()&&i<t.length();i++)
		{
			char c = s.charAt(i);
			char d = t.charAt(i);
			
			if(hmap1.containsKey(c) && hmap2.containsKey(d))
			{
				hmap1.put(c, hmap1.get(c)+1);
				hmap2.put(d, hmap1.get(d)+1);
			}
			else
			{
				hmap1.put(c, 1);
				hmap2.put(d, 1);
			}
		}
		if(hmap1.equals(hmap2))
		{
			return true;
		}
		return false;
	}
	
	public static boolean checkPermutation2(String s, String t)
	{
		char[] s_arr = s.toCharArray();
		char[] t_arr = t.toCharArray();
		
		Arrays.sort(s_arr);
		Arrays.sort(t_arr);
		
		return Arrays.equals(s_arr, t_arr);
	}
	
	public static boolean isPalindromePermutation(String s)
	{
		HashMap<Character, Integer> hmap = new HashMap<Character, Integer>();
		for(int i = 0;i<s.length();i++)
		{
			char c = s.charAt(i);
			
			
			if(hmap.containsKey(c))
			{
				hmap.put(c, hmap.get(c)+1);
				
			}
			else
			{
				hmap.put(c, 1);
				
			}
		}
		int oddCount = 0;
		for(char ch:hmap.keySet())
		{
			if(hmap.get(ch) == 1)
				oddCount++;
		}
		if(oddCount > 1)
			return false;
		
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "gods";
		String b = "dogs";
		
		if(checkPermutation(a,b))
		{
			System.out.println("Yes");
		}
		else
		{
			System.out.println("No");
		}
	
		if(checkPermutation2(a,b))
		{
			System.out.println("Yes");
		}
		else
		{
			System.out.println("No");
		}
		
		if(isPalindromePermutation("redder"))
		{
			System.out.println("Yes");
		}
		else
		{
			System.out.println("No");
		}
	
				

	}

}
