import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// balanced parenthesis using stack

public class BalancedParenthesis {
	public static String[] braces(String[] values)
	{
		
		
		for(int i=0;i<values.length;i++)
		{
			Stack<Character> result = new Stack<Character>();
			for(int j=0; j<values[i].length();j++){
				char ch = values[i].charAt(j);
				if(ch == '{' || ch == '[' || ch == '(')
				{
					result.push(ch);
				}
				else if((ch == '}' || ch == ']' || ch == ')') && !result.isEmpty())
				{
					if((ch == '}' && result.peek()=='{') || (ch == ']' && result.peek()=='[') || (ch == ')' && result.peek()=='('))
					{
						result.pop();
					}
				}
				
			}
			if(result.isEmpty())
			{
				values[i] = "YES";
				
				
			}
			else
			{
				values[i] = "NO";
			}
			
			
		}
		return values;
	}
	
	public static boolean isBalanced(String parens)
	{
		Stack<Character> result = new Stack<Character>();
		
		for(int i=0;i<parens.length();i++)
		{
			char ch = parens.charAt(i);
			if(ch == '{' || ch == '[' || ch == '(')
			{
				result.push(ch);
			}
			else if((ch == '}' || ch == ']' || ch == ')') && !result.isEmpty())
			{
				if((ch == '}' && result.peek()=='{') || (ch == ']' && result.peek()=='[') || (ch == ')' && result.peek()=='('))
				{
					result.pop();
				}
			}
		}
		if(result.isEmpty())
		{
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "[({})]";
		if(isBalanced(str))
		{
			System.out.println("YES");
		}
		else
		{
			System.out.println("NO");
		}
		
		String[] parens = {"{([])}", "[(}]", "{[}]", "]{}[", "{[(])}"};
		String[] res = braces(parens);for(int i=0; i<res.length;i++)
		{
			System.out.println(res[i]);
		}
		

	}

}
