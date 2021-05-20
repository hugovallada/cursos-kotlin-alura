package curso_excecoes_e_null_safety.modelo

class Cliente(val nome: String, val cpf: String,
              val senha: Int,
              var endereco: Endereco ? = null) : Autenticavel {

    override fun autenticar(senha: Int): Boolean {
        if(this.senha == senha){
            return true
        }
        return false
    }

}