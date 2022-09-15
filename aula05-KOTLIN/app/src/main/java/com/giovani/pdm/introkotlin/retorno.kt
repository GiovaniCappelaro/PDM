package com.giovani.pdm.introkotlin

//funções que retornam funções

enum class TipoOperacao {
    ADD, MUL, DIV, SUB
}

fun div(a: Int, b:Int): Int {
    return a / b
}

fun operacao(op: TipoOperacao) : (Int, Int) -> Int {
    val sub: (Int, Int) -> Int = {a: Int, b: Int -> a - b} //val sub é uma função q recebe 2 int e retorna um int
    //tipo um switch case:
    when(op){
        TipoOperacao.ADD -> return {x, y -> x + y}   //lambida
        TipoOperacao.MUL -> return fun (a, b): Int = a * b //funcao anonima
        TipoOperacao.DIV -> return ::div    //funcao classica
        TipoOperacao.SUB -> return sub //var de funcao
    }
}

//função para aplicar operações
fun Int.aplica(i: Int, f: (Int, Int) -> Int): Int {
    return f(this, i) //this refere-se ao numero int q passarmos na função ( ex: 10.aplica -> this vale 10)
}

fun main(){
    println(10.aplica(2, operacao(TipoOperacao.ADD)))
    println(10.aplica(2, operacao(TipoOperacao.SUB)))
    println(10.aplica(2, operacao(TipoOperacao.MUL)))
    println(10.aplica(2, operacao(TipoOperacao.DIV)))
}