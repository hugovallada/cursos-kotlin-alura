package curso_collections_listas_array

import java.math.BigDecimal
import java.math.RoundingMode

fun main() {

    usaPrateleira()
}

fun usaPrateleira() {
    val prateleira = Prateleira(
        genero = "Literatura",
        livros = criarLivros()
    )

    val organizarPorAutor = prateleira.organizarPorAutor()
    val organizarPorAnoPublicacao = prateleira.organizarPorAnoPublicacao()


}

fun geraLivrosComNulo(): MutableList<Livro?>{
    val livros: MutableList<Livro?> = mutableListOf(
        null,
        Livro(titulo = "Grande Sertão", autor = "João Guimarães", anoPublicacao = 1956),
        Livro(
            titulo = "O dinossauro que fazia au au",
            autor = "Pedro Bandeira",
            anoPublicacao = 1995,
            editora = "Abril"
        ),
        Livro(
            titulo = "O atol das rocas",
            autor = "Yuri Alves",
            anoPublicacao = 1999
        ),
        Livro(
            titulo = "Turma da Cônica",
            autor = "Mauricinho Souzado",
            anoPublicacao = 2000,
            editora = "Panone"
        )
    )

    return livros

}

fun listaComNulos() {
    val livros: MutableList<Livro?> = mutableListOf(
        null,
        Livro(titulo = "Grande Sertão", autor = "João Guimarães", anoPublicacao = 1956),
        Livro(
            titulo = "O dinossauro que fazia au au",
            autor = "Pedro Bandeira",
            anoPublicacao = 1995,
            editora = "Abril"
        ),
        Livro(
            titulo = "O atol das rocas",
            autor = "Yuri Alves",
            anoPublicacao = 1999
        ),
        Livro(
            titulo = "Turma da Cônica",
            autor = "Mauricinho Souzado",
            anoPublicacao = 2000,
            editora = "Panone"
        )
    )

    livros.filterNotNull()
        .groupBy { it.editora ?: "Editora desconhecida" }
        .forEach{(editora, listaDeLivros) ->
            println("$editora: ${listaDeLivros.joinToString { it.titulo }}")
        }




}


fun trabalhandoComListas() {
    val livros = criarLivros()
    livros.add(
        Livro(
            titulo = "Clube do bolinha",
            autor = "Cazuzado",
            anoPublicacao = 1986
        )
    )


    livros.imprimeComMarcadores()

    val ordenadoTitulo = livros.sorted()
    ordenadoTitulo.imprimeComMarcadores()

    livros.sortedBy { it.titulo }.imprimeComMarcadores()

    livros.filter { it.autor == "João Guimarães" }
        .imprimeComMarcadores()

    val titulos = livros.filter { it.autor.startsWith("J") }
        .map { it.titulo }

    println(titulos)

}

fun criarLivros(): MutableList<Livro> {
    val livro1 = Livro(titulo = "Grande Sertão", autor = "João Guimarães", anoPublicacao = 1956)
    val livro2 = Livro(
        titulo = "O dinossauro que fazia au au",
        autor = "Pedro Bandeira",
        anoPublicacao = 1995,
        editora = "Abril"
    )
    val livro3 = Livro(
        titulo = "O atol das rocas",
        autor = "Yuri Alves",
        anoPublicacao = 1999
    )
    val livro4 = Livro(
        titulo = "Turma da Cônica",
        autor = "Mauricinho Souzado",
        anoPublicacao = 2000,
        editora = "Panone"
    )

    val livros = mutableListOf(livro1, livro2, livro3, livro4)
    return livros
}

fun compondoOperacoes(lista: Array<BigDecimal>) {
    val media = lista.sorted().takeLast(3).toTypedArray().media()

    println(media)
}

fun usandoReduceEFold() {
    val salarios = gerarArrayDeBigDecimal("2500.50", "1500.50", "3000", "7000.90", "9000.00")

    val salarioModificado = salarios.map {
        if (it / "10.00".toBigDecimal() < "500.00".toBigDecimal()) (it + "500".toBigDecimal()).setScale(
            2,
            RoundingMode.UP
        )
        else (it * BigDecimal("1.1")).setScale(2, RoundingMode.UP)
    }.toTypedArray()

    val reduce = salarioModificado.reduce { acc, valor -> valor + acc }

    println(reduce)

    val gastoTotal = salarioModificado.fold(reduce) { acc, salario ->
        acc + (salario * 6.toBigDecimal()).setScale(
            2,
            RoundingMode.UP
        )
    }

    println(gastoTotal)

    compondoOperacoes(salarioModificado)


}

fun arrayDeObjetos() {
//    val salarios = Array<BigDecimal>(5) { BigDecimal.ZERO }
//    salarios[0] = BigDecimal("2500.50")
//    salarios[1] = "1500.50".toBigDecimal()
//    salarios[2] = "3000.00".toBigDecimal()
//    salarios[3] = "7000.90".toBigDecimal()
//    salarios[4] = BigDecimal("9000.00")

    val salarios = gerarArrayDeBigDecimal("2500.50", "1500.50", "3000", "7000.90", "9000.00")

    println(salarios.contentToString())

    val salarioModificado = salarios.map {
        if (it / "10.00".toBigDecimal() < "500.00".toBigDecimal()) (it + "500".toBigDecimal()).setScale(
            2,
            RoundingMode.UP
        )
        else (it * BigDecimal("1.1")).setScale(2, RoundingMode.UP)
    }

    for (salario in salarioModificado) {
        println(salario)
    }

}

fun gerarArrayDeBigDecimal(vararg valores: String): Array<BigDecimal> {
    return Array<BigDecimal>(valores.size) { valores[it].toBigDecimal() }
}

fun funcoesAgregadoras() {
    val idades = intArrayOf(10, 12, 18, 33, 40, 67)

    println(idades.maxOrNull())
    println(idades.minOrNull())
    println(idades.average())

    var verdadeOuMentira = idades.all { idade -> idade > 18 }
    val resposta = if (idades.all { it > 18 }) "é verdade" else "é mentira"
    println("É o que? $resposta ... $verdadeOuMentira")

    if (idades.any { it <= 18 }) {
        println("Alguém é menor de idade")
    }

    val maiores = idades.filter { it >= 18 }
    println(maiores)

    val find = idades.find { it == 18 }
    println(find)
}

fun trabalhandoComRange() {
    val serie: IntRange = 1.rangeTo(10)
    serie.forEach { ser -> println(ser) }

    val numerosPares = 0..100 step 2
    numerosPares.forEach { par -> println(par) }

    val alfabeto = 'a'..'z'
    alfabeto.forEach { letra -> print("$letra ") }
    alfabeto.forEach { println(it) }

}


fun alterarElementosDeArray() {
    val salarios = doubleArrayOf(1500.50, 2300.0, 5000.0, 8000.0, 10000.0)

    var indice = 0
    salarios.forEach { salario -> salarios[indice++] += salario * 0.1 }

    salarios.forEach { salario -> println(salario) }

    for (indices in salarios.indices) {
        salarios[indices] = salarios[indices] * 1.1
    }

    println(salarios.contentToString())

    salarios.forEachIndexed { index, salario -> salarios[index] += salario * 0.1 }
    println(salarios.contentToString())

}

fun trabalharComArray() {

    val idades = IntArray(5)
    idades[0] = 25
    idades[1] = 22
    idades[2] = 35
    idades[3] = 28
    idades[4] = 55

    var maiorIdade = Int.MIN_VALUE
    for (idade in idades) {
        maiorIdade = if (idade > maiorIdade) idade else maiorIdade
    }

    println(maiorIdade)

    var menorIdade = Int.MAX_VALUE

    idades.forEach { idade -> menorIdade = if (idade < menorIdade) idade else menorIdade }

    println(menorIdade)
}