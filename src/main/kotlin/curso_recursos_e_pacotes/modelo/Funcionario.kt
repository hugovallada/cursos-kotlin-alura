package curso_recursos_e_pacotes.modelo

abstract class Funcionario(
    val nome: String,
    val cpf: String,
    val salario: Double,
) {

    abstract val bonificacao: Double

}