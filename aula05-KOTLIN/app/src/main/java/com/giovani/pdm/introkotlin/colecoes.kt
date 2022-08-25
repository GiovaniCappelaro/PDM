package com.giovani.pdm.introkotlin

fun main() {
    //List(não mutavel)

    var familia : List<String> = listOf("Giovani", "Luciene", "Esmeraldo", "Gabriel") //não alterável

    //posso alterar a referência por ser uma var, perde a referência à list anterior acima:
    familia = listOf("Natalina" , "Sebastião")

    for (integrante : String in familia){
        println(integrante)

    } //tipo um forEach pra percorrer


    val listaInteiros: List<Int> = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    //por ser um val, n da pra reatribuir a referência

   /* for (i in 0..9){
        println(listaInteiros[i])
    } */

    //forEach
    listaInteiros.forEach { println(it)}  //cada 'it' é um item da lista

    //pegando o índice tbm (forEachIndexed):
    listaInteiros.forEachIndexed { indice, valor -> println("${indice} - ${valor}") }


    //Mutable list (posso alterar a lista em si, não só a referência)

    val listaCursos: MutableList<String> = mutableListOf(
        "Analise e des. de sistemas",
        "Sistemas para disp. móveis",
        "Informatica para internet"
    )

    listaCursos.add("Engenharia de software")

    listaCursos.forEach {println(it)}


    //set e mutableSet (ambos não permitem add itens repetidos na lista)
    //-> set não deixa nem modificar (igual a List)

    val setCursos: MutableSet<String> = mutableSetOf("ADS", "SDM", "TII")

    setCursos.add("BES");
    setCursos.add("ADS");

    setCursos.forEach {println(it)}


    //Map e Mutable

    val familiaMap : MutableMap<String, String> = mutableMapOf(
        Pair("Pai", "Pedro"),
        Pair("Mae" , "Marcela"),
        Pair("Filho1" , "JP"),
        Pair("Filho2" , "Cadu")
    )

    //add itens nos maps:
    familiaMap.put("Pet1" , "Julie")
    familiaMap["Pet2"] = "Nina"

    //percorrer os maps
    familiaMap.keys.forEach { println("${it} - ${familiaMap[it]}")} //pega cada key e mostra ela e seu valor

    /*outra forma de fazer:
    familiaMap.keys.forEach { chave -> println("${chave} - ${familiaMap[chave]}")} */
}