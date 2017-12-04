/**
 * Edge
 * @author Anakin  Kinsey
 * An "edge" object that represents an edge between 2 vertices
 * 
 * Note: Initial vertex is not stored here as this edge object is stored in the link
 * of the LinkedList that corresponds with the initial vertex
 */
public class Edge {
	int ConnectingNode;
	int WeightOfEdge;
	
	
	public Edge(int i, int j)
	{
		ConnectingNode = i;
		WeightOfEdge = j;
	}
	/**
	 * 
	 * @return the ending vertex
	 */
	public int ConnectingNode()
	{
		return ConnectingNode;
	}
	/**
	 * 
	 * @return weight of the edge
	 */
	public int Weight()
	{
		return WeightOfEdge;
	}



}
