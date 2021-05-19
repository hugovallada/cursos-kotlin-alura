import curso_heranca_polimorfismo_e_interfaces.*

fun main(){

    val fran = Gerente("Fran", "222.222.222-22", salario = 4000.0, 1234)
    println(fran.bonificacao)

    if (fran.autenticar(1234)) {
        println("Autenticou")
    } else {
        print("Falhou")
    }

    val si = SistemaInterno()
    si.entra(fran, 1234)

    val cliente = Cliente("Hugo", "333.333.333-33", 1234)
    si.entra(cliente, senha = 1234)


}

private fun criaContas() {
    val contaCorrente = ContaCorrente("Hugo", 2000)
    contaCorrente.depositar(2000.0)

    val contaPoupanca = ContaPoupanca("Julio", numero = 2000)
    contaPoupanca.depositar(2000.0)

    contaCorrente.sacar(100.0)
    contaPoupanca.sacar(100.0)

    println("Saldo conta corrente: ${contaCorrente.saldo}")
    println("Saldo conta poupança: ${contaPoupanca.saldo}")
}

private fun executaFuncionarios() {
    val alex = Analista(nome = "Alex", cpf = "111.111.111-11", salario = 2000.0)
    println("Nome ${alex.nome}")
    println("Sua bonificação será de ${alex.bonificacao}")

    val fran = Gerente("Fran", "222.222.222-22", salario = 4000.0, 1234)
    println(fran.bonificacao)

    if (fran.autenticar(1234)) {
        println("Autenticou")
    } else {
        print("Falhou")
    }

    val hugo = Diretor(nome = "Hugo", cpf = "333.333.333-33", salario = 6000.0, plr = 200.0, senha = 1234)
    println(hugo.bonificacao)

    val calculadora = CalculadoraBonificacao()
    calculadora.registra(hugo)
    calculadora.registra(alex)
    calculadora.registra(fran)

    val maria = Analista("Maria", "444.444.444-44", 3000.0)

    calculadora.registra(maria)
    println(calculadora.total)
}


//fun main(){
//    println("Hello World") // pula linha
//
//    //var titular // pode ser modificada (mutável)
//    val titular = "Hugo" // não pode ser modificada (imutável)
//    print(titular)
//    println()
//
//    println("Titular $titular")
//
//    val numeroConta = 1000
//    var saldo = 0.0
//
//    println("Número da conta: $numeroConta")
//
//    println("Saldo: $saldo")
//
//    saldo = 100.00
//
//    saldo += 200
//    println("Novo saldo: $saldo")
//
//
//
//    fun testaCondicao(saldo: Double){
//        // If no kotlin
//        if (saldo > 0.0){
//            println("Conta é positiva")
//        } else if(saldo == 0.0){
//            println("Conta neutra")
//        } else {
//            println("Conta negativa")
//        }
//
//        // When = if mais legível
//        // pode colocar {} ou deixar em 1 linha se o retorno da condição tiver só uma linha
//        when {
//            saldo > 0.0 -> {
//                println("Conta é positiva")
//            }
//            saldo == 0.0 -> println("Conta neutra")
//            else -> println("Conta negativa")
//        }
//
//    }
//
//    fun testaRepesticao(saldo: Double){
//        // for
//        for (i in 3..6){ // vai de 3 a 6 (3,4,5,6)
//            println(i)
//        }
//
//        // for decrescente
//        for(i in 10 downTo 1){
//            println(i)
//        }
//
//        // step
//        for(i in 2..10 step 2){
//            println(i)
//        }
//
//        //break.. continue funciona da msm forma
//        for(i in 1..10){
//            if(i == 4) break
//        }
//
//        var valor = 100
//
//        while(valor > 0){
//            valor -= 100
//        }
//
//        // loop infinito
//        while(true){
//            println("Loop infinito")
//        }
//    }
//
//    //testaRepesticao(saldo)
//
//
//
//
//
//
//
//}