package com.giovani.pdm.introkotlin


fun multiplo(a: Int, b: Int) : Boolean{
    val c: Int = a % b

    if(c == 0){
        return true
    }
    return false
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