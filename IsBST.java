import java.io.*;
import java.util.*;


public class IsBST {
	
	public boolean checkIfBST(TreeNode n)
	{
		return checkIfBST(n,null,null);
		
	}
	
	public boolean checkIfBST(TreeNode n, Integer min, Integer max)
	{
		if(n==null)
			return true;
		
		if(min!=null && n.data<=min || max!=null && n.data>max)
			return false;
		
		if(!checkIfBST(n.left,min,n.data) || !checkIfBST(n.right,n.data,max))
			return false;
		
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
