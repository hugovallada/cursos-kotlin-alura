package curso_heranca_polimorfismo_e_interfaces

interface Autenticavel {

    fun autenticar(senha:Int) : Boolean

    /**
     * Implementação padrão de um método
     * Precisa passar o atributo que quem implementa obrigatoriamente terá
     * override val senha: Int em quem implementar
     */
//    val senha: Int
//
//    fun autenticar(senha:Int):Boolean {
//        if(this.senha == senha){
//            return true
//        }
//        return false
//    }
}