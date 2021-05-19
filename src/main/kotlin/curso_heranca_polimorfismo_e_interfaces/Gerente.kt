package curso_heranca_polimorfismo_e_interfaces

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