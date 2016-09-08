//reverse words in String

public class Solution11 {
	
	public static String reverseWords(String s)
	{
		StringBuilder res =  new StringBuilder();
		for(int start=s.length()-1; start>=0;start--)
		{
			if(s.charAt(start)==' ')
				continue;
			int end = start;
			while(start>=0 && s.charAt(start)!=' ')
				start--;
			res.append(s.substring(start+1, end+1)).append(" ");
		}
		return res.toString().trim();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverseWords("hello thy world thee"));
		
	}

}
