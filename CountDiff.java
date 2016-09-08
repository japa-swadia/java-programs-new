import java.io.*;
import java.util.*;

//1. Pair of numbers in an array, given difference between them.
//2. Pair of numbers in an array, given sum between them.
//3. Word pattern
//4. Number of trailing zeroes in a factorial
//5. find square root without using library function

public class CountDiff {
	
	public static int findSqrt(int n)
	{
		int sqrt = 0;
		for(int i = 0; i <= n/2; i++)
		{
			if(i*i == n)
			{
				sqrt = i;
				break;
			}
				
			
			else if(i*i > n)
			{
				sqrt = i - 1;
				break;
			}
				
		}
		return sqrt;
	}
	
	public static int countFactZeros(int num)
	{
		int count = 0;
		if(num < 0)
			return -1;
		
		for(int i = 5; num/i > 0; i *= 5)
		{
			count += num/i;
		}
		
		return count;
	}
	
	public static boolean wordPattern(String pattern, String str)
	{
		HashMap<Character, String> matcher = new HashMap<Character, String>();
		String[] words = str.split(" ");
		
		if(words.length != pattern.length())
			return false;
		
		for(int i = 0; i < pattern.length(); i++)
		{
			if(matcher.containsKey(pattern.charAt(i)))
			{
				if(!matcher.get(pattern.charAt(i)).equals(words[i]) )
					return false;
			}
			else if(matcher.containsValue(words[i]))
			{
				return false;
			}
			matcher.put(pattern.charAt(i), words[i]);
			
		}
		return true;
	}
	
	public static int numberOfPairs(int[] a, long k)
	{
		Arrays.sort(a);
		int left = 0;
		int right = a.length-1;
		int count = 0;
		while(left < right)
		{
			if(a[left] + a[right] == k)
			{
				count++;
				left++;
				right--;
			}
				
			else if(a[left] + a[right] < k)
				left++;
			else if(a[left] + a[right] > k)
				right--;
			
	}
		return count;
	}
	
	public static int arrayPairDiff(int[] arr, int k)
	{
		HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
		int count = 0;
		
		for(int i=0;i<arr.length;i++)
		{
			if(hmap.containsKey(arr[i]))
			{
				hmap.put(arr[i], ++count);
			}
			else
			{
				hmap.put(arr[i], 1);
			}
			
			
		}
		count = 0;
		for(int j=0;j<arr.length;j++)
		{
			if(hmap.containsKey(arr[j]+k))
			{
				count+= hmap.get(arr[j]+k);
			}
		}
	
			
			
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2,5,6,9,7,8};
		int num = arrayPairDiff(a, 4);
		System.out.println(num);
		
		int num2 = numberOfPairs(a, 7);
		System.out.println(num2);
		
		String s = "dog cat cat dog";
		boolean match = wordPattern("abba", s);
		if(match)
		{
			System.out.println("YES");
		}
		else
		{
			System.out.println("NO");
		}
		
		int zero = countFactZeros(1808548329);
		System.out.println(zero);
		
		int sqrt = findSqrt(9);
		System.out.println(sqrt);

	}

}
