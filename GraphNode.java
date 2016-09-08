import java.util.*;


public class GraphNode {
	int label;
	ArrayList<GraphNode> neighbors;
	
	GraphNode(int x)
	{
		label = x;
		neighbors = new ArrayList<GraphNode>();
	}
	
	public int getNodeValue()
	{
		return label;
	}

}
