import java.io.*;
import java.util.*;


public class Solution2 {
	
	
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] s = new String[n];
        int count = 0;
        HashMap<Character,Integer> h = new HashMap<Character, Integer>();
        for(int i=0;i<n;i++)
        {
        	s[i] = sc.next();
        	char[] c = s[i].toCharArray();

        	TreeSet<Character> set = new TreeSet<Character>();
        	for(char ch : c)
        	{
        		set.add(ch);
        	}
        	for(char ch:set){
        		if(!h.containsKey(ch))
        		{
        			h.put(ch, 1);
        		}else
        			h.put(ch, h.get(ch)+1);
        		
        	}
        }
        for(Character chr : h.keySet())
        {
        	if(h.get(chr)==n)
        	{
        		count++;
        	}
        }
        System.out.println(count+"");
        
      sc.close();
        
    }
}
