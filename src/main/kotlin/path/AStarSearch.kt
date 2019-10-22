package path

import graph.SearchableGraph
import graph.Vertex
import java.util.*
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.pow
import kotlin.math.sqrt

abstract class AStarSearch : PathFindingAlgo {

    override fun findShortestPath(graph: SearchableGraph): SearchableGraph {
        aStarSearch(graph)
        constructShortestPath(graph)
        return graph
    }

    private fun constructShortestPath(graph: SearchableGraph ) {
        var currentVertex: Vertex = graph.endVertex
        val shortestPath: MutableSet<Vertex> = HashSet()

        while (currentVertex != graph.startingVertex) {
            currentVertex = currentVertex.parent!!
            shortestPath.add(currentVertex)
        }
        graph.shortestPath = shortestPath
    }

    fun aStarSearch(graph: SearchableGraph) {

        val openList: MutableSet<Vertex> = HashSet()
        val closedList: MutableSet<Vertex> = HashSet()

        openList.add(graph.startingVertex)

        graph.startingVertex.weight = 0;


        while (openList.isNotEmpty()) {
            val vertex = openList.first();
            openList.remove(vertex);

            vertex.edges.forEach { edge ->
                val currentVertex = edge.toVertex
                if (currentVertex.isEndPoint) {
                    currentVertex.parent = vertex
                    return
                }
                if (!closedList.contains(currentVertex)) {
                    if (openList.contains(currentVertex)) {
                        if (calculateTotalCost(currentVertex, graph) < currentVertex.weight)
                            currentVertex.totalWeight = calculateTotalCost(currentVertex, graph)
                    } else {
                        currentVertex.parent = vertex
                        openList.add(currentVertex)
                        currentVertex.weight += vertex.weight + edge.distance
                        currentVertex.totalWeight = calculateTotalCost(currentVertex, graph)
                    }
                }
                currentVertex.visited = true
            }

            closedList.add(vertex)
        }

    }

    fun calculateTotalCost(vertex: Vertex, graph: SearchableGraph): Int {
        return vertex.weight + estimateDistanceToGoal(graph.startingVertex, graph.endVertex)
    }

    abstract fun estimateDistanceToGoal(startingVertex: Vertex, endVertex: Vertex): Int
}

class ManhattenAStar : AStarSearch() {
    override fun estimateDistanceToGoal(startingVertex: Vertex, endVertex: Vertex): Int {
        return abs(startingVertex.x - endVertex.x) + abs(startingVertex.y - endVertex.y)
    }
}

class DiagonalAStar : AStarSearch() {
    override fun estimateDistanceToGoal(startingVertex: Vertex, endVertex: Vertex): Int {
        return max(abs(startingVertex.x - endVertex.x), abs(startingVertex.y - endVertex.y))
    }
}

class EuclideanAStar : AStarSearch() {
    override fun estimateDistanceToGoal(startingVertex: Vertex, endVertex: Vertex): Int {
        return sqrt(
            (startingVertex.x - endVertex.x).toDouble().pow(2)
                    + (startingVertex.y - endVertex.y).toDouble().pow(2)
        ).toInt()
    }
}
