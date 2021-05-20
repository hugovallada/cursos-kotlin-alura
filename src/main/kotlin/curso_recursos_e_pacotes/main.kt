package curso_recursos_e_pacotes

import curso_recursos_e_pacotes.modelo.*
import curso_recursos_e_pacotes.teste.Cliente as ClienteDiferente

fun main(){

    var classe = Any()

    val endereco = Endereco("rua", 648, "centro", "rp", "sp", "14", "comp")
    val cliente = Cliente("Hugo","222",12345, endereco)

    imprime(cliente)


}

fun imprime(valor: Any){
    println(valor)
}



private fun testaContas() {
    val fran = object : Autenticavel {
        val nome: String = "Fran"
        val cpf: String = "111111"
        val senha: Int = 1000

        override fun autenticar(senha: Int) = this.senha == senha
    }


    val sistemaInterno = SistemaInterno()
    sistemaInterno.entra(fran, 1000)

    val endereco = Endereco("rua", 648, "centro", "rp", "sp", "14", "comp")
    val clienteOriginal = Cliente("Hugo", "222", 1230, endereco)

    val clienteDiferente = ClienteDiferente()

    val conta = ContaCorrente(clienteOriginal, 2000)

    println(conta.titular.nome)
    println(conta.titular.endereco!!.logradouro)


    println("Total de contas ${Conta.total}")
}