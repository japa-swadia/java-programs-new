import java.io.*;
import java.util.*;

// delete duplicate nodes from linkedlist

public class Solution12 {
	
	public void deleteDuplicate(LinkedListNode n)
	{
		HashSet<Integer> set = new HashSet<Integer>();
		LinkedListNode prev = null;
		while(n!=null)
		{
			if(set.contains(n.data))
			{
				prev.next=n.next;
			}
			else
			{
				set.add(n.data);
				prev = n;
			}
			n=n.next;
		}
	}
	
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub

	}

}
