package path

import graph.Edge
import graph.SearchableGraph
import graph.Vertex
import java.util.*

abstract class AStarSearch : PathFindingAlgo {

    override fun findShortestPath(graph: SearchableGraph): SearchableGraph {
        aStarSearch(graph)
        return graph
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
                setParent(edge, vertex)
                calculateCost(edge)
                estimateDistanceToGoal()
            }
        }

    }

    abstract fun estimateDistanceToGoal()

    private fun setParent(edge: Edge, parent: Vertex) {
        edge.toVertex.parent = parent
    }

    private fun calculateCost(edge: Edge) {
        val vertex = edge.toVertex
        vertex.weight += vertex.parent!!.weight + edge.distance
    }
}

class ManhattenAStar : AStarSearch() {
    override fun estimateDistanceToGoal() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

class Diagonal : AStarSearch() {
    override fun estimateDistanceToGoal() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

class Euclidian : AStarSearch() {
    override fun estimateDistanceToGoal() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
