package curso_collections_listas_array

data class Prateleira(
    val genero: String,
//    val livros: MutableList<Livro>
    val livros:List<Livro>
) {
//    fun organizarPorAutor(): MutableList<Livro>{
//        livros.sortBy{it.autor}
//        return livros
//    }

//    fun organizarPorAnoPublicacao(): MutableList<Livro>{
//        livros.sortBy { it.anoPublicacao }
//        return livros
//    }

    fun organizarPorAutor(): List<Livro> {
        return livros.sortedBy { it.autor }
    }

    fun organizarPorAnoPublicacao(): List<Livro>{
        return livros.sortedBy { it.anoPublicacao }
    }
}