package curso_um_orientacao_a_objeto

import curso_heranca_polimorfismo_e_interfaces.ContaCorrente
import curso_heranca_polimorfismo_e_interfaces.ContaPoupanca

fun main(){

    val conta = ContaCorrente(titular = "Hugo", numero = 1000)
    conta.depositar(20.0)
    println(conta.saldo)
    conta.sacar(10.0)
    println(conta.saldo)

    val conta2 = ContaPoupanca(titular = "Fran", numero = 1001)

    conta.transferencia(10.0, conta2)
    println("Conta1: ${conta.saldo}  - Conta2: ${conta2.saldo}")


}

//fun criaContas(){
//    val conta = Conta()
//    conta.titular = "Hugo"
//    conta.numero = 1000
//    conta.saldo = 2000.00
//    println(conta.titular)
//
//    val contaFran = Conta()
//    contaFran.titular = "Fran"
//    conta.numero = 1100
//    conta.saldo = 2200.00
//    println(contaFran.titular)
//}