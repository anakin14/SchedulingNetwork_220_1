import java.util.LinkedList;
import java.util.List;

public class Graph {
	int size;
	LinkedList<Edge> AdjacencyList[];
	
	public Graph(int size)
	{
		this.size = size;
		AdjacencyList = new LinkedList[size];
	for(int i = 0; i < 9; i++)
	{
		AdjacencyList[i] = new LinkedList<Edge>();
	}
	}
	
	public void add(int i, int j, double weight)
	{
		Edge temp = new Edge(j, weight);
		AdjacencyList[i].add(temp);
		
		
	}
	
	public boolean hasEdge(int i, int j)
	{
		boolean exit = false;
		for(int x = 0; !exit; x ++)
		{
			try
			{
				if(AdjacencyList[i].get(x).ConnectingNode() == j)
				{
					return true;
				}
			}
			catch(IndexOutOfBoundsException e)
			{
				return false;
			}
		}
		return false;
	}
	
	
	public double print(int i, int j)
	{
		for(int x = 0; x < size; x++)
		{
			if(AdjacencyList[i].get(x).ConnectingNode == j)
				return Weight(i,j);
		}
		return 0;
	}
	
	
	public int EarliestArrival()
	{
		int i = 0;
		return i;
	}
	 
	public int LatestTime()
	{
		int i = 0;
		return i;
	}
	
	public int SlackTime()
	{
		int i = 0;
		return i;
	}
	
	public int FloatTime()
	{
		int i = 0;
		return i;
	}
	
	public double Weight(int i, int j)
	{
		for(int x = 0; x < AdjacencyList.length; x++)
		{
			if( AdjacencyList[i].get(x).ConnectingNode() == j)
				return AdjacencyList[i].get(x).Weight();
		}
		return 0;
	}
}
