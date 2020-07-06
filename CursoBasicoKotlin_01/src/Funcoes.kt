fun main(){
    println(max1(5, 10))
}

// Corpo de bloco
fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}

// Corpo de expressâo
fun  max1(a: Int, b: Int): Int = if (a > b) a else b