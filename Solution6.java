import java.io.*;
import java.util.*;

public class Solution6 {

	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int[] s1 = new int[n1];
        HashMap<Integer,Integer> h1 = new HashMap<Integer, Integer>();
        for(int i=0;i<n1;i++)
        {
        	s1[i] = sc.nextInt();
            
        	for(int x:s1){
        		if(!h1.containsKey(x))
        		{
        			h1.put(x, 1);
        		}else
        			h1.put(x, h1.get(x)+1);
        		
        	}
        }
        int n2 = sc.nextInt();
        int[] s2 = new int[n2];
        HashMap<Integer,Integer> h2 = new HashMap<Integer, Integer>();
        for(int i=0;i<n2;i++)
        {
        	s2[i] = sc.nextInt();
            
        	for(int y:s2){
        		if(!h2.containsKey(y))
        		{
        			h2.put(y, 1);
        		}else
        			h2.put(y, h2.get(y)+1);
        		
        	}
        }
        
        
               
        
        for(int x:h1.keySet())
            {
        	
            if(h2.containsKey(x) && h2.get(x)!=h1.get(x))
                {
                System.out.print(x+" ");
                
            }
            
        }

	}

}
