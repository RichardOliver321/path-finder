package graph

class SearchableGraph(var graphVertices: MutableSet<Vertex>, val startingVertex: Vertex, val endVertex: Vertex) {
    var shortestPath: MutableSet<Vertex> = HashSet()
}