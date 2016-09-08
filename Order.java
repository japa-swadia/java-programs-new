import java.util.*;
import java.io.*;

// 1. to check if a pattern occurs in the same order in a string
// 2. replace bad words with asterisks
// 3. remove stop words from a string
// 4. Pascal's triangle

public class Order {
	
	public static ArrayList<ArrayList<Integer>> getPascalsTriangle(int n)
	{
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		
		if(n <= 0)
			return result;
		ArrayList<Integer> prev = new ArrayList<Integer>();
		prev.add(1);
		result.add(prev);
		
		for(int i = 2; i <= n; i++)
		{
			ArrayList<Integer> cur = new ArrayList<Integer>();
			cur.add(1);
			for(int j = 0; j < prev.size(); j++)
			{
				cur.add(prev.get(j) + prev.get(j + 1));
			}
			cur.add(1);
			
			result.add(cur);
			prev = cur;
			
		}
		
		return result;
	}
	public static String removeStopWords(String s, String[] stopWords)
	{
		ArrayList<String> removed = new ArrayList<String>();
		HashSet<String> stopWordset = new HashSet<String>();
		for(int i=0; i<stopWords.length; i++)
		{
			stopWordset.add(stopWords[i]);
		}
		
		String[] words = s.toLowerCase().split(" ");
		for(int j=0; j<words.length; j++)
		{
			
			if(!stopWordset.contains(words[j]))
			{
				removed.add(words[j]);
			}
		}
		String finalstr = " ";
		for(String str : removed)
		{
			finalstr = finalstr + str + " ";
		}
		return finalstr.trim();
		
	}
	
	public static String filterBadWords(String s)
	{
		ArrayList<String> badWords = new ArrayList<String>();
	    badWords.add("crap");
	    badWords.add("shit");
	    badWords.add("dung");
	    
	    
	    String[] patterns = new String[badWords.size()];
	    for(int j=0; j<badWords.size(); j++)
	    {
	    	String pattern = " ";
	    	int len = badWords.get(j).length();
	    	for(int k=0; k<len; k++)
	    	{
	    		pattern = pattern + "*";
	    		
	    	}
	    	patterns[j] = pattern;
	    }
	    for(int i=0; i<badWords.size(); i++)
	    {
	 	    s = s.replaceAll(badWords.get(i), patterns[i]);
	    }
	    return s;
	}
	
	public static boolean checkPatternOrder(String str, String pattern)
	{
		int j=0;
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i) == pattern.charAt(j))
			{
				j++;
			}
			if(j==pattern.length())
			{
				return true;
			}
		}
		
		return false;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abcnainzzzajijijgallrffderityoqwe";
		String p = "nagarro";
		if(checkPatternOrder(s,p))
		{
			System.out.println("Yes");
		}
		else
		{
			System.out.println("No");
		}
		
		String str = "this is shit but that is crappy and like cowdung";
		String answer = filterBadWords(str);
		System.out.println(answer);
		
		String[] stopWords = {"a", "be", "to", "the", "and", "their"};
		String str2 = "This is a java program to be compiled and then run";
		String removed = removeStopWords(str2, stopWords);
		System.out.println(removed);

	}

}
