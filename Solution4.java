import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution4 {

	public static void main(String[] args) {
		 Scanner myScan = new Scanner(System.in);
	     String inputString = myScan.nextLine();
	     char[] chars = inputString.toCharArray();
	     
	     HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	     for(int i=0;i<inputString.length();i++)
	     {
	    	 if(!map.containsKey(chars[i]))
	    	 {
	    		 map.put(chars[i], 0);
	    	 }
	    	 if(map.containsKey(chars[i]))
	    	 {
	    		 map.put(chars[i], map.get(chars[i])+1);
	    	 }
	    			
	     }
	     int oddCount = 0;
	     for(char c : map.keySet())
	     {
	    	 if(map.get(c)%2!=0)
	    	 {
	    		 oddCount++;
	    	 }
	     }
	     if(oddCount>1)
	     {
	    	 System.out.println("NO");
	     }
	     else
	     {
	    	 System.out.println("YES");
	     }
	}

}
