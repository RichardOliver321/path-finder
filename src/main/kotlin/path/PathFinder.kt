package path

import graph.GraphBuilder
import graph.SearchableGraph
import graph.Vertex
import java.awt.Canvas
import java.awt.Color
import java.awt.Graphics
import java.awt.GraphicsConfiguration
import javax.swing.JFrame

const val SIZE = 30

fun main() {
    val frame = JFrame("Searchable Area")

    val startPoint = Vertex(10, 11)// vertexAtRandomLocation(SIZE-1, SIZE-1)
    startPoint.isStartPoint = true
    val endPoint = Vertex(27,24)// vertexAtRandomLocation(SIZE-1, SIZE-1)
    endPoint.isEndPoint = true

    var graph: SearchableGraph = GraphBuilder().buildRandomGraph(SIZE, SIZE, startPoint, endPoint)

    val pathAlgo: PathFindingAlgo =
//        BreadthFirstSearch()
//        DepthFirstSearch()
//    DijkstraPathFinder()
//        ManhattanAStar()
//        DiagonalAStar()
        EuclideanAStar()
    graph = pathAlgo.findShortestPath(graph)

    val canvas = PathFinder(null, graph)

    canvas.setSize(SIZE * SIZE, SIZE * SIZE)
    frame.add(canvas)
    frame.pack()
    frame.isVisible = true
}

fun vertexAtRandomLocation(maxX: Int, maxY: Int): Vertex {
    return Vertex((Math.random() * (maxX + 1)).toInt(), (Math.random() * (maxY + 1.0)).toInt())
}


class PathFinder(config: GraphicsConfiguration?, private val searchableGraph: SearchableGraph) : Canvas(config) {

    override fun paint(g: Graphics) {

        searchableGraph.graphVertices.forEach { vertex ->
            g.color = decideOnColor(vertex, searchableGraph.shortestPath)

            g.fillRect(
                vertex.x * SIZE,
                (vertex.y * SIZE) - SIZE,
                SIZE,
                SIZE
            )
            g.color = Color.WHITE

            if (vertex.weight < Int.MAX_VALUE)
                g.drawString(vertex.weight.toString(), vertex.x * SIZE, vertex.y * SIZE)
        }
    }

    private fun decideOnColor(vertex: Vertex, shortestPath: MutableSet<Vertex>): Color? {

        if (vertex.weight == Int.MAX_VALUE)
            return Color.BLACK

        if (vertex.isStartPoint)
            return Color.BLUE
        else if (vertex.isEndPoint)
            return Color.RED

        if (shortestPath.contains(vertex))
            return Color.GREEN

        return if (vertex.visited)
            Color.LIGHT_GRAY //(vertex.x* 2, vertex.x* 5, vertex.y* 10)
        else
            Color.BLACK

    }
}