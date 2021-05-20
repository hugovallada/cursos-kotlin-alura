package curso_excecoes_e_null_safety

import curso_excecoes_e_null_safety.exception.SaldoInsuficienteException
import curso_excecoes_e_null_safety.modelo.Cliente
import curso_excecoes_e_null_safety.modelo.ContaCorrente
import curso_excecoes_e_null_safety.modelo.ContaPoupanca
import curso_excecoes_e_null_safety.modelo.Endereco
import java.lang.ClassCastException
import java.lang.Exception

fun main(){
    elvisOperator()
}

fun funcao1(){
    println("Inicio função 1")
    funcao2()
    println("Fim função 1")
}

fun funcao2(){
    println("Início função 2")
    for (i in 1..5){
        println(i)
    }
    causarException()
    println("Fim função 2")
}

fun causarException(){
    val endereco = Any()

    try{
        endereco as Endereco
    } catch (exception : ClassCastException) {
        println("Não foi possível realizar a conversão : ${exception.message}")
        exception.printStackTrace()
    }
}

fun tryComoExpressao(entrada: String){
    val valor: Int? = try{ entrada.toInt() } catch (e: NumberFormatException) { null }

//    if(valor != null) println("O valor é $valor") else println("O valor passado foi nulo")

    val novoValor = when{
        valor != null -> valor
        else -> 2
    }

}

fun lancarException(){
    val cliente = Cliente(nome = "Hugo", "333", 1234)
    val conta = ContaPoupanca(cliente, 2222)

    conta.depositar(1000.0)

    try{
        conta.transferencia(200.0, conta)
    } catch (exception: SaldoInsuficienteException) {
        println("Seu saldo é insuficiente: ${exception.message}")
    } catch (exception: Exception) {
        println("Algo aconteceu: ${exception.message}")
    }

}

fun safeCalls(){
    var endereco: Endereco? = Endereco("rua", 638,"centro","rp", "sp","4", "na")
    endereco?.logradouro = "Carpa"
    var logradouroNovo: String?  = endereco?.logradouro
    println(logradouroNovo)

    endereco?.let { endereco -> println(endereco.logradouro) }
}

fun elvisOperator(){
    var complemento: String? = "casa"

    val tamanhoComplemento : Int = complemento?.length ?: 0

    println(tamanhoComplemento)

    complemento = null

    val novoTamanho: Int = complemento?.length ?: throw IllegalArgumentException("Ilegal")
}

fun safeCast(valor : Any){

    val valor: Int? = valor as? Int

}



