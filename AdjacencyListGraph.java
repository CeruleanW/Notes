// Adjacency list graph implementation
class Graphl implements Graph {
	private GraphList[] vertex; // The vertex list
	private int numEdge; // Number of edges
	public int[] Mark; // The mark array
	
	public Graphl() {}
	public Graphl(int n) // Constructor
	{ Init(n); }
	
	public void Init(int n) {
		Mark = new int[n];
		vertex = new GraphList[n];
		for (int i=0; i<n; i++)
			vertex[i] = new GraphList();
		numEdge = 0;
	}
	
	public int n() { return Mark.length; } // # of vertices
	public int e() { return numEdge; } // # of edges
	
	public int first(int v) { // Get v’s first neighbor
		vertex[v].moveToStart();
		Edge it = vertex[v].getValue();
		if (it == null) return Mark.length;
		else return it.vertex();
	}
	
	public boolean isEdge(int v, int w) { // Is (i,j) an edge?
		Edge it = vertex[v].getValue();
		if ((it != null) && (it.vertex() == w)) return true;
		for (vertex[v].moveToStart(); vertex[v].currPos() < vertex[v].length(); vertex[v].next()) // Check whole list
			if (vertex[v].getValue().vertex() == w) return true;
		return false;
	}
	public int next(int v, int w) { // Get next neighbor
	Edge it = null;
	if (isEdge(v, w)) {
		vertex[v].next();
		it = vertex[v].getValue();
	}
	if (it != null)
		return it.vertex();
	else return Mark.length;
	}
	
	// Store edge weight
	public void setEdge(int i, int j, int weight) {
		assert weight != 0 : "May not set weight to 0";
		Edge currEdge = new Edge(j, weight);
		if (isEdge(i, j)) { // Edge already exists in graph
			vertex[i].remove();
			vertex[i].insert(currEdge);
		}
		else { // Keep neighbors sorted by vertex index
			numEdge++;
			for (vertex[i].moveToStart(); vertex[i].currPos() < vertex[i].length(); vertex[i].next())
				if (vertex[i].getValue().vertex() > j) break;
			vertex[i].insert(currEdge);
		}
	}
	
	public void delEdge(int i, int j) // Delete edge
	{ if (isEdge(i, j)) { vertex[i].remove(); numEdge--; } }
	
	public int weight(int i, int j) { // Return weight of edge
		if (i == j) return 0;
		if (isEdge(i, j)) return vertex[i].getValue().weight();
		else return Integer.MAX VALUE;
	}
	
	// Set and get marks
	public void setMark(int v, int val) { Mark[v] = val; }
	public int getMark(int v) { return Mark[v]; }
} 
