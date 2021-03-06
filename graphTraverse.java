// simply visit every vertices
void graphTraverse(Graph G) {
	int v;
	for (v=0; v<G.n(); v++)
		G.setMark(v, UNVISITED); // Initialize
	for (v=0; v<G.n(); v++)
		if (G.getMark(v) == UNVISITED)
			doTraverse(G, v);
}
