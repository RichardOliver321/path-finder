package graph

class Vertex(val x: Int, val y: Int) {
    var isStartPoint: Boolean = false
    var isEndPoint: Boolean = false
    var visited: Boolean = false
    var neighbors:  MutableSet<Vertex> = HashSet()
    var edges: MutableSet<Edge> = HashSet()
    var weight: Int = 0//(Math.random() * 99 + 1).toInt()
}