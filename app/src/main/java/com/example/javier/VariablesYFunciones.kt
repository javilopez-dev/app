package com.example.javier

private val age:Int =20


var name:String? = "s"

var array0 = arrayOf("1", 2,3,4,5)


fun main(){
    for (item in array0){
        println(item)
    }

    println(name?.get(0))
    if (age<20) {
        println("YO soy Cristian y tengo $age año")
    }
    else{
        println("YO soy Cristian y soy mayor de edad")
    }

}