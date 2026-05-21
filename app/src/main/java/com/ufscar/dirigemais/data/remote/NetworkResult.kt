package com.ufscar.dirigemais.data.remote

/**
 * Sealed class — representa os 3 estados possíveis de uma chamada de rede.
 * É como uma caixa lacrada: só pode ser Loading, Success ou Error.
 *
 * Usado pela ViewModel para notificar a UI do estado atual.
 */
sealed class NetworkResult<out T> {
    /** Requisição em andamento */
    object Loading : NetworkResult<Nothing>()

    /** Requisição concluída com sucesso. Contém os dados. */
    data class Success<T>(val data: T) : NetworkResult<T>()

    /** Requisição falhou. Contém a mensagem de erro. */
    data class Error(val message: String) : NetworkResult<Nothing>()
}
