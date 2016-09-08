import java.util.*;

//Stack using 2 queues

public class QueueStack {
	
	LinkedList<Integer> q1 = new LinkedList<Integer>();
	LinkedList<Integer> q2 = new LinkedList<Integer>();
	int top;
	
	public void push(int a)
	{
		q1.add(a);
		top = a;
	}
	
	public int pop()
	{
		while(q1.size() > 1)
		{
			q2.add(q1.remove());
		}
		
		top = q1.remove();
		
		LinkedList<Integer> temp = q1;
		q1 = q2;
		q2 = temp;
		
		return top;
	}
	
	public int peek()
	{
		return top;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
