var heroName: String = ""
fun main() {
//    narrate(
//        "A hero enters the town of Kronstadt. What is their name?",
//        ::makeYellow
//    )
//
//    val heroName = readlnOrNull() ?: ""
//    changeNarratorMood()
    heroName = promptHeroName()
    narrate("$heroName, ${createTitle(heroName)}, heads to the town square")
    visitTavern()
}

private fun promptHeroName(): String {
    narrate("A hero enters the town of Kronstadt. What is their name?") { message ->
    // Выводит message желтым цветом
        "\u001b[33;1m$message\u001b[0m"
    }
    /*val input = readLine()
    require(input != null && input.isNotEmpty()) {
    "The hero must have a name."
    }
    return input*/
    println("Madrigal")
    return "Madrigal"
}
private fun makeYellow(message: String) = "\u001b[33;1m$message\u001b[0m"

private fun createTitle(name: String): String {
    return when {
        name.all { it.isDigit() } -> "The Identifiable"
        name.none { it.isLetter() } -> "The Witness Protection Member"
        name.count { it.lowercase() in "aeiou" } > 4 -> "The Master of Vowels"
        else -> "The Renowned Hero"
    }
}
