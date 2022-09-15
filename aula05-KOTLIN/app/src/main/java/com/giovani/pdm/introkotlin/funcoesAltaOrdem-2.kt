package com.giovani.pdm.introkotlin

//Tipo genérico
inline fun <T,R> List<T>.paraCada(funcao: (T) -> R) : List<R>{
    val lista: MutableList<R> = mutableListOf()

    for (item in this){
        lista.add(funcao(item))
    }

    return lista.toList()
}
//funcoes inline são mais rápidas e mais pesadas, pois meio que copia o código da função pra onde for chamado

//aplicar função a um tipo, no caso list de strings

fun List<String>.paraCadaString(funcao: (String) -> String ): List<String> {
    val listaStrings: MutableList<String> = mutableListOf()

    for (str in this ){
        listaStrings.add(funcao(str))
    }

    return listaStrings.toList()
}

//função pra passar de parametro na função acima
fun primeiraLetra(s: String) : String {
    return s.first().toString()
}

fun  main(){
    val listaNomes: List<String> = listOf("Pedro", "Joao", "Maria", "Carlos")
    val listaPrimeiras : List<String> = listaNomes.paraCadaString(::primeiraLetra)
    val listaMaiusculas : List<String> = listaNomes.paraCadaString() {it.uppercase()}

    listaPrimeiras.forEach{println(it)} //'it' é cada item da lista
    listaMaiusculas.forEach{println(it)}
}
