package curso_recursos_e_pacotes.modelo

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