import java.util.*;
import java.io.*;

//1. Rotate Array
//2. Kth largest element in an array
//3. Top k frequent elements
//4. Array intersection
//5. inorder traversal iterative
//6. Minimum in rotated sorted array

class ValueComparator implements Comparator<Integer> {
    Map<Integer,Integer> map;
    public ValueComparator(Map<Integer, Integer> map) {
        this.map = map;
    }
    public int compare(Integer a, Integer b) {
        if((Integer)map.get(a) >= (Integer)map.get(b)) {
            return -1;
        } else {
            return 1;
        }
    }
}

public class MoreSolutions {
	void inOrder(TreeNode root) {
	    
	    
	    Stack<TreeNode> stack = new Stack<TreeNode>();
	    //stack.push(root);
	    
	    TreeNode current = root;
	   
	    while(current!=null)
	        {
	             stack.push(current);
	             current = current.left;
	    }
	    while(!stack.isEmpty())
	        {
	    	TreeNode n = stack.pop();
	        System.out.println(n.data);
	      
	        
	        if(n.right!=null)
	            {
	              current = n.right;
	              
	            while(current!=null)
	        {
	             stack.push(current);
	             current = current.left;
	    }
	            
	        }
	            
	        
	    }
	}
	  
	            
	        
	        
	 
	
	public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<Integer>();
        
        for(int i:nums1)
        {
        	if(!set.contains(i))
        		set.add(i);
            
        }
        
        List<Integer> alist = new ArrayList<Integer>();
        for(int j:nums2)
        {
            if(set.contains(j))
            {
                alist.add(j);
                set.remove(j);
                
            }
        }
        int len = alist.size();
        int n=0;
        int[] intersection = new int[len];
        for(Integer i:alist)
        {
            intersection[n++] = i.intValue();
            
        }
        
        return intersection;
    }
	
	public static int[] intersection2(int[] nums1, int[] nums2)
	{
		Map<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        
        for(int i:nums1)
        {
        	if(hmap.containsKey(i))
        	{
        		hmap.put(i, hmap.get(i)+1);
        	}
        	else
        		hmap.put(i,1);
            
        }
        
        ArrayList<Integer> alist = new ArrayList<Integer>();
        for(int j : nums2)
        {
        	if(hmap.containsKey(j) && hmap.get(j) >= 1)
        	{
        		hmap.put(j, hmap.get(j) - 1);
        		alist.add(j);
        	}
        }
        int[] result = new int[alist.size()];
        int n=0;
        for(int a: alist)
        {
        	result[n++] = a;
        }
        
        return result;
	}
	public static List<Integer> topKFrequent(int[] nums, int k)
	{
		HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
		for(int i=0;i<nums.length;i++)
		{
			if(hmap.containsKey(nums[i]))
			{
				hmap.put(nums[i], hmap.get(nums[i])+1);
			}
			else
			{
				hmap.put(nums[i], 1);
			}
			
		}
		Map<Integer, Integer> tmap = new TreeMap<Integer, Integer>(new ValueComparator(hmap));
		tmap.putAll(hmap);
		
		int count=0;
		List<Integer> list = new ArrayList<Integer>();
		for(Integer hk:tmap.keySet())
		{
			list.add(hk);
			count++;
			if(count==k)
				break;
		}
		return list;
	
	}
	
	public static int kthLargestElement(int[] a, int k)
	{
		Arrays.sort(a);
		
		int len = a.length;
		if(k>len)
			return -1;
		int kth = a[len-k];
		
		return kth;
	}
	
	public static String rotateArray(char[] a, int k)
	{
		int new_i = 0;
		int n = a.length;
		char[] res = new char[n];
		
		for(int i=0;i<a.length;i++)
		{
			if(i<k)
			{
				res[new_i] = a[n+i-k];
				new_i++;
				
			}
			else
			{
				res[new_i] = a[i-k];
				new_i++;
			}
		}
		return new String(res);
	}
	
	public static int findMin(int[] nums) {
	    if(nums==null || nums.length==0)
	        return -1;
	 
	    int i=0; 
	    int j=nums.length-1;
	 
	    while(i<=j){
	        if(nums[i]<=nums[j])
	        {
	        	System.out.println("Rotation point: "+i);
	        	return nums[i];
	        }
	            
	 
	        int m=(i+j)/2;
	 
	        if(nums[m]>=nums[i]){
	            i=m+1;
	        }else{
	            j=m;
	        }
	    }
	 
	    return -1;
	}
	
	public static int findMin2(int[] nums) {
	    if(nums==null || nums.length==0)
	        return -1;
	    
	    int i=0; 
	    int j=nums.length-1;
	 
	    while(i<=j){
	        
	        while(nums[i] == nums[j] && i!=j)
	        	i++;
	        if(nums[i]<=nums[j])
	        {
	        	//System.out.println("Rotation point: "+i);
	        	return nums[i];
	        }
	            
	 
	        int m=(i+j)/2;
	 
	        if(nums[m]>=nums[i]){
	            i=m+1;
	        }else{
	            j=m;
	        }
	    }
	 
	    return -1;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] ch = {'a','b','c','d','e','f'};
		String result = rotateArray(ch,3);
		System.out.println(result);
		
		int[] n = {4,6,2,3,8,6,7,1};
		
		int klarge = kthLargestElement(n,2);
		System.out.println(klarge);
		
		int[] numbers = {1,1,1,2,2,3,4,5};
		List<Integer> reslist = topKFrequent(numbers,2);
		System.out.println(reslist.toString());
		
		int[] n1 = {1,2,2,2,3,4};
		int[] n2 = {1,2,2};
		int[] result4 = intersection(n1,n2);
		int[] result5 = intersection2(n1,n2);
		for(int i=0;i<result4.length;i++)
		{
			System.out.print(" "+result4[i]);
		}
		System.out.println(" ");
		for(int i=0;i<result5.length;i++)
		{
			System.out.print(" "+result5[i]);
		}
		System.out.println(" ");
		int[] nums = {5,6,7,1,2,3,4};
		int minimum = findMin(nums);
		
		System.out.println(minimum);
		
		int[] nums2 = {3,3,1,3};
		int minimum2 = findMin2(nums2);
		
		System.out.println(minimum2);
		

	}

}
