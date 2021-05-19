package curso_um_orientacao_a_objeto

abstract class Conta(val titular: String,
            val numero: Int) {

    var saldo = 0.0
        protected set(valor){
            if(valor <= 0) {
                return
            }
            field = valor
        }

    abstract fun depositar(valor: Double)

    abstract fun sacar(valor: Double)

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