package path

import graph.SearchableGraph
import graph.Vertex
import java.util.*

class BreadthFirstSearch : PathFindingAlgo {

    override fun findShortestPath(graph: SearchableGraph): SearchableGraph {
        bfs(graph.startingVertex)
        return graph
    }

    fun bfs(currentVertex: Vertex) {
        val discovered: Queue<Vertex> = ArrayDeque()
        discovered.add(currentVertex)

        while (discovered.isNotEmpty()) {
            val vertex = discovered.remove()
            vertex.visited = true
            if (vertex.isEndPoint)
                return
            vertex.edges.forEach { edge ->
                if (!edge.toVertex.visited) {
                    discovered.offer(edge.toVertex)
                }
            }
        }

    }

}