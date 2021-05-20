package curso_recursos_e_pacotes.modelo

class Gerente(
    nome: String,
    cpf: String,
    salario: Double,
    senha: Int
) : FuncionarioAdmin(nome = nome,cpf = cpf,salario = salario, senha = senha){

    override val bonificacao: Double
        get() {
            return salario * 0.1 + salario
        }

}