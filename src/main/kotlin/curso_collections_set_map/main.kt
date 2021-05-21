package curso_collections_set_map

fun main(){
    associacaoEagrupamento()
}

fun associacaoEagrupamento(){
    data class Pedido(val numero: Int, val valor:Double)

    val pedidos = listOf(Pedido(1, 20.0), Pedido(2, 20.0), Pedido(3, 60.0))

    val pedidosMapeados = pedidos.associateBy { it.numero }

    println(pedidosMapeados)


    val freteGratis = pedidos.associateWith { it.valor > 50 }
    println(freteGratis)

    freteGratis.filter { (_, value) -> value }


    val groupBy = pedidos.groupBy { it.valor }
    println(groupBy)

    /**
     * usando o group ny para criar uma agenda
     */
    val nomes = listOf("Maria","Ana", "Angélica", "Lais", "Lisa", "José", "Alberto", "Marcos","Prass", "Rony", "Dudu","Marina","Dado")
    val agenda = nomes.sorted().groupBy { it.first() }

    for(alfabeto in agenda) {
        println(alfabeto)
    }
}

fun leituraEescritaMap(){
    val pedidos = mapOf("a" to "Hugo", "b" to "Xow", "c" to "Xuxa")

    println(pedidos.getValue("a"))
    println(pedidos.getOrElse("2") {
        "Não tem o pedido"
    })
    println(pedidos.getOrDefault("10", "Xablau"))
    println(pedidos.keys)
    println(pedidos.values)

    pedidos.keys.forEach{ println(it)}

    val pedidosComX = pedidos
        .filter { (_, value) ->
            value.startsWith("X")
        }

    println(pedidosComX)


    val pedidosSoChaves = pedidos.filterKeys { it == "10" }
    println(pedidosSoChaves)

    val pedidosSoValue = pedidos.filterValues { it == "Xuxa" }
    println(pedidosSoValue)
}

fun testaMap(){
    mapOf<Int, Double>(Pair(1,20.0), Pair(2, 34.0))
    val pedidos = mapOf(1 to 10.0, 2 to 50.0)

    println(pedidos[1])

    pedidos.forEach { key, value -> println(value) }

    for (pedido in pedidos){
        println(pedido.key)
        print(pedido.value)
    }


    val novosPedidos = mutableMapOf("Pedido1" to 50.0, "Pedido2" to 100.0)

    novosPedidos["Pedido3"] = 40.0

    novosPedidos["Pedido3"] = 20.0

    novosPedidos.putIfAbsent("Pedido1", 2000.00)

    novosPedidos.forEach { (key, value) ->
        println("O pedido $key tem o valor: R$ ${value.toBigDecimal().setScale(2)}")
    }

    novosPedidos.remove("Pedido1")

    novosPedidos.forEach { (key, value) -> println("$key : $value")  }

    }

private fun testaSet() {
    val setAndroid = setOf("Alex", "Fran", "Gui")
    val setKotlin = setOf("Hugo", "Alex", "Maria")

    val listaAlunosSimples = setAndroid + setKotlin // msm coisa q o union
    val novaListaComUnion = setAndroid.union(setKotlin)
    val listaUnionComOperadorUnion = setAndroid union setKotlin

    println(setAndroid - setKotlin)
    println(setAndroid subtract setKotlin)

    println(setAndroid intersect setKotlin)

    println(listaAlunosSimples)
}


private fun testeCopia() {
    val nomes = mutableListOf("Hugo", "Fran", "Maria")
    println(nomes)

    nomes.add("Franciscana")

    val nomesImutaveis: List<String> = nomes
    println(nomesImutaveis)

    val nomesComCopy = nomes.toList() // copy sem ser shallow
}