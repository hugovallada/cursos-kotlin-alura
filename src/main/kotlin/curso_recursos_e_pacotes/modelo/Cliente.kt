package curso_recursos_e_pacotes.modelo

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