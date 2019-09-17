package path

import graph.Edge
import graph.SearchableGraph
import graph.Vertex

class DijkstraPathFinder : PathFindingAlgo {

    override fun findShortestPath(graph: SearchableGraph): SearchableGraph {
        val unsettledVertexSet: MutableSet<Vertex> = HashSet()
        val settledVertexSet: MutableSet<Vertex> = HashSet()

        val shortestPath: MutableSet<Vertex> = HashSet()

        setWeightsToInfinite(graph)

        graph.startingVertex.weight = 0

        unsettledVertexSet.add(graph.startingVertex)

        var currentVertex = getShortestDistantVertex(unsettledVertexSet)
        while (unsettledVertexSet.isNotEmpty() && currentVertex != graph.endVertex) {
            currentVertex = getShortestDistantVertex(unsettledVertexSet)

            unsettledVertexSet.remove(currentVertex)

            currentVertex?.edges?.forEach { neighbor ->
                if (!settledVertexSet.contains(neighbor.toVertex)) {
                    calculateMinDistance(currentVertex, neighbor)
                    unsettledVertexSet.add(neighbor.toVertex)
                }
            }

            currentVertex?.visited = true
            settledVertexSet.add(currentVertex!!)
        }

        graph.graphVertices = settledVertexSet
        graph.shortestPath = constructShortestPath(graph.startingVertex, graph.endVertex)
        return graph
    }

    private fun constructShortestPath(startingVertex: Vertex, endVertex: Vertex ): MutableSet<Vertex> {
        var currentVertex: Vertex = startingVertex
        val shortestPath: MutableSet<Vertex> = HashSet()
        while(!shortestPath.contains(endVertex)) {
            currentVertex = currentVertex.edges.filter { edge -> !shortestPath.contains(edge.toVertex) }.sortedBy { edge -> edge.toVertex.weight }.first().toVertex
            shortestPath.add(currentVertex)
        }
       return shortestPath

    }

    private fun calculateMinDistance(currentVertex: Vertex?, neighbor: Edge) {
        if ((currentVertex?.weight?.plus(neighbor.distance))!! < neighbor.toVertex.weight)
            neighbor.toVertex.weight = currentVertex.weight.plus(neighbor.distance)

    }

    private fun getShortestDistantVertex(unsettledVertexSet: MutableSet<Vertex>): Vertex? {
        var closestVertex: Vertex? = null
        var lowestDistance = Int.MAX_VALUE
        unsettledVertexSet.stream().forEach { vertex: Vertex -> if(vertex.weight <= lowestDistance ) {
            closestVertex = vertex
            lowestDistance = vertex.weight
        }  }
        return closestVertex
    }

    private fun setWeightsToInfinite(graph: SearchableGraph) {
        graph.graphVertices.forEach { vertex ->
            vertex.weight = Int.MAX_VALUE
        } //.edges.forEach { edge -> edge.distance = Int.MAX_VALUE } }
    }
}