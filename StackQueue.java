import java.util.*;
import java.io.*;

//Queue using two stacks


public class StackQueue {

	Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();
    int front;
    public void push(int x) {
    	s1.push(x);
	
        
    }

    // Removes the element from in front of queue.
    public int pop() {
    	 while(!s1.isEmpty())
         {
             s2.push(s1.pop());
         }
    	 int front = s2.pop();
    	 return front;
        
    }

    // Get the front element.
    public int peek() {
        return front;
    }

    // Return whether the queue is empty.
    public boolean isEmpty() {
        return s1.isEmpty() && s2.isEmpty();
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackQueue sq = new StackQueue();
		sq.push(1);
		sq.push(2);
		sq.push(3);
		
		int popped = sq.pop();
		//int p = sq.peek();
		System.out.println(popped);
		

	}

}
