package curso_heranca_polimorfismo_e_interfaces

class SistemaInterno {

    fun entra(funcionario: Autenticavel, senha:Int){
        if(funcionario.autenticar(senha)){
            println("Bem vindo")
        }else{
            println("Falha na autenticação")
        }
    }
}