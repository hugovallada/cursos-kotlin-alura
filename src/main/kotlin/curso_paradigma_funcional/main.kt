package curso_paradigma_funcional

import curso_paradigma_funcional.model.Person
import curso_recursos_e_pacotes.modelo.Cliente
import curso_recursos_e_pacotes.modelo.ContaPoupanca
import curso_recursos_e_pacotes.modelo.Endereco


fun main(){
//    somatoria(1,5) {
//        print(it)
//    }

    implementarFuncoesComReceiver()
}

fun somaReceiver(a: Int, b: Int, resultado: Int.() -> Unit){
    val total = a + b
    total.resultado()
}

fun implementarFuncoesComReceiver(){
    somaReceiver(1,5, resultado = {
        print(this)
    })
}

fun testaORun(){
    val taxaAnual = 0.05
    val taxaMensal = taxaAnual / 12

    val contaPoupanca = ContaPoupanca(Cliente(nome = "Hugo", cpf = "22222", senha = 1234), 1000)

    contaPoupanca.run {
            depositar(1000.0)
            saldo * taxaMensal
        }.let(::println)

    val rendimento = run {
        var saldo = contaPoupanca.saldo
        repeat(12) { indice ->
            saldo += saldo * taxaMensal
        }
        saldo
    }

    println("Rendimento Anual: $rendimento")

}

fun testandoOWith(){
    with(Person("Hugo")){
        age = 25
        city = "Ribeirão Preto"

        completo()
    }.let {
        dadosCompletos: String ->
        println(dadosCompletos)
    }
}

fun qualScopeUsar(){
    val str = "Ola"
    with(str){
        println(this)
    }
}

fun testandoApply(){
    Endereco(
        logradouro = "Rua vergueiro",
        numeroEndereco = 3185,
        bairro = "Centro",
        cidade = "Cidade",
        cep = "144034",
        estado = "SP",
        complemento = "dijda"
    ).run {
        "$logradouro , $numeroEndereco".toUpperCase()
    }.let {
        println(it)
    }
}

fun scopeFunctions(){
    val str = "Hello"

    str.run {
        println("Tamanho: $length")
    }

    str.let {
        println("Tamanho: ${it.length}")
    }

    val hugo = Person("Hugo").apply {
        age = 20
        city = "Ribeirão Preto"
    }

}

fun somatoria(a: Int, b:Int, resultado: (Int) -> Unit){
    resultado(a+b)
}

fun testandoOAlsoEApply(){
   val numberList = mutableListOf<Double>()
    numberList.also { println("Populando a Lista") }
        .apply {
            add(2.17)
            add(3.15)
            add(1.0)
        }
        .also {
            println("Finalizando a lista")
        }

    numberList.forEach { numero -> println(numero)}
}


fun testandoOLet(){

    Endereco(
        logradouro = "Rua vergueiro",
        numeroEndereco = 3185,
        bairro = "Centro",
        cidade = "Cidade",
        cep = "144034",
        estado = "SP",
        complemento = "dijda"
    ).let {
        endereco ->  "${endereco.logradouro} , ${endereco.bairro}".toUpperCase()
    }.let(::println)

}

val highOrderFunctions = {
    testeHighOrder { // qnd a função no parâmetro é o ultimo, não precisa do ()
        println("Ola")
    }

    novoTeste({
        print("")
    }, "Ola")
}



fun novoTeste(funcao: () -> Unit, valor: String){
    funcao()
}

fun testeHighOrder(funcao: () -> Unit){
    funcao()
}

private fun lambdaComMultiplosRetornos(){
    val funcao: (salario: Double) -> Double = bonus@{
        when {
            it <=1000.0 -> return@bonus it + 50.0
            it <= 1200.0 -> return@bonus it + 100.0
            else -> return@bonus it + 200.00
        }
    }

    val funcao2 : (salario: Double) -> Double = bonus@{
        salario ->
            when {
                salario <= 1000 -> return@bonus salario + 200.0
                salario <= 1500 -> return@bonus salario + 100.0
                else -> return@bonus salario + 50.0
            }
    }

    println(funcao2(2000.50))

    val novaFuncao = lambda@{
        salario: Double -> salario * 10
    }

    println(novaFuncao(1000.00))

    println(funcao(2000.0))

}

private fun lambdaEFuncoesAnonimasComRetorno(){
    val expressaoLambdaComParametroERetorno = {
        val1: Int, val2: Int -> val1 + val2
    }

    val expressaoLambdaComParametroERetornoComAssinatura: (val1: Int, val2:Int) -> Int = {
        val1, val2 ->  val1 + val2
    }

    val expressaoLambdacomParametroAnonimo: (Int, Int) -> Int = {
        a, b -> a + b
    }

    val funcaoAnonima = fun(a: Int, b:Int) : Int {
        return a + b
    }

    // Bem similar ao arrow function
    val teste = { a: Int, b: Int -> a + b}
}

private fun tipoFuncaoComParametrosERetornos(){
    val minhaFuncao = ::soma
    println(minhaFuncao(5,5))
}

private fun soma(valor1 : Int, valor2: Int) : Int {
    return valor1 + valor2
}

private fun funcoesAnonimasELambdas(){
    val minhaFuncaoLambda : () -> Unit = {
        println("Ola Mundo")
    }

    val minhaFuncaoAnonima = fun() {
        println("Função Anônima")
    }

    val lambdaParaCalculo = {
        val1: Int, val2: Int -> val1 + val2
    }

    val lambdaParaCalculo2 : (val1: Int, val2:Int) -> Int = {
        val1, val2 -> val1 + val2
    }


}

fun funcaoComExpressaoAoInvesDeBloco(p1:Int, p2:Int) : Int = p1 + p2

private fun invoke() {
    val f: (Int, Int) -> Double = ::safeDivide

    val minhaFuncao: () -> Unit = ::teste

    minhaFuncao()

    val minhaFuncaoClasse: () -> Unit = Teste()
    minhaFuncaoClasse()

    val anonima: () -> Unit = {
        println("Isso é uma funcão anônima")
    }

    anonima()

    val funcaoAnonima: (numero: Int, numero2: Int) -> Unit = { numero, numero2 ->
        println(numero + numero2)
    }

    funcaoAnonima(5, 10)
}


fun safeDivide(numerator: Int, denominator: Int) =
    if(denominator == 0) 0.0 else numerator.toDouble()/denominator

fun teste(){
    println("Olá mundo")
}

class Teste : () -> Unit{
    override fun invoke() {
        println("Executa invoke do teste")
    }

}

class TesteSoma : (Int, Int) -> Int {
    override fun invoke(p1: Int, p2: Int): Int {
        return p1 + p2
    }

}

private val media = { notaP1: Double, notaP2: Double -> (notaP1 + notaP2) / 2 }
