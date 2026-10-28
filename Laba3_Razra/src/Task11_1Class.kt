// Задание 11.1, Средний уровень вариант 5
open class Time {
    var hours: Int = 0
    var minutes: Int = 0
    var seconds: Int = 0
    constructor() {
        hours = 0
        minutes = 0
        seconds = 0
    }
    constructor(hours: Int, minutes: Int, seconds: Int) {
        this.hours = hours
        this.minutes = minutes
        this.seconds = seconds
    }
    fun fullMinutes(): Int {
        val total = hours * 3600 + minutes * 60 + seconds
        return total / 60
    }
    fun decreaseBy10Minutes() {
        var total = hours * 3600 + minutes * 60 + seconds
        total = total - 10 * 60
        if (total < 0) {
            total = total + 24 * 3600   // переход через полночь
        }
        hours = total / 3600
        minutes = (total % 3600) / 60
        seconds = total % 60
    }
    fun destroy() {
        println(": ${info()}")
        hours = 0
        minutes = 0
        seconds = 0
    }
    open fun info(): String {
        return "$hours:$minutes:$seconds"
    }
}
fun main() {
    val t1 = Time()
    println("Объект по умолчанию: " + t1.info())
    val t2 = Time(1, 5, 30)
    println("Объект с константами: " + t2.info())
    println("Полных минут: " + t2.fullMinutes())
    t2.decreaseBy10Minutes()
    println("Время минус 10 минут: " + t2.info())
    t2.destroy()
    println()
    println("Введите время")
    print("Часы: ")
    val h = readln().toInt()
    print("Минуты: ")
    val m = readln().toInt()
    print("Секунды: ")
    val s = readln().toInt()
    val t3 = Time(h, m, s)
    println("Вы ввели: " + t3.info())
    println("Полных минут: " + t3.fullMinutes())
    t3.decreaseBy10Minutes()
    println("Время минус 10 минут: " + t3.info())
    t3.destroy()
}