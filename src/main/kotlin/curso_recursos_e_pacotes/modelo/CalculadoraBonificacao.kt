package curso_recursos_e_pacotes.modelo

class CalculadoraBonificacao {

    var total: Double = 0.0
        private set

    fun registra(funcionario: Funcionario){
        this.total += funcionario.bonificacao
    }

    /**
     * Smart Casting no Kotlin
     * O problema é que podemos mandar qualquer valor aqui
     */
    fun registra(funcionario: Any){
        funcionario as Funcionario
        this.total += funcionario.bonificacao
    }

    /**
     * Simple Cast no Kotlin
     * O problema é que podemos mandar qualquer valor aqui
     */
    fun registraSimpleCast(funcionario: Any){
        val funcNovo : Funcionario = funcionario as Funcionario
        this.total += funcNovo.bonificacao
    }

    /**
     * Smart Cast dentro do escopo do if apenas
     */
    fun registraComVerificacao(funcionario: Any){
        if(funcionario is Funcionario){
            this.total += funcionario.bonificacao
        }
    }

}