// Задание 11.5, вариант 5 средний уровень

private const val PREF_START_HOUR = 23
private const val PREF_END_HOUR = 7
class MobileSubscriber : Time {
    var surname: String
    var phone: String
    constructor(
        surname: String,
        phone: String,
        hours: Int,
        minutes: Int,
        seconds: Int
    ) : super(hours, minutes, seconds) {
        this.surname = surname
        this.phone = phone
    }
    fun isPreferential(): Boolean =
        hours >= PREF_START_HOUR || hours < PREF_END_HOUR
    override fun info(): String =
        "Абонент: $surname, телефон: $phone, время звонка: ${super.info()}, " +
            "льготное время: ${if (isPreferential()) "да" else "нет"}"
}
private fun readIntInRange(prompt: String, min: Int, max: Int): Int {
    while (true) {
        print(prompt)
        val v = readlnOrNull()?.trim()?.toIntOrNull()
        if (v != null && v in min..max) return v
        println("Введите целое число от $min до $max")
    }
}
fun main() {
    println("=== Класс-родитель (Время) ===")
    val h = readIntInRange("Часы (0-23): ", 0, 23)
    val m = readIntInRange("Минуты (0-59): ", 0, 59)
    val s = readIntInRange("Секунды (0-59): ", 0, 59)
    val t = Time(h, m, s)
    println(t.info())
    println()
    println("=== Класс-потомок (Абонент мобильной связи) ===")
    print("Фамилия: ")
    val surname = readlnOrNull().orEmpty().trim()
    print("Номер телефона: ")
    val phone = readlnOrNull().orEmpty().trim()
    val sh = readIntInRange("Часы звонка (0-23): ", 0, 23)
    val sm = readIntInRange("Минуты звонка (0-59): ", 0, 59)
    val ss = readIntInRange("Секунды звонка (0-59): ", 0, 59)
    val subscriber = MobileSubscriber(surname, phone, sh, sm, ss)
    println(subscriber.info())
}
