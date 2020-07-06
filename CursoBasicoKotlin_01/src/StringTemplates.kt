fun main(){
    val nome: String = "César"
    //String template com variavel
    println("Hello $nome!")

    //String tempalte com expressão
    println("A soma é: ${soma(10, 20)}")
}

fun soma(a: Int, b: Int): Int {
    return a + b
}