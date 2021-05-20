package curso_recursos_e_pacotes.modelo

class Endereco(
    val logradouro: String,
    val numeroEndereco: Int,
    val bairro: String,
    val cidade: String,
    val estado: String,
    val cep: String,
    val complemento: String
) {
    override fun toString(): String {
        return "Endereco(logradouro='$logradouro', numeroEndereco=$numeroEndereco, bairro='$bairro', cidade='$cidade', estado='$estado', cep='$cep', complemento='$complemento')"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Endereco

        if (logradouro != other.logradouro) return false
        if (numeroEndereco != other.numeroEndereco) return false
        if (cep != other.cep) return false
        if (complemento != other.complemento) return false

        return true
    }

    override fun hashCode(): Int {
        var result = logradouro.hashCode()
        result = 31 * result + numeroEndereco
        result = 31 * result + cep.hashCode()
        result = 31 * result + complemento.hashCode()
        return result
    }


}