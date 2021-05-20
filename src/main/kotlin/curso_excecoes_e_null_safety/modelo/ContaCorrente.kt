package curso_excecoes_e_null_safety.modelo

import curso_excecoes_e_null_safety.exception.SaldoInsuficienteException


class ContaCorrente(titular: Cliente, numero: Int) : Conta(titular, numero), Transferivel {
    override fun depositar(valor: Double) {
        when{
            valor <= 0 -> println("Não pode fazer isso")
            else -> saldo += valor
        }
    }

    override fun sacar(valor: Double) {
        when {
            valor <= 0 -> println("Não pode fazer isso")
            valor in 0.0..saldo -> saldo -= valor * 0.080
            else -> println("Não pode fazer isso")
        }
    }

    override fun transferencia(valor: Double, contaASerTransferida: Conta) {
        when{
            valor <= 0 -> throw Exception("Você não pode transferir um valor negativo ou zero. O valor deve ser positivo")
            valor in 0.0..saldo -> {
                contaASerTransferida.depositar(valor)
                saldo -= valor
            }
            else -> throw SaldoInsuficienteException("Você não tem saldo suficiente! Seu saldo: ${this.saldo}")
        }
    }

}