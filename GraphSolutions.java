import java.util.*;

//1. check if a route exists between two nodes in a directed graph
//2. shortest path
//3. all paths


public class GraphSolutions {
	
	//solution using BFS
	public static boolean hasRoute(ArrayList<GraphNode> graph, GraphNode start, GraphNode end)
	{
		Queue<GraphNode> q = new LinkedList<GraphNode>();
		Set<GraphNode> visited = new HashSet<GraphNode>();
		
		if(start == end)
			return true;
		
		q.offer(start);
		
		while(!q.isEmpty())
		{
			GraphNode n = q.poll();
			visited.add(n);
			
			if(n == end)
				return true;
			if(n.neighbors.size() > 0)
			{
				for(GraphNode u : n.neighbors)
				{
					if(visited.contains(u))
					{
						continue;
					}
					q.offer(u);
				}
			}
		}
		return false;
	}
	
	//solution using DFS
	public static boolean hasRoute2(ArrayList<GraphNode> graph, GraphNode start, GraphNode end)
	{
		Set<GraphNode> visited = new HashSet<GraphNode>();
		
		if(start == end)
			return true;
		
		visited.add(start);
		GraphNode n = start;
		if(n.neighbors.size()>0)
		{
			
			
			for(GraphNode u : n.neighbors)
			{
				if(visited.contains(u))
				{
					continue;
				}
				if(hasRoute2(graph, u, end))
					return true;
			}
		}
		return false;
	}
	
	public static void printRoute(ArrayList<GraphNode> graph, GraphNode start, GraphNode end)
	{
		Set<GraphNode> visited = new HashSet<GraphNode>();
		//ArrayList<ArrayList<GraphNode>> paths = new ArrayList<ArrayList<GraphNode>>();
		
		
		if(start == end)
		{
			System.out.print(end.label);
		}
			
			
		ArrayList<GraphNode> p = new ArrayList<GraphNode>();
		visited.add(start);
		
		GraphNode n = start;
		p.add(n);
		if(n.neighbors.size()>0)
		{
			
			
			for(GraphNode u : n.neighbors)
			{
				
				if(u == end)
				{
					p.add(end);
					for(int i=0; i<p.size(); i++)
					{
						System.out.print(" "+p.get(i).label);
					}
					
				}
				if(visited.contains(u))
				{	
					continue;
				}
				
				if(hasRoute2(graph, u, end) == true)
				{
					//path.add(u);
					//p = new ArrayList<GraphNode>();
					p.add(u);
					visited.remove(u);
					//paths.add(p);
					
				}
				//p.add(end);
				
				
			}
			
		}
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<GraphNode> graph = new ArrayList<GraphNode>();
		
		GraphNode g1 = new GraphNode(1);
		GraphNode g2 = new GraphNode(2);
		GraphNode g3 = new GraphNode(3);
		GraphNode g4 = new GraphNode(4);
		GraphNode g5 = new GraphNode(5);
		
		for(int i=0; i<graph.size()-1; i++)
		{
			System.out.print(" "+graph.get(i).getNodeValue());
		}
		g1.neighbors.add(g2);
		g1.neighbors.add(g3);
		g2.neighbors.add(g3);
		g2.neighbors.add(g5);
		g3.neighbors.add(g4);
		
		boolean routeBFS = hasRoute(graph, g1, g4);
		
		if(routeBFS)
			System.out.println("Yes");
		else
			System.out.println("No");
		
		boolean routeDFS = hasRoute2(graph, g1, g4);
		
		if(routeDFS)
		{
			System.out.println("Yes");
			printRoute(graph, g1, g4);
		}
			
		else
			System.out.println("No");
		
		

	}

}
