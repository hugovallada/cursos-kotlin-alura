package curso_excecoes_e_null_safety.modelo

abstract class Funcionario(
    val nome: String,
    val cpf: String,
    val salario: Double,
) {

    abstract val bonificacao: Double

}