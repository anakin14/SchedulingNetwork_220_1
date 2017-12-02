import java.util.LinkedList;
import java.util.List;

public class Graph {
	
	List<List<Edges>> AdjacencyList;
	
	public Graph()
	{
	AdjacencyList = new LinkedList<List<Edges>>();
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
		for(int x = 0; x < AdjacencyList.size(); x++)
		{
			if(AdjacencyList.get(i).get(x).ConnectingNode() == j)
				return AdjacencyList.get(i).get(x).Weight();
		}
		return -1;
	}
}
