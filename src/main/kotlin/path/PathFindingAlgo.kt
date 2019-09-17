package path

import graph.SearchableGraph

interface PathFindingAlgo {
     fun findShortestPath(graph: SearchableGraph) : SearchableGraph
}