package curso_recursos_e_pacotes.modelo


class ContaSalario(titular:Cliente, numero: Int) : Conta(titular = titular, numero = numero) {
    override fun depositar(valor: Double) {
        TODO("Not yet implemented")
    }

    override fun sacar(valor: Double) {
        TODO("Not yet implemented")
    }



}