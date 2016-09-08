import java.io.*;
import java.util.*;

//1. reverse words in a string
//2. reverse vowels in a string
//3. reverse entire string
//4. reverse word positions in a string

public class Reverse {
	
	public static boolean isVowel(char c)
	{
		if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'  || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')
			return true;
		
		return false;
	}
	
	
	public static String reverseVowels(String s) {
        
		char[] str = s.toCharArray();
		int i = 0;
		int j = str.length-1;
		while(i < j)
		{
			if(!isVowel(str[i]) && isVowel(str[j]))
			{
				i++;
			}
			else if(isVowel(str[i]) && !isVowel(str[j]))
			{
				j--;
			}
			else if(!isVowel(str[i]) && !isVowel(str[j]))
			{
				i++;
				j--;
			}
			else
			{
				char temp = str[i];
				str[i] = str[j];
				str[j] = temp;
				i++;
				j--;
			}
		}
        return new String(str);
    }
	
	public static String reverseWords(String s)
	{
		StringBuilder res =  new StringBuilder();
		for(int start=s.length()-1; start>=0;start--)
		{
			if(s.charAt(start)==' ')
				continue;
			int end = start;
			while(start>=0 && s.charAt(start)!=' ')
				start--;
			res.append(s.substring(start+1, end+1)).append(" ");
		}
		return res.toString().trim();
	}


	public static String reverseWord(String s)
	{
		String r = " ";
		for(int i=s.length()-1;i>=0;i--)
		{
			r = r + s.substring(i, i+1);
		}
		return r;
	}
	
	public static List<String> reverseString(String s)
	{
		List<String> result = new ArrayList<String>();
		String[] words = s.split(" ");
		
		for(String w : words)
		{
			result.add(reverseWord(w));
		}
		
		return result;
	}
	
	public static String reverseString2(String s)
	{
		StringBuilder result = new StringBuilder();
		String[] words = s.split(" ");
		for(String w : words)
		{
			result.append(reverseWord(w));
		}
		
		return result.toString();
	}
	
	public static String reverseEntireString(String s)
	{
		StringBuilder reverse = new StringBuilder();
		for(int i=s.length()-1; i>=0; i--)
		{
			reverse.append(s.charAt(i));
		}
		return reverse.toString();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Hello World I am Java";
		List<String> reverselist = reverseString(str);
		System.out.println(reverselist.toString());
		String reversed = reverseString2(str);
		System.out.println(reversed);
		String fullreverse = reverseEntireString(str);
		System.out.println(fullreverse);
		String wordsreverse = reverseWords(str);
		System.out.println(wordsreverse);
		String vowelreverse = reverseVowels("leetcode");
		System.out.println(vowelreverse);

	}

}
