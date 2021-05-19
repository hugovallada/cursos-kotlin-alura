package curso_um_orientacao_a_objeto

class Conta(val titular: String,
            val numero: Int) {

    var saldo = 0.0
        private set(valor){
            if(valor <= 0) {
                return
            }
            field = valor
        }



    fun depositar(valor: Double){
        when{
            valor <= 0 -> println("Não pode fazer isso")
            else -> this.saldo += valor
        }
    }

    fun sacar(valor: Double){
        when {
            valor <= 0 -> println("Não pode fazer isso")
            valor in 0.0..saldo -> saldo -= valor
            else -> println("Não pode fazer isso")
        }
    }

    fun transferencia(valor:Double, contaASerTransferida:Conta){
        when{
            valor <= 0 -> println("Não pode fazer isso")
            valor in 0.0..saldo -> {
                contaASerTransferida.depositar(valor)
                saldo -= valor
            }
            else -> println("Não pode fazer isso")
        }
    }

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