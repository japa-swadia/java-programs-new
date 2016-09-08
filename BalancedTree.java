import java.util.*;
import java.io.*;

//is the tree balanced: height difference not more than 1

public class BalancedTree {

	public static int checkHeight(TreeNode root)
	{
		if(root==null)
			return 0;
		//check if left tree is balanced
		int leftHeight = checkHeight(root.left);
		if(leftHeight==-1)
			return -1;	//not balanced
		int rightHeight = checkHeight(root.right);
		if(rightHeight==-1)
			return -1;	//not balanced
		
		//check if current node is balanced.
		int heightDiff = leftHeight-rightHeight;
		if(Math.abs(heightDiff)>1)
			return -1;	//not balanced
		else
		{
			//return height
			return Math.max(leftHeight, rightHeight)+1;
		}
	}
	
	public static boolean isBalanced(TreeNode root)
	{
		if(checkHeight(root)==-1)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
