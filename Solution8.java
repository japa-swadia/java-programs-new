import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//balanced parenthesis using stack

public class Solution8 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0;i<n;i++)
		{
			String s = sc.next();
			Stack<Character> parens = new Stack<Character>();
			for(int l=0;l<s.length();l++)
			{
				char ch = s.charAt(l);
				if(ch=='{' || ch=='(' || ch=='[')
				{
					parens.push(ch);
				}
				
				else if(ch=='}'|| ch==')' || ch==']' && (!parens.isEmpty()))
				{
					if (((char) parens.peek() == '(' && ch == ')')
							|| ((char) parens.peek() == '{' && ch == '}')
							|| ((char) parens.peek() == '[' && ch == ']'))
					{
						parens.pop();
					}
					else
					{
						//return;
						//System.out.println("NO");
					}
					
					
				}
				else {
					if ((ch == ']' || ch == '}' || ch == ')')) {
						System.out.println("NO");
					}
					
			}
		}
			if (parens.isEmpty())
				System.out.println("\n"+"YES");
			else
				System.out.println("NO");

		// TODO Auto-generated method stub

	}
	}

}
