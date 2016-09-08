import java.util.*;
import java.io.*;

//1. convert string to integer (without parseInt)
//2. remove duplicates from sorted linked list (return only unique nodes)
//3, ctci - merge 2 sorted arrays, sufficient buffer at the end of first array
//4. string replace
//5. ctci - search from rotated (unknown times) sorted array
//6. replace target substring

public class MoreAndMoreSolutions {
	
	public static String replaceSubstr(String s, String target, String replacement)
	{
		
		String result = "";
	
		result = s.replaceAll(target, replacement);
		
		return result;
		
		
	}
	
	public static String replaceAB(String s)
	{
		char[] c = s.toCharArray();
		for(int i=0; i<c.length-2;)
		{
			if(c[i] == 'A' && c[i+1] == 'B')
			{
				c[i] = 'C';
				c[i+1] =' ';
				i+=2;
			}
			else
			{
				i++;
			}
		}
		s = String.valueOf(c);
		s = s.replaceAll(" ", "");
		return new String(s);
	}
	
	public static String replaceWords(String s, String oldWord, String newWord)
	{
		String[] words = s.split(" ");
		StringBuilder result = new StringBuilder();
		for(int i=0; i<words.length; i++)
		{
			if(words[i].equalsIgnoreCase(oldWord))
			{
				result.append(newWord+" ");
			}
			else
			{
				result.append(words[i]+" ");
			}
		}
		//s = s.replaceAll("[a-zA-Z]*oldWord", newWord);
		
		return result.toString();
		
	}
	
	public int search(int[] a, int left, int right, int x)
	{
		if(right < left)
			return -1;
		
		int mid = (left + right)/2;
		if(x == a[mid])
			return mid;
		
		if(a[left] < a[mid])
		{
			if(x >= a[left] && x <= a[mid])
			{
				return search(a, left, mid - 1, x);
			}
			else
			{
				return search(a, mid+1, right, x);
			}
		}
		else if(a[mid] < a[right])
		{
			if(x >= a[mid] && x <= a[right])
			{
				return search(a, mid+1, right, x);
			}
			else
			{
				return search(a, left, mid-1, x);
			}
		}
		else if(a[left] == a[mid])
		{
			if(a[mid] != a[right])
			{
				return search(a, mid+1, right, x);
			}
			else
			{
				int result = search(a, left, mid-1, x);
				if(result == -1)
					return search(a, mid+1, right, x);
				else
					return result;
			}
		}
		return -1;
	}
	public void merge(int[] a, int[] b, int lenA, int lenB)
	{
		int indexA = lenA - 1;
		int indexB = lenB - 1;
		int indexMerged = lenA + lenB - 1;
		
		while(indexB >= 0)
		{
			if(indexA >= 0 && a[indexA] > b[indexB])
			{
				a[indexMerged] = a[indexA];
				indexA--;
			}
			else
			{
				a[indexMerged] = b[indexB];
				indexB--;
			}
			indexMerged--;
		}
		
	}
	
	public static ListNode removeDups(ListNode head)
	{
		ListNode temp = new ListNode(0);
		temp.next = head;
		
		ListNode cur = temp;
		while(cur.next!=null && cur.next.next!=null)
		{
			if(cur.next.val == cur.next.next.val)
			{
				int data = cur.next.val;
				while(cur.next!=null && cur.next.val==data)
				{
					cur.next = cur.next.next;
				}
				
			}
			else
			{
				cur = cur.next;
			}
		}
		return temp.next;
	}
	
	
	public static int stringToInt(String str)
	{
		int num = 0;
		int multiplier = 1;
		for(int i=str.length()-1; i>=0; i--)
		{
			char ch = str.charAt(i);
			
			
			num = num + (ch - '0')*multiplier;
			multiplier = multiplier*10;
					
		}
		
		return num;
	}
	
	public static int atoi(String str)
	{
		if(str == null || str.length() < 1)
			return 0;
		
		str.trim();
		
		char sign = '+';
		int i = 0;
		if(str.charAt(i) == '-')
		{
			sign= '-';
			i++;
		}
		else if(str.charAt(i) == '+')
			i++;
		
		double num = 0;
		
		while(str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9')
		{
			num = (num*10) + (str.charAt(i) - '0');
			i++;
		}
		
		if(sign == '-')
			return (int) (0 - num);
		
		if (num > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
	 
		if (num < Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
			
		return (int) num;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String number = "1234"; 
		int n = stringToInt(number);
		System.out.println(n);
		
		String str = "Avery is very happy and very sad at once, which is very peculiar";
		String replaced = replaceWords(str, "very", "extremely");
		System.out.println(replaced);
		
		String str2 = "helloABworld";
		String rep = replaceSubstr(str2, "AB", "C");
		
		System.out.println(rep);
		String abc = replaceAB(str2);
		System.out.println(abc);

	}

}
