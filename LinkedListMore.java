import java.util.*;
import java.io.*;

/*More on linked list:
 * 1. Reverse - Recursive
 * 2. Reverse - Iterative
 * 3. Rotate by k
 * 4. Odd-even
 * 5. Palindrome
 * 6. Swap nodes
 * 7. delete kth from last element
 * 8. get middle element
 * */

public class LinkedListMore {
	
	public static ListNode getMiddle(ListNode head)
	{
		if(head == null || head.next == null)
			return head;
		
		ListNode fast = head;
		ListNode slow = head;
		
		while(fast != null && fast.next != null)
		{
			fast = fast.next.next;
			slow = slow.next;
		}
		
		return slow;
		
	}
	
	public static ListNode deleteKthfromLast(ListNode head, int k)
	{
		if(head == null || head.next == null)
			return head;
		
		ListNode fast = head;
		ListNode slow = head;
		
		for(int i = 0; i < k; i++)
		{
			fast = fast.next;
		}
		
		//if 1st element
		if(fast == null)
		{
			head = head.next;
			return head;
		}
		
		while(fast.next != null)
		{
			fast = fast.next;
			slow = slow.next;
		}
		
		slow.next = slow.next.next;
		
		return head;
	}
	
	public ListNode swapNodes(ListNode head)
	
	{
		if(head == null || head.next == null)
			return head;
		
		//dummy head
		ListNode h = new ListNode(0);
		h.next = head;
		ListNode p1 = head;
		ListNode p2 = head.next;
		
		ListNode prev = h;
		while(p1 != null && p2 != null)
		{
			prev.next = p2;
			ListNode temp = p2.next;
			
			p2.next = p1;
			prev = p1;
			
			p1.next = temp;
			p1 = p1.next;
			
			if(temp != null)
				p2 = temp.next;
		}
		return h.next;
	}
	
	public ListNode oddEvenList(ListNode head) {
        ListNode prev = head;
        ListNode cur = head.next;
        ListNode connect = head.next;
        
        while(prev!=null && cur!=null)
        {
            if(cur.next==null)
            {
                break;
            }
            prev.next = cur.next;
            prev = prev.next;
            
            cur.next = prev.next;
            cur = cur.next;
        }
        prev.next = connect;
        return head;
        
    }
	
	public static boolean isPalindrome2(ListNode head)
	{
		if(head == null || head.next == null)
			return true;
		
		ListNode slow = head;
		ListNode fast = head;
		
		while(fast.next!=null && fast.next.next!=null)
		{
			fast = fast.next.next;
			slow = slow.next;
		}
		
		ListNode head2 = slow.next;
		slow.next = null;
		
		ListNode l1 = head2;
		ListNode l2 = l1.next;
		
		while(l1!=null && l2!=null)
		{
			ListNode temp = l2.next;
			l2.next = l1;
			l1 = l2;
			l2 = temp;
		}
		head2.next = null;
		
		//compare two sub-lists now
		ListNode list1 = (l2==null?l1:l2);
		ListNode list2 = head;
		
		while(list1 != null)
		{
			if(list1.val != list2.val)
			{
				return false;
			}
			
			list1 = list1.next;
			list2 = list2.next;
		}
		return true;
	}
	
	public static boolean isPalindrome(Node head)
	{
		Stack<Node> stack = new Stack<Node>();
		if(head==null || head.next==null)
		{
			return true;
		}
		Node current = head;
		while(current!=null)
		{
			stack.push(current);
			current = current.next;
		}
		while(current!=null)
		{
			current = current.next;
			if(current == stack.pop())
				return true;
		}
		return false;
	}
	//recursive
	public Node reverse1(Node head)
	{
		if(head==null || head.next == null)
		{
			return head;
		}
		
		Node newHead = reverse1(head.next); //reverse all but head
		head.next.next = head; //make original second point to first
		head.next = null; //set original head to null as it is the last node in the linked list
		
		return newHead;
		
	}
	
	//iterative
	public Node reverse2(Node head)
	{
		if(head==null || head.next == null)
		{
			return head;
		}
		
		Node prev = null;
		Node current = head;
		Node nextNode = null;
		
		while(current!=null)
		{
			nextNode = current.next;
			current.next = prev;
			prev = current;
			current = nextNode;
		}
		head = prev;
		
		return head;
	}

}
