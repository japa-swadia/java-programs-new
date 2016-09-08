import java.util.*;

//1. FizzBuzz
//2. Count primes
//3. Tic Tac Toe game
//4. stack using 2 queues
//5. add two integers without using + operator
//6. single number leetcode
//7. power of two

public class ProblemsContinued {
	
	
	
	public static int hasWonTicTacToe(char[][] board)
	{
		for(int i = 0; i < board.length; i++)
		{
			//check rows
			if(board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][0] == board[i][2])
			{
				return 1;
			}
			//check columns
			if(board[0][i] != ' ' && board[0][i] == board[1][i] && board[0][i] == board[2][i])
			{
				return 1;
			}
			//check diagonal
			if(board[0][0] != ' ' && board[0][0] == board[1][1] && board[0][0] == board[2][2])
			{
				return 1;
			}
			//check reverse diagonal
			if(board[0][2] != ' ' && board[0][2] == board[1][1] && board[0][2] == board[2][0])
			{
				return 1;
			}
		}
		
		return 0;
	}
	
	public static boolean isPowerOfTwo(int n)
	{
		if(n <= 0)
			return false;
		/*int count = 0;
        
        while (n > 0) {
            count += (n & 1);
            n = n >> 1;
        }*/
		if((n&n-1) == 0)
			return true;
		//return count;
		return false;
	}
	
	public int getSingleNumber(int[] nums)
	{
		int x = 0;
		for(int a : nums)
		{
			x = x ^ a;
		}
		return x;
	}
	
	public static int addNums(int a, int b)
	{
		if(a == 0)
			return b;
		else if(b == 0)
			return a;
		
		while(b != 0)
		{
			//carry - AND
			int carry = (a & b);
			
			//sum = XOR
			a = a ^ b;
			
			//shift carry by 1 bit to forward it 
			b = carry << 1;
			
		}
		
		return a;
	}
	public static void fizzBuzz(int n)
	{
		for(int i = 1; i <= n; i++)
		{
			if(i % 3 == 0 && i % 5 == 0)
			{
				System.out.println("FizzBuzz");
			}
			else
			{
				if(i % 3 == 0)
					System.out.println("Fizz");
				else if(i % 5 == 0)
					System.out.println("Buzz");
				else
					System.out.println(" "+i);
			}
		}
	}
	public static void fizzBuzz2(int n)
	{
		for(int i = 1; i <= n; i++)
		{
			if(i % 3 == 0 && i % 5 == 0)
			{
				System.out.println("FizzBuzz");
			}
			else if(i % 3 == 0)
			{
				System.out.println("Fizz");
			}
			else if(i % 5 == 0)
			{
				System.out.println("Buzz");
			}
			else
			{
				System.out.println(" "+i);
			}
				
		}
	}
	
	public static int[] findPrimes(int n)
	{
		boolean[] prime = new boolean[n+1];
		for(int num = 2; num <= n; num++)
		{
			prime[num] = true;
		}
		
		for(int i = 2; i*i <= n; i++)
		{
			if(prime[i])
			{
				for(int j = i; j*i <= n; j++)
				{
					prime[j*i] = false;
				}
			}
		}
		int count = 0;
		
		for(int i = 2; i <= n; i++)
		{
			if(prime[i])
				count++;		
		}
		System.out.println("" +count+" primes");
		
		int[] result = new int[count];
		int k = 0;
		for(int i = 2; i <= n; i++)
		{
			if(prime[i])
			{
				result[k++] = i;
			}
		}
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fizzBuzz(16);
		System.out.println("------------------------");
		fizzBuzz2(16);
		
		int[] primes = findPrimes(30);
		for(int n : primes)
		{
			System.out.print(" "+n);
		}
		

	}

}
