package curso_collections_listas_array

fun List<Livro?>.imprimeComMarcadores(){
    val joinToString = this.filterNotNull().joinToString(separator = "\n") {
        " - ${it.titulo} de ${it.autor}"
    }

    println(" ### LISTA DE LIVROS ###")
    println(joinToString)
}