import java.util.*;
import java.io.*;

//1. find median in sorted arrays
//2. find two numbers with given sum
//3. length of last word in string
//4. minimum in rotated sorted array
//5. rotate linked list by k

public class LeetCodeMock {
	
	public ListNode rotateRight(ListNode head, int k) {
        if(k==0)
            return head;
        if(head==null)
            return head;
            
        ListNode p = head;
        int len = 0;
        while(p!=null)
        {
            len++;
            p=p.next;
        }
        
        int r=0;
        if(k%len == 0)
            return head;
        else
        {
            r = len - (k%len) - 1;
        }
        
        ListNode newHead = head;
        p = head;
        
        for(int i=0;i<r;i++)
        {
            p = p.next;
        }
        
        newHead = p.next;
        ListNode q = newHead;
        p.next = null;
        
        while(q.next!=null)
        {
            q=q.next;
        }
        q.next = head;
        
        return newHead;
        
    }
	public static int findMin(int[] nums)
	{
		Arrays.sort(nums);
		int a = nums[0];
		
		return a;
	}
	public static int findMin2(int[] nums)
	{
		Set<Integer> t = new TreeSet<Integer>();
		for(int i=0; i<nums.length; i++)
		{
			t.add(nums[i]);
		}
		
		
		ArrayList<Integer> list = new ArrayList<Integer>(t);
		//list.addAll(t);
		System.out.println(list.toString());
		int a = list.get(0);
		return a;
	}

	public static int lengthOfLastWord(String s) {
		//int len=0;
		String lastWord;
		String[] words = s.split(" ");
		if(words.length==0)
			return 0;
		else
		{
			lastWord = words[words.length-1];
		}
		
		
		
        
		return lastWord.length();
        
	}
	public static ArrayList<Integer> twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        
        for(int i=0;i<nums.length;i++)
        {
        	hm.put(nums[i], i);  
            
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        //int[] res = new int[2];
        for(int i=0;i<nums.length;i++)
        {
            if(hm.containsKey(target-nums[i]))
            	{
            		list.add(hm.get(target-nums[i]));
            		
            	}
        }
        return list;
    }
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<nums1.length;i++)
        {
        	list.add(nums1[i]);
        	
        }
        for(int j=0;j<nums2.length;j++)
        {
        	list.add(nums2[j]);
        	
        }
        Collections.sort(list);
        
        double median = 0;
        int size = list.size();
        //System.out.println(size);
        int mid = size/2;
        if(size%2==0)
        {
            median = (double)(list.get(mid-1)+list.get(mid))/2;
        }
        else if(size%2!=0)
        {
            median = (double)list.get(mid);
        }
        
        return median;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] n1 = {1,3};
		int[] n2 = {2};
		
		double ans = findMedianSortedArrays(n1,n2);
		System.out.println(ans);
		
		int[] numbers = {1,2,4,8};
		//int target = 6;
		ArrayList<Integer> result = twoSum(numbers,6);
		
		System.out.println(result.toString());
		
		int lastsize = lengthOfLastWord("Japa Swadia");
		System.out.println(lastsize);
		
		int[] rotate = {4,5,6,7,9,1,2,3};
		int x = findMin(rotate);
		int y = findMin2(rotate);
		System.out.println(x);
		System.out.println(y);
	
	}

}
