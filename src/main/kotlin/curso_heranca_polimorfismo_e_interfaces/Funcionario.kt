package curso_heranca_polimorfismo_e_interfaces

abstract class Funcionario(
    val nome: String,
    val cpf: String,
    val salario: Double,
) {

    abstract val bonificacao: Double

}