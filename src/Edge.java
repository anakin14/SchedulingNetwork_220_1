/**
 * Edge
 * @author Anakin Kinsey, Ofo Croes, Johnathan Hubbard
 * An "edge" object that represents an edge between 2 vertices
 * 
 * Note: Initial vertex is not stored here as this edge object is stored in the link
 * of the LinkedList that corresponds with the initial vertex
 */
public class Edge {
	int ConnectingNode;
	int WeightOfEdge;
	
	/**
	 * Edge method: used to initialize an edge.
	 * @param i >= 0;
	 * @param j >= 0;
	 */
	public Edge(int i, int j)
	{
		ConnectingNode = i;
		WeightOfEdge = j;
	}
	/**
	 * ConnectingNode method: returns the vertex that is connected at the end of an edge
	 * @return the ending vertex
	 */
	public int ConnectingNode()
	{
		return ConnectingNode;
	}
	/**
	 * Weight method: used to return the weight of an edge
	 * @return weight of the edge
	 */
	public int Weight()
	{
		return WeightOfEdge;
	}



}
