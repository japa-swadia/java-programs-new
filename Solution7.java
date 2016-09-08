import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution7 {
	 public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 int n = sc.nextInt();
		 Stack<Integer> stack = new Stack<Integer>();
		 Stack<Integer> maxStack = new Stack<Integer>();
		 for(int i=0;i<n;i++)
		 {
			 int choice = sc.nextInt();
			 if(choice == 1)
			 {
				 int value = sc.nextInt();
				 addNewElement(stack, maxStack, value);
				 
			 }
			 if(choice == 2)
			 {
				 popElement(stack, maxStack);
				 
			 }
			 if(choice == 3)
			 {
				 printMaxVal(maxStack);
				 
			 }
		 }
	        
	    }
	 
	 private static void addNewElement(Stack<Integer> dataStack, Stack<Integer> maxStack, int val)
	 {
		 dataStack.push(val);
		 if(maxStack.size()<=0 || val > maxStack.peek())
		 {
			 maxStack.push(val);
		 }
	 }
	 
	 private static void popElement(Stack<Integer> dataStack, Stack<Integer> maxStack)
	 {
		 int val = dataStack.pop();
		 if(val == maxStack.peek())
		 {
			 maxStack.pop();
		 }
	 }
	 
	 private static void printMaxVal(Stack<Integer> maxStack)
	 {
		 int maxVal = maxStack.peek();
		 System.out.println(maxVal);
	 }

}
