package curso_heranca_polimorfismo_e_interfaces

class Diretor(
    nome: String,
    cpf: String,
    salario: Double,
    senha: Int,
    val plr: Double
) : FuncionarioAdmin(nome = nome,cpf = cpf,salario = salario, senha = senha) {


    override val bonificacao: Double get() = salario * 0.1 + salario + plr


}