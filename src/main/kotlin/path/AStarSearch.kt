package path

import graph.SearchableGraph
import graph.Vertex
import java.util.*
import kotlin.collections.ArrayList

class AStarSearch :  PathFindingAlgo  {

    override fun findShortestPath(graph: SearchableGraph): SearchableGraph {
        aStarSearch(graph)
        return graph
    }

    fun aStarSearch(graph: SearchableGraph) {

        val openList: MutableSet<Vertex> = HashSet()
        val closedList: MutableSet<Vertex> = HashSet()

        openList.add(graph.startingVertex)



    }

    fun calculateCost() {

    }
}