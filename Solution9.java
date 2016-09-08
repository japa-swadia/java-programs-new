import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//isomorphic strings

public class Solution9 {
	
	public static boolean isIsomorphic(String s, String t)
	{
		
		if(s==null)
			return t==null;
		Map<Character, Character> map = new HashMap<Character, Character>();
		//HashSet<Character> set = new HashSet<Character>();
		char[] s_arr = s.toCharArray();
		char[] t_arr = t.toCharArray();
		
		for(int i=0;i<s_arr.length;i++)
		{
			if(map.containsKey(s_arr[i]))
			{
				
				if(map.get(s_arr[i])!=t_arr[i])
					return false;
			}
			
			else if(map.containsValue(t_arr[i]))
			{
				return false;
			}
			else
			{
				map.put(s_arr[i], t_arr[i]);
			}
			
		}
		return true;
	}

	public static void main(String[] args) {
		if(isIsomorphic("paper", "title"))
		{
			System.out.println("yes");
		}
		else
		{
			System.out.println("no");
		}
		// TODO Auto-generated method stub

	}

}
