fun main() {
    val a = Stack<Int>()
    a.push(1).run { println(get()) }
    a.push(2).run { println(get()) }
    a.size().also { println("size: $it") }
    a.pop().also { println(it) }
    a.pop().also { println(it) }
    a.pop().also { println(it) }
    a.pop().also { println(it) }
    a.size().also { println(it) }
    a.get().also { println(it) }
    a.push(10).run { println(get()) }
    a.push(23).run { println(get()) }
    a.clear().run { println(get()) }
}

data class Node<T>(var data: T, var next: Node<T>? = null)

class Stack<T> {
    private var head: Node<T>? = null
    private var size = 0

    fun push(data: T): Stack<T> {
        head = Node(data, head).also { ++size }
        return this
    }

    fun pop(): T? {
        val res = head?.data?.also { size-- }
        head = head?.next
        return res
    }

    fun get(): T? {
        val ret = pop()
        ret?.let { push(ret) }
        return ret
    }

    fun size() = size

    fun clear(): Stack<T> {
        head = null
        size = 0
        return this
    }
}
