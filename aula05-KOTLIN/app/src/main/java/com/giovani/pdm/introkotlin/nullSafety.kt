package com.giovani.pdm.introkotlin

//var não pode ser do tipo nulo = nullSafety

fun main() {
    var nome: String
    //nome = null

    //Operador Elvis ?:
    var sobrenome: String?
    sobrenome = null        //tipo 'String?'(nullable String) diz q a var pode ser null

    var sn = sobrenome?:"Nobile"    //se sobrenome for null, sn passa a valer "Nobile"

    println(sn)

    println(sobrenome?.length)

    //conversões
    val numString: String = 10.toString()
    val numDouble: Double = numString.toDouble()
    val numFloat : Float = numDouble.toFloat()
    var numInteiro: Int = numFloat.toInt()

    println(numInteiro)


    //Qualquer tipo:
    val any : Any = "Any equivale a Object"; //em kotlin, tudo é filho de Any por padrão
    //val Str : String = any as String;       //var str vale any convertido para String

    //smart casting
    if(any is String){
        println(any.count())
    }


}