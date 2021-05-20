package curso_excecoes_e_null_safety.modelo


interface Transferivel {

    fun transferencia(valor: Double, contaASerTransferida: Conta)
}