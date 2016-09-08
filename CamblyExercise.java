import java.io.*;
import java.util.*;
import java.util.Map.Entry;


public class CamblyExercise {
	public static void countWords(String s)
	{
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		
		s = s.replaceAll("[.,?]", "");
		String[] words = s.toLowerCase().split(" ");
		
		for(int i = 0; i < words.length; i++)
		{
			if(hmap.containsKey(words[i]))
			{
				hmap.put(words[i], hmap.get(words[i])+1);
			}
			else
			{
				hmap.put(words[i], 1);
			}
		}
		
		
		/*for(String str : hmap.keySet())
		{
			System.out.println(str+" "+hmap.get(str));
		}*/
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String paragraph = "This is a test. That is not a test. Test";
		countWords(paragraph);
		

	}

}
