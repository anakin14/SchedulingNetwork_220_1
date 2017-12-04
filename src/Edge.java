
public class Edge {
	int ConnectingNode;
	int WeightOfEdge;
	
	
	public Edge(int i, int j)
	{
		ConnectingNode = i;
		WeightOfEdge = j;
	}
	public int ConnectingNode()
	{
		return ConnectingNode;
	}
	
	public int Weight()
	{
		return WeightOfEdge;
	}



}
