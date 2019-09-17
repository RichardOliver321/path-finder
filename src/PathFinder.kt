import graph.SearchableGraph
import graph.GraphBuilder
import graph.Vertex
import path.DijkstraPathFinder
import path.PathFindingAlgo
import java.awt.Canvas
import java.awt.Color
import java.awt.Graphics
import java.awt.GraphicsConfiguration
import javax.swing.JFrame


fun main() {
    val frame = JFrame("Searchable Area")

    val startPoint = Vertex(3, 4)
    startPoint.isStartPoint = true
    val endPoint = Vertex(7, 8)
    endPoint.isEndPoint = true

    var graph: SearchableGraph = GraphBuilder().buildRandomGraph(20, 20, startPoint, endPoint)

    val pathAlgo: PathFindingAlgo = DijkstraPathFinder()

    graph = pathAlgo.findShortestPath(graph)

    val canvas = PathFinder(null, graph)

    canvas.setSize(20 * 20, 20 * 20)
    frame.add(canvas)
    frame.pack()
    frame.isVisible = true
}


class PathFinder(config: GraphicsConfiguration?, private val searchableGraph: SearchableGraph) : Canvas(config) {

    override fun paint(g: Graphics) {

        searchableGraph.graphVertices.forEach { vertex ->
            g.color = decideOnColor(vertex, searchableGraph.shortestPath)

            g.fillRect(
                vertex.x * 20,
                (vertex.y * 20)  - 20,
                20,
                20
            )
            g.color = Color.WHITE

            if(vertex.weight < Int.MAX_VALUE)
            g.drawString(vertex.weight.toString(), vertex.x * 20, vertex.y * 20)
        }
    }

    private fun decideOnColor(vertex: Vertex, shortestPath: MutableSet<Vertex>): Color? {

        if(vertex.weight == Int.MAX_VALUE)
            return Color.MAGENTA

        if (vertex.isStartPoint)
            return Color.BLUE
        else if (vertex.isEndPoint)
            return Color.RED

        if (shortestPath.contains(vertex))
            return Color.GREEN

        return if (vertex.visited)
            Color.BLACK
        else
            Color.MAGENTA

    }
}