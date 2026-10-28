// Задание 11.7, вариант 5 базовый уровень
import java.time.Year
open class Textbook(
    val title: String,
    val pages: Int,
    val price: Double
) {
    open fun quality(): Double = price / pages

    open fun info(): String =
        "Учебник: \"$title\", страниц: $pages, цена: %.2f, Q = %.4f".format(price, quality())
}
class DatedTextbook(
    title: String,
    pages: Int,
    price: Double,
    val year: Int
) : Textbook(title, pages, price) {
    override fun quality(): Double {
        val t = Year.now().value
        return super.quality() - 0.2 * (t - year)
    }
    override fun info(): String =
        "Учебник: \"$title\", страниц: $pages, цена: %.2f, год издания: $year, Qp = %.4f"
            .format(price, quality())
}
private fun readInt(prompt: String): Int {
    while (true) {
        print(prompt)
        readlnOrNull()?.trim()?.toIntOrNull()?.takeIf { it > 0 }?.let { return it }
        println("Введите положительное целое число")
    }
}
private fun readDouble(prompt: String): Double {
    while (true) {
        print(prompt)
        readlnOrNull()?.trim()?.replace(',', '.')?.toDoubleOrNull()?.takeIf { it >= 0 }?.let { return it }
        println("Введите неотрицательное число")
    }
}
fun main() {
    println("=== Объект класса 1-го уровня ===")
    print("Название: ")
    val title1 = readlnOrNull().orEmpty()
    val book1 = Textbook(title1, readInt("Количество страниц: "), readDouble("Цена: "))
    println(book1.info())
    println()
    println("=== Объект класса 2-го уровня ===")
    print("Название: ")
    val title2 = readlnOrNull().orEmpty()
    val book2 = DatedTextbook(
        title2,
        readInt("Количество страниц: "),
        readDouble("Цена: "),
        readInt("Год издания: ")
    )
    println(book2.info())
}