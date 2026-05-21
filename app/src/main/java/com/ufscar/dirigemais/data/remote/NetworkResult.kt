package com.ufscar.dirigemais.data.remote


sealed class NetworkResult<out T> {
    /** Requisição em andamento */
    object Loading : NetworkResult<Nothing>()

    /** Requisição concluída com sucesso. Contém os dados. */
    data class Success<T>(val data: T) : NetworkResult<T>()

    /** Requisição falhou. Contém a mensagem de erro. */
    data class Error(val message: String) : NetworkResult<Nothing>()
}
