import java.io.*;
import java.util.*;

//Find the first non-repeating character in a stream of characters

public class FirstNonRptChar {
	
	public static char getFirstChar(String str)
	{
		Map<Character, Integer> lmap = new LinkedHashMap<Character, Integer>();
		for(int i=0;i<str.length();i++)
		{
			if(lmap.containsKey(str.charAt(i)))
			{
				lmap.put(str.charAt(i), lmap.get(str.charAt(i))+1);
			}
			else
			{
				lmap.put(str.charAt(i), 1);
			}
		}
		
		for(char c:lmap.keySet())
		{
			if(lmap.get(c) == 1)
			{
				return c;
			}

		}
		return 0;
		
	}

	public static void main(String[] args) {
		
		String s = "aaabcccfdghjkooo";
		char ch = getFirstChar(s);
		System.out.println(ch);
		// TODO Auto-generated method stub

	}

}
