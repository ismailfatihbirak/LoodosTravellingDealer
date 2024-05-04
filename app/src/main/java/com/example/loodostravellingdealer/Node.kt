package com.example.loodostravellingdealer

import kotlin.math.pow
import kotlin.math.sqrt


class Node(val x: Int, val y: Int) {
    var following: Node? = null

    fun appendToEnd(x: Int, y: Int) {
        val end = Node(x, y)
        var n: Node? = this
        while (n!!.following != null) {
            n = n.following
        }
        n.following = end
    }

    fun printNodes() {
        var current: Node? = this
        print("Nodes: ")
        while (current != null) {
            print("(${current.x}, ${current.y}) ")
            current = current.following
        }
        println()
    }

    fun length(): Int {
        var count = 0
        var current: Node? = this
        while (current != null) {
            count++
            current = current.following
        }
        return count
    }

    fun sumOfNodes(): Int {
        var sum = 0.0
        var current: Node? = this
        while (current != null) {
            val temp = ((current.x - 3) * (current.x - 3)) + ((current.y - 7) * (current.y - 7))
            val sqrt = sqrt(temp.toDouble())*2
            sum += sqrt
            current = current.following
        }
        return sum.toInt()
    }

    fun deleteNode(head: Node?, x: Int, y: Int): Node? {
        var current = head
        var prev: Node? = null

        if (current != null && current.x == x && current.y == y) {
            return current.following
        }

        while (current != null && (current.x != x || current.y != y)) {
            prev = current
            current = current.following
        }

        if (current == null) return head

        prev?.following = current.following

        return head
    }
}

fun main() {
    val head = Node(1, 10)
    head.appendToEnd(1, 4)
    head.appendToEnd(2, 1)
    head.appendToEnd(5, 2)
    head.appendToEnd(6, 5)
    head.appendToEnd(8, 4)
    head.appendToEnd(9, 2)
    head.appendToEnd(8, 9)

    head.printNodes()
    println("Length: ${head.length()}")
    println("Sum of Nodes: ${head.sumOfNodes()}")

    head.deleteNode(head, 8, 4)
    head.printNodes()
}
