package curso_excecoes_e_null_safety.modelo

class SistemaInterno {

    fun entra(funcionario: Autenticavel, senha:Int){
        if(funcionario.autenticar(senha)){
            println("Bem vindo")
        }else{
            println("Falha na autenticação")
        }
    }

    fun entraTipo(admin: Autenticavel, senha: Int) {
        when(admin) {
            is FuncionarioAdmin -> println("Opções admin")
            is Funcionario -> println("Opções comum")
            else -> println("Opções reduzidas")
        }
    }
}