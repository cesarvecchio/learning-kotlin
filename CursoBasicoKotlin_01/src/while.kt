fun main(){
    var temperatura: Int = 0
    var somatorio: Int = 0
    var quantidade: Int = 0

    do{
        println("Digite uma temperatura ou 999 para sair: ")
        temperatura = readLine()!!.toInt()

        if(temperatura != 999){
            somatorio += temperatura

            quantidade ++
        }
    }while(temperatura != 999)

//    while(temperatura != 999){
//        println("Digite uma temperatura ou 999 para sair: ")
//        temperatura = readLine()!!.toInt()
//
//        if(temperatura != 999){
//            somatorio += temperatura
//
//            quantidade ++
//        }
//    }

    println("A média das temperaturas é = ${somatorio / quantidade}")
}