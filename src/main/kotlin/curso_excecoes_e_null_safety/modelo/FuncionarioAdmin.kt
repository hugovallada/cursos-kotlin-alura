package curso_excecoes_e_null_safety.modelo

abstract class FuncionarioAdmin(nome:String, cpf: String, salario: Double, val senha: Int) : Funcionario(nome, cpf, salario), Autenticavel {

    override fun autenticar(senha: Int): Boolean{
        if(this.senha == senha){
            return true
        }
        return false
    }
}