package graph

import kotlin.collections.HashSet

class GraphBuilder {

    var width: Int = 0
    var length: Int = 0

    fun buildRandomGraph(length: Int, width: Int, startPoint: Vertex, endPoint: Vertex): SearchableGraph {
        this.width = width
        this.length = length

        val initialGraph: Array<Array<Vertex>> =
            Array(length) { x -> Array(width) { y -> createVertex(x, y, startPoint, endPoint) } }
        val finalHashSet: MutableSet<Vertex> = HashSet()

        for (len in 0 until length) {
            for (wid in 0 until width) {
                val currentVertex = initialGraph[len][wid]
                setupNeighbourAndEdges(currentVertex, initialGraph, len, wid)
                finalHashSet.add(currentVertex)
            }
        }

        return SearchableGraph(finalHashSet, startPoint, endPoint)
    }

    private fun createVertex(x: Int, y: Int, startPoint: Vertex, endPoint: Vertex): Vertex {
        if (x == startPoint.x && y == startPoint.y)
            return startPoint
        if (x == endPoint.x && y == endPoint.y)
            return endPoint
        return Vertex(x, y)
    }

    /**
     * Give each Vertex an edge to each one of its neighbors.
     * It is an undirected graph therefore edges go both ways
     */
    private fun setupNeighbourAndEdges(
        currentVertex: Vertex,
        initialGraph: Array<Array<Vertex>>,
        len: Int,
        wid: Int
    ) {
        for (x in -1..1) {
            for (y in -1..1) {
                if (doesVertexExist(len + x, wid + y) && currentVertex != initialGraph[len + x][wid + y]) {
                    currentVertex.neighbors.add(initialGraph[len + x][wid + y])
                    currentVertex.edges.add(Edge(initialGraph[len + x][wid + y],10))// (Math.random() * 10 + 1).toInt()))
                }
            }
        }
        currentVertex.edges = currentVertex.edges.sortedBy { edge -> edge.toVertex.x }.toMutableSet()
    }

    //Make sure we are inside the limits of our array
    private fun doesVertexExist(x: Int, y: Int): Boolean {
        return !(x >= length || x < 0 || y >= width || y < 0)
    }

}