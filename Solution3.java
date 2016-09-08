import java.io.*;
import java.util.*;
//1. to check if given strings are anagrams of each other

public class Solution3 {
	
	public static boolean isAnagramMap(String s, String t)
	{
		if(s.length() != t.length())
			return false;
		
		char[] a = s.toCharArray();
		char[] b = t.toCharArray();
		
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		
		for(char c : a)
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
		
		for(char c : b)
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
	public static boolean isAnagramSort(String A, String B) {
	      char[] charA = A.toLowerCase().toCharArray();
	      char[] charB = B.toLowerCase().toCharArray();
	      Arrays.sort(charA);
	      Arrays.sort(charB);
	      
	      return Arrays.equals(charA, charB);
	   }
	
	
	
	public static void main(String[] args) {
	        
	        /*Scanner sc=new Scanner(System.in);
	        String A=sc.next();
	        String B=sc.next();
	        boolean ret=isAnagramSort(A,B);
	        if(ret)System.out.println("Anagrams");
	        else System.out.println("Not Anagrams");*/
	        
	        boolean isAn = isAnagramMap("race", "care");
	        if(isAn)
	        {
	        	System.out.println("Anagrams");
	        }
	        else
	        {
	        	System.out.println("Not Anagrams");
	        }
	    }

}
