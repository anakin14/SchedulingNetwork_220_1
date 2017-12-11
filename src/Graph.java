/**
 * @author Anakin  Kinsey, Ofo Croes, Jonathan Hubbard
 */
import java.util.LinkedList;
import java.util.List;

public class Graph {
	int size;
	LinkedList<Edge> AdjacencyList[];
	/**
	 * Graph method: used to initialize the scheduling network
	 * @param size cannot be null
	 */
	public Graph(int size)
	{
		this.size = size;
		AdjacencyList = new LinkedList[size];
	for(int i = 0; i < 9; i++)
	{
		AdjacencyList[i] = new LinkedList<Edge>();
	}
	}
	/**
	 * add method: this method is used to add a initial vertex,
	 * 	final vetex and weight of an edge into a graph
	 * @param i >= 0
	 * @param j >= 0
	 * @param weight >= 0
	 */
	public void add(int i, int j, int weight)
	{
		Edge temp = new Edge(j, weight);
		AdjacencyList[i].add(temp);
		
		
	}
	/**
	 * hasEdge method: used to check whether two 
	 * 	vertices have an edge connecting them
	 * @param i >= 0
	 * @param j >= 0
	 * @return true if there is an edge between two vertices,
	 *  		false if there isn't an edge between two vertices
	 */
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
	
	/**
	 * print method: used to give the weight between two edges in
	 * 				 the scheduling nework
	 * @param i >= 0
	 * @param j >= 0
	 * @return weight if there is an edge between two given vertices
	 */
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
	 * EarliestArrival method: used to calculate earliest arrival time.
	 * A(v) = M(s,v), earliest we can arrive at v having finished all tasks before it
	 * @return earliest arrival time
	 */
	public int EarliestArrival(int v)
	{
		return Maximum(0,v);
	}
	/**
	 * LatestTime method: used to calculate latest arrival time.
	 * L(v) = A(f) - M(v,f), latest time we can leave v and still finish by A(f)
	 * @return latest arrival time
	 */
	public int LatestTime(int v)
	{
		return EarliestArrival(9) - Maximum(v, 9);
	}
	/**
	 * SlackTime method: used to calculate slack time.
	 * S(v) = L(v) - A(v), max time all tasks starting at v can be idle without delaying the whole process
	 * @return slack time.
	 */
	public int SlackTime(int v)
	{
		return LatestTime(v) - EarliestArrival(v);
	}
	/**
	 * FloatTime method: used to calculate the float time.
	 * F(u,v) = L(v) - A(u) - W(u,v)
	 * @return float time.
	 */
	public int FloatTime(int u, int v)
	{
		return LatestTime(v) - EarliestArrival(u) - Weight(u,v);
	}
	/**
	 * Maximum method: used to calculate the maximum time
	 * M(u,v), maximum time starting at u to get to v 
	 * @param u >= 0
	 * @param v >= 0
	 * @return maximum time
	 */
	public int Maximum(int u, int v)
	{
		int max = 0;
		int curr = 0;
		for(int x = 0; x < 100; x++)
		{
			if(u == v || u > v)
				return max;
			if(u == v - 1)
				return Weight(u, v);
			if(Exists(u,x) == true)
			{
			curr = AdjacencyList[u].get(x).Weight() + Maximum(AdjacencyList[u].get(x).ConnectingNode(), v);
			}
			if(curr > max)
				max = curr; 
		}
		return max;
	}
	/**
	 * Weight class: used to give the weight of an edge
	 * @param u >= 0
	 * @param v >= 0
	 * @return Weight of an edge
	 */
	public int Weight(int u, int v)
	{
		for(int x = 0; x < AdjacencyList.length; x++)
		{
			if( AdjacencyList[u].get(x).ConnectingNode() == v)
				return AdjacencyList[u].get(x).Weight();
		}
		return 0;
	}
	/**
	 * Exists method: used to check whether an edge exists
	 * @param u >= 0
	 * @param x >= 0
	 * @return true if there is an edge, false if there isn't an edge
	 */
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
