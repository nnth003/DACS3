package com.example.myandroidapp

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.IllegalArgumentException
import kotlin.system.measureTimeMillis

fun main() {
    val time = measureTimeMillis {
        runBlocking {
            println("Weather forecast")
//            launch { printA() }
//            launch { printF() }
//            printA()
//            printF()
//            println("Have a good day!")
            try {
                throw IllegalArgumentException("No city selected")
            }catch (e: IllegalArgumentException){
                println("Caught exception $e")
            }

        }
    }
   println("Execution time : ${time / 1000.0} seconds")

}
suspend fun printF() {
    delay(5000)
    println("30\u00b0C")
}
suspend fun printA() {
    delay(5000)
    println("18\u00b0C")
}