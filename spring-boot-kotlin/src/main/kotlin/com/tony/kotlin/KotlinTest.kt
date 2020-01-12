package com.tony.kotlin

/**
 * As we known .Although it's not fit
 * all framework but config with frame
 */
class KotlinTest {
    /**
     *Not as the Java Language to have the basic type.
     */
    var a: Int = 0
    var b: String = "Kotlin String"
    //As we known it can't  be null.
    val c: Int = 111

    /**
     * Base plus with function body and 'return'
     */
    fun sum(a: Int, b: Int): Int {
        return a + b
    }

    /**
     * Kotlin ignores the keywords "return" more easier. more simplifier
     */
    fun sum1(a: Int, b: Int): Int = a + b

    fun printSum(a: Int, b: Int) {
        var x = 5
        x += 1
        //Here support inline el .really amazing.
        println("sum of $a and  $b is ${a + b}")
    }

    /**
     * Condition controller phase 'if'
     */
    fun maxOf(a: Int, b: Int): Int = if (a > b) a else b

    /**
     * Kotlin resizable variable
     */
    fun testResizable(vararg v: Int) {
        for (i in v) {
            print(i)
        }
    }

    /**
     * Kotlin function simplify
     */
    fun max(a: Int, b: Int) = if (a > b) a else b


    /**
     * //TODO to resolve the answer
     * Type check
     */
    fun parseInt(str: String): Int? {
        return 12222
    }

    /**
     * Control loop phase 'while'
     */
    fun whileTest() {
        val list = listOf("a", "b", "c")
        var index = 0
        while (index < list.size) {
            print("this is better way ${list[index]}")
            index++
        }
    }

    /**
     * Kotlin condition expression
     */
    fun desription(obj: Any): String {
        when (obj) {
            1 -> "one"
            "Hello" -> "Greeting"
            is Long -> "Long"
            !is String -> "Not a string"
            else -> "Unknown"
        }
        return ""
    }

    /**
     *Number check
     */
    fun checkNum() {
        val x = 10
        var y = 9
        if (x in 1..y + 1) {
            print("$x is in range")
        } else {
            print("$x is not in range")
        }

        val fruits = listOf("banana", "avocado", "apple", "kiwifruit")
        fruits.filter { it.startsWith("a") }
                .sortedBy { it }
                .map { it.toUpperCase() }
                .forEach {
                    print(it)
                }
    }

    /**
     * Kotlin Loop Test
     */
    fun loopTest() {
        //Number up
        for (t in 1..9 step 2) {
            print(t)
        }
        //Number down
        for (t in 9 downTo 0 step 3) {
            print(t)
        }
        //Init item list
        val items = listOf(1, 2, 3, 4, 5, "")
        //visit the item of list
        for (item in items)
            print(item)
        //visit the item of list by the index
        for (index in items.indices) {
            print("this is $index value is  ${items[index]}")
        }
    }

    /**
     * Kotlin Trim
     */
    fun trimMarginTest() {
        var s = "                 test"
        s.trimMargin(" ")
        var test: String? = "222"
        val s1 = test ?: return
    }

    /**
     * Kotlin Label
     */
    fun labelTest() {
        outer@ for (start in 1..20) {
            inner@ for (index in 9 downTo 0 step 3) {
                if (index == 3) {
                    break@inner
                }
                if (start == 5) {
                    break@outer
                }
            }
        }

        listOf(1, 2, 3, 4, 5).forEach {
            if (it == 3) return // non-local return directly to the caller of foo()
            print(it)
        }
        println("this point is unreachable")

        listOf(1, 2, 3, 4, 5).forEach lit@{
            if (it == 3) return@lit // local return to the caller of the lambda, i.e. the forEach loop
            print(it)
        }

        listOf(1, 2, 3, 4, 5).forEach {
            if (it == 3) return@forEach // local return to the caller of the lambda, i.e. the forEach loop
            print(it)
        }


    }

    /**
     * Kotlin lambda
     */
    fun lambdaTest() {
        val sumLambda: (Int, Int) -> Int = { x, y -> x + y }
    }

    fun LabelTest1(): Int? {
        test@ for (index in 1..5) {

        }
        return test@ 1
    }

    fun main(args: Array<String>) {


    }
}