package curso_heranca_polimorfismo_e_interfaces

import curso_um_orientacao_a_objeto.Conta

interface Transferivel {

    fun transferencia(valor: Double, contaASerTransferida: Conta)
}