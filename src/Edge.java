
public class Edge {
	int ConnectingNode;
	double WeightOfEdge;
	
	
	public Edge(int i, double j)
	{
		ConnectingNode = i;
		WeightOfEdge = j;
	}
	public int ConnectingNode()
	{
		return ConnectingNode;
	}
	
	public double Weight()
	{
		return WeightOfEdge;
	}



}
