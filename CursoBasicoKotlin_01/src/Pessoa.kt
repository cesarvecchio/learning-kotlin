class Pessoa(
    val nome: String,
    val idade: Int
)

fun main(){
    val pessoa1: Pessoa = Pessoa("César", 19)
    val pessoa2: Pessoa = Pessoa("Cleiton", 20)

    println("Pessoa 1: ${pessoa1.nome}")
    println("Pessoa 2: ${pessoa2.nome}")

}