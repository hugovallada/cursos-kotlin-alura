package curso_excecoes_e_null_safety.modelo

abstract class Conta(val titular: Cliente,
            val numero: Int) : Autenticavel {

    var saldo = 0.0
        protected set(valor){
            if(valor <= 0) {
                return
            }
            field = valor
        }

    companion object {
        var total = 0
            private set
    }

    init {
        total++
    }

    abstract fun depositar(valor: Double)

    abstract fun sacar(valor: Double)

    override fun autenticar(senha: Int): Boolean {
        return titular.autenticar(senha)
    }

    //abstract fun transferencia(valor:Double, contaASerTransferida:Conta)

    /**
     * Esse tipo de código não é interessante
     */
//    fun getSaldo(): Double{
//        return this.saldo
//    }
//
//    fun setSaldo(valor: Double){
//        if(valor <=0) {
//            return
//        }
//        this.saldo = valor
//    }
}