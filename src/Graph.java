/**
 * @author Anakin  Kinsey, Ofo Croes, Jonathan Hubbard
 */
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
	
	public void add(int i, int j, int weight)
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
	
	/**
	 * A(v) = M(s,v), earliest we can arrive at v having finished all tasks before it
	 * @return
	 */
	public int EarliestArrival(int v)
	{
		return Maximum(0,v);
	}
	/**
	 * L(v) = A(f) - M(v,f), latest time we can leave v and still finish by A(f)
	 * @return
	 */
	public int LatestTime(int v)
	{
		return EarliestArrival(9) - Maximum(v, 9);
	}
	/**
	 * S(v) = L(v) - A(v), max time all tasks starting at v can be idle without delaying the whole process
	 * @return
	 */
	public int SlackTime(int v)
	{
		return LatestTime(v) - EarliestArrival(v);
	}
	/**
	 * F(u,v) = L(v) - A(u) - W(u,v)
	 * @return
	 */
	public int FloatTime(int u, int v)
	{
		return LatestTime(v) - EarliestArrival(u) - Weight(u,v);
	}
	/**
	 * M(u,v), maximum time starting at u to get to v 
	 * @param v
	 * @return
	 */
	public int Maximum(int u, int v)
	{
		int max = 0;
		int curr = 0;
		for(int x = 0; x < 100; x++)
		{
			if(Exists(u,x) == true && IsPossible(AdjacencyList[u].get(x).ConnectingNode, v) == true)
			{
			
			if(u == v)
				return 0;
			curr = AdjacencyList[u].get(x).Weight() + Maximum(AdjacencyList[u].get(x).ConnectingNode(), v);
			}
			if(curr > max)
				max = curr; 
		}
		return max;
	}
	public boolean IsPossible(int u, int v) {
		for(int x = 0; x < 100; x++)
		{
			if(u == v)
				return true;
			if(Exists(u, x))
			{
				if(IsPossible(AdjacencyList[u].get(x).ConnectingNode, v) == true)
					return true;
			}
		}
		return false;
	}

	public int Weight(int u, int v)
	{
		for(int x = 0; x < AdjacencyList.length; x++)
		{
			if( AdjacencyList[u].get(x).ConnectingNode() == v)
				return AdjacencyList[u].get(x).Weight();
		}
		return 0;
	}
	
	public boolean Exists(int u, int x)
	{
		try
		{
			Edge e = AdjacencyList[u].get(x);
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			return false;
		}
		catch(IndexOutOfBoundsException e)
		{
			return false;
		}
		
		return true;
	}
}
