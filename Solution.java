import java.io.*;
import java.util.*;
import java.text.*;

public class Solution {
	
	public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] s = new String[n];
        String[] r = new String[n];
        for(int i=0;i<n;i++)
        {
        	s[i] = sc.next();
        	
        	r[i] = "";
        	for(int j=s[i].length()-1;j>=0;j--)
        	{
        		r[i] = r[i]+s[i].substring(j, j+1);
        	}
        }
        int flag = 0;
        outer:
        for(int i=0;i<n;i++)
        {
        	for(int j=1;j<s[i].length()&&j<r[i].length();j++)
        	{
        		if(Math.abs((s[i].charAt(j)-'0')-(s[i].charAt(j-1)-'0')) == Math.abs((r[i].charAt(j)-'0')-(r[i].charAt(j-1)-'0')))
        		{
        			
        		}
        		else
        		{
        			System.out.println("Not Funny");
        			continue outer;
        		}
        		
        	}
        	System.out.println("Funny");
        }
        
               
        sc.close();
        
	}
	
}

   