
public class LinkedListNode {
	
	int data;
	LinkedListNode next;
	
	public static double getPower(double a, double b){ 

		if(b==0) return 1; 
		//if b is negative 
		if(b<0){ 
		return 1/a*(getPower(a,b+1)); 
		} 

		return a*getPower(a,b-1); 

		}
	
	public boolean checkOrder(String source, String pattern) {
		int iSource = 0;
		int iPattern = 0;
		
		
		//we scan source and increase index of next searched char in the pattern;
		for (iSource = 0; iSource<source.length(); iSource++) {
			if (source.charAt(iSource) == pattern.charAt(iPattern)) {
				iPattern++;
			}
			if (iPattern == pattern.length()) {
				//all pattern discovered, success
				return true;
			}
		}
	
		//nope
		return false;
		}
}


