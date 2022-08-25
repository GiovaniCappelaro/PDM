package com.giovani.pdm.introkotlin

fun main(){
    //Declaração de variável

    //var frase: String = "Hello, world!"

    val frase: String = "Hello, world!"

    println(frase)

    //reatribuição de valor pra var:
    //frase = "Hello, IFSP"


    //String Templates
    println("$frase")
    println("${frase.uppercase()}")

    println("Quantidade de caracteres: ${frase.count()}") //chamada de função
    println("Quantidade de caracteres: ${frase.length}")  //chamada de propriedade



}