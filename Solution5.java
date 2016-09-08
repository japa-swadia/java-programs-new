import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Solution5 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<t;i++)
            {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int[] ic = new int[n]; 
            for(int j=0;j<n;j++)
                {
                ic[j] = sc.nextInt();
                                                 	 
            }
            for(int j=0;j<n;j++)
            {                        
            if(map.containsKey(m-ic[j]))
            {
            	System.out.println((map.get(m-ic[j])+1) + " " + (j+1));
            	break;
            }
            else
            {
            	 map.put(ic[j], j);
      	  
            }
            }
                                  
        }
        sc.close();

	}

}
