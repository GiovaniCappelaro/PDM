package com.giovani.pdm.introkotlin

fun main(){
    //tipo explicito
    var nome : String = "Carlos"

    //tipo implicito
    var sobrenome = "Camargos"  //não dei o tipo e ele ja identificou o tipo

    //Atribuição posterior (se apenas delcarar sem valor, precisa definir tipo)
    var nomeMeio : String
    nomeMeio = "Oliveira"

    //Float
    val altura : Float = 1.78f

    //Int
    var idade : Int = 30

    //Double
    var peso : Double = 72.toDouble(); //Converte pra double (poderia só por 72.77 por ex)

    println("Nome: ${nome} ${nomeMeio} ${sobrenome}, altura: ${altura}, idade: ${idade}, peso: ${peso} .")


}