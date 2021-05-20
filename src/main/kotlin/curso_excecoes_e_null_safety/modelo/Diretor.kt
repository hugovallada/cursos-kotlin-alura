package curso_excecoes_e_null_safety.modelo

class Diretor(
    nome: String,
    cpf: String,
    salario: Double,
    senha: Int,
    val plr: Double
) : FuncionarioAdmin(nome = nome,cpf = cpf,salario = salario, senha = senha) {


    override val bonificacao: Double get() = salario * 0.1 + salario + plr


}