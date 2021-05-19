package curso_heranca_polimorfismo_e_interfaces

class Analista(
    nome: String,
    cpf: String,
    salario: Double,
) : Funcionario(nome = nome,cpf = cpf,salario = salario) {

    override val bonificacao: Double
        get() {
            return salario * 0.1 + salario * 0.1
        }

}