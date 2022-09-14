package com.giovani.pdm.introkotlin

//aula06
// single expressions
//fun multiplo(a: Int, b: Int) = a % b == 0;


fun multiplo(a: Int, b: Int) : Boolean{

    return (a % b == 0);
}

//Tipos Int, FLoat, ... são Classes tbm, podem fazer metodos pra eles
fun Int.multiploo(b: Int) : Boolean {
    return multiplo(this, b) //this é o próprio Int (parâmetro a)
}

//função infixada
infix fun Int.multiplooo(b: Int) : Boolean {
    return multiplo(this, b) //this é o próprio Int (parâmetro a)
}


fun main() {
    println(multiplo(10 , 2))
    println(12.multiploo(3))
    println(16 multiplooo 4)
}

