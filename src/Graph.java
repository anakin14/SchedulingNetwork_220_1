import java.util.LinkedList;
import java.util.List;

public class Graph {
	
	List<List<Edge>> AdjacencyList[];
	
	public Graph()
	{
	AdjacencyList = new LinkedList[9];
	for(int i = 0; i < 10; i++)
	{
		AdjacencyList[i] = new LinkedList<>();
	}
	}
	
	public void add(int i, int j, double weight)
	{
		Edge temp = new Edge(j, weight);
		
		
	}
	
	
	
	public int EarliestArrival()
	{
		
	}
	 
	public int LatestTime()
	{
		
	}
	
	public int SlackTime()
	{
		
	}
	
	public int FloatTime()
	{
		
	}
	
	public double Weight(int i, int j)
	{
		for(int x = 0; x < AdjacencyList.length; x++)
		{
			if( AdjacencyList[i].get(x).ConnectingNode() == j)
				return AdjacencyList[i].get(x).Weight();
		}
		return -1;
	}
}
