import java.io.*;
import java.util.*;

//ctci - compression 1.5

public class Solution10 {
	
	public String compress(String str)
	{
		int size = countCompress(str);
		if (size >= str.length())
				return str;
		StringBuffer sbuf = new StringBuffer();
		char last = str.charAt(0);
		int count = 1;
		for(int i=1;i<str.length();i++)
		{
			if(str.charAt(i)==last)
			{
				count++;
			}
			else
			{
				sbuf.append(last);
				sbuf.append(count);
				last = str.charAt(i);
				count = 1;
			}
		}
		sbuf.append(last);
		sbuf.append(count);
		return sbuf.toString();
	}
	
	int countCompress(String str)
	{
		if(str==null || str.isEmpty())
			return 0;
		char last = str.charAt(0);
		int size =0;
		int count = 1;
		for(int i=1;i<str.length();i++)
		{
			if(str.charAt(i)==last)
			{
				count++;
			}
			else
			{
				last = str.charAt(i);
				size = size + 1 + String.valueOf(count).length();
				count = 1;
				
			}
		}
		size = size + 1 + String.valueOf(count).length();
		return size;
	}
	
	public static void main(String[] args) {
		Solution10 s1 = new Solution10();
		String s = s1.compress("abcd");
		System.out.println(s);
		// TODO Auto-generated method stub
		String a = s.substring(0, 3);
		System.out.println(a);
		

	}

}
