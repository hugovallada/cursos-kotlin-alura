package curso_collections_listas_array

data class Livro(
    val titulo: String,
    val autor: String,
    val anoPublicacao: Long,
    val editora: String? = null
) : Comparable<Livro> {
    override fun compareTo(other: Livro): Int {
        return this.titulo.compareTo(other.titulo)
    }
}
