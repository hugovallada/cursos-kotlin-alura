package curso_excecoes_e_null_safety.exception

import java.lang.Exception

class FalhaAutenticacaoException(message: String? = "Falhou a autenticação") : Exception(message) {
}