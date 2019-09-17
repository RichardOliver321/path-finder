package graph

public class Vertex(val x: Int, val y: Int) {
    var isStartPoint: Boolean = false
    var isEndPoint: Boolean = false
    var visited: Boolean = false
    var neighbors:  MutableSet<Vertex> = HashSet()
    val edges: MutableSet<Edge> = HashSet()
    var weight: Int = (Math.random() * 200 + 1).toInt()
}