package curso_excecoes_e_null_safety.exception

class SaldoInsuficienteException(message: String? = "O saldo é insuficiente") : Exception(message) {
}