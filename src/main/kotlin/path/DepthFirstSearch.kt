package path

import graph.SearchableGraph
import graph.Vertex
import java.util.*

class DepthFirstSearch  : PathFindingAlgo {

    override fun findShortestPath(graph: SearchableGraph): SearchableGraph {
        dfs(graph.startingVertex)
        return graph
    }

    fun dfs(currentVertex: Vertex) {
        val discovered: Queue<Vertex> = ArrayDeque()
        discovered.add(currentVertex)

        while (discovered.isNotEmpty()) {

            val vertex = discovered.remove()
            vertex.edges.forEach { edge ->
                if (!edge.toVertex.visited) {
                    discovered.offer(edge.toVertex)
                }
            }

            vertex.visited = true
            if (vertex.isEndPoint)
                return
        }

    }

}