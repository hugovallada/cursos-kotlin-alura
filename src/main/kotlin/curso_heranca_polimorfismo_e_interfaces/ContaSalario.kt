package curso_heranca_polimorfismo_e_interfaces

import curso_um_orientacao_a_objeto.Conta

class ContaSalario(titular:String, numero: Int) : Conta(titular = titular, numero = numero) {
    override fun depositar(valor: Double) {
        TODO("Not yet implemented")
    }

    override fun sacar(valor: Double) {
        TODO("Not yet implemented")
    }



}