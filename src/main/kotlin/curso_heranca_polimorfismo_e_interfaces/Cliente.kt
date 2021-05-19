package curso_heranca_polimorfismo_e_interfaces

class Cliente(val nome: String, val cpf: String, val senha: Int) : Autenticavel {

    override fun autenticar(senha: Int): Boolean {
        if(this.senha == senha){
            return true
        }
        return false
    }

}