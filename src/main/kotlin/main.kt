fun main(){
    println("Hello World") // pula linha

    //var titular // pode ser modificada (mutável)
    val titular = "Hugo" // não pode ser modificada (imutável)
    print(titular)
    println()

    println("Titular $titular")

    val numeroConta = 1000
    var saldo = 0.0

    println("Número da conta: $numeroConta")

    println("Saldo: $saldo")

    saldo = 100.00

    saldo += 200
    println("Novo saldo: $saldo")



    fun testaCondicao(saldo: Double){
        // If no kotlin
        if (saldo > 0.0){
            println("Conta é positiva")
        } else if(saldo == 0.0){
            println("Conta neutra")
        } else {
            println("Conta negativa")
        }

        // When = if mais legível
        // pode colocar {} ou deixar em 1 linha se o retorno da condição tiver só uma linha
        when {
            saldo > 0.0 -> {
                println("Conta é positiva")
            }
            saldo == 0.0 -> println("Conta neutra")
            else -> println("Conta negativa")
        }

    }

    fun testaRepesticao(saldo: Double){
        // for
        for (i in 3..6){ // vai de 3 a 6 (3,4,5,6)
            println(i)
        }

        // for decrescente
        for(i in 10 downTo 1){
            println(i)
        }

        // step
        for(i in 2..10 step 2){
            println(i)
        }

        //break.. continue funciona da msm forma
        for(i in 1..10){
            if(i == 4) break
        }

        var valor = 100

        while(valor > 0){
            valor -= 100
        }

        // loop infinito
        while(true){
            println("Loop infinito")
        }
    }

    //testaRepesticao(saldo)







}