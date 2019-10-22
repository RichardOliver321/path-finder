package graph

class Vertex(val x: Int, val y: Int) {
    var isStartPoint: Boolean = false
    var isEndPoint: Boolean = false
    var visited: Boolean = false
    var parent: Vertex? = null
    var neighbors:  MutableSet<Vertex> = HashSet()
    var edges: MutableSet<Edge> = HashSet()
    var weight: Int = 5//(Math.random() * 10 + 1).toInt()

    //TODO Should make a Vertex Type per algo?
    var totalWeight: Int = Int.MAX_VALUE
}