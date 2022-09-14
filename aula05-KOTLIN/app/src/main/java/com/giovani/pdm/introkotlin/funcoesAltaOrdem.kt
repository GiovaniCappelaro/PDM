package com.giovani.pdm.introkotlin

/*
Funções alta ordem -> Recebe uma função como parâmetro e aplica dentro dela mesma
No exemplo usa single expression
*/

fun processaTexto(str1: String, str2: String, processa: (s1:String, s2: String) -> String ) = processa(str1, str2)
//função processaTexto tem 3 parâmetros: str1, str2 e a função processa()
//parametro processa é do tipo função, q tem 2 parametros (s1 e s2) e retorna uma String;

fun concatena(a: String, b:String) : String{
    return "${a + b}"
}

fun inverte(x: String, y:String) = "${y.reversed()}${x.reversed()}"

fun main(){
    println(processaTexto("Olá, ", "Mundo", ::concatena))
    println(processaTexto("Olá, ", "Mundo", ::inverte))
    println(processaTexto("Olá, ", "Mundo", {a, b -> "${a.uppercase()}${b.uppercase()}"}))
    println(processaTexto("Olá, ", "Mundo", fun (a: String, b:String) = "${a.lowercase()}${b.lowercase()}"))
    println(processaTexto("Olá, ", "Mundo") {a: String, b:String -> "${a.uppercase()}${b.uppercase()}"})
}

//:: apenas passa a função como parâmetro
// -> na main:
// linha 19 - chama a função concatena como parâmetro 'processa' da função processaTexto()
//linha 20 - chama a função concatena como parâmetro 'processa' da função processaTexto()
//Linha 21 - chama direto uma função com lâmbida ( ->) feita na propria linha, q passa tudo pra uppercase
//linha 22 - chama uma função anonima
//linha 23 - chama a função que é o terceiro parâmetro, fora dos PARÊNTESES