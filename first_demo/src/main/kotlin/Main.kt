const val HERO_NAME = "Nogartse"
var playerLevel = 0

fun main(args: Array<String>) {
//    println("\t\"${obtainQuest(playerLevel)}\"")
//    println(
//        """
//        $HERO_NAME approaches the bounty board. It reads:
//        "${obtainQuest(playerLevel)}"
//        """.trimIndent().trimMargin()
//    )
//
//    println("$HERO_NAME announces her presence to the world.")
//    println("What level is $HERO_NAME?")
//    val input = readLine()
//    println("$HERO_NAME's level is $input.")
//    println(
//        """
//|$HERO_NAME approaches the bounty board. It reads:
//| "${obtainQuest(playerLevel).replace("Nogartse", "xxxxxxxx")}"
//""".trimMargin()
//    )
//    val omSymbol = '\u0950'
//    print(omSymbol)
//    val quest: String? = obtainQuest(playerLevel)
//    val censoredQuest: String? = quest?.replace("Nogartse", "xxxxxxxx")
//    if (censoredQuest != null) {
//        println(
//            """
//            |$HERO_NAME approaches the bounty board. It reads:
//            | "$censoredQuest"
//            """.trimMargin()
//        )
//    }
//    censoredQuest?.let {
//        println(
//            """
//            |$HERO_NAME approaches the bounty board. It reads:
//            | "$censoredQuest"
//            """.trimMargin()
//        )
//    }
//    val message: String = quest?.replace("Nogartse", "xxxxxxxx")
//        ?.let {
//            """
//            |$HERO_NAME approaches the bounty board. It reads:
//            | "$it"
//            """.trimMargin()
//        } ?: "$HERO_NAME approaches the bounty board, but it is blank."
//    println(message)
//    playerLevel = readlnOrNull()?.toIntOrNull() ?: 0
//    println("$HERO_NAME's level is $playerLevel")


    val message: String = try {
        val quest: String? = obtainQuest(playerLevel)
        quest?.replace("Nogartse", "xxxxxxxx")
            ?.let { censoredQuest ->
                """
                |$HERO_NAME approaches the bounty board. It reads:
                | "$censoredQuest"
                """.trimMargin()
            } ?: "$HERO_NAME approaches the bounty board, but it is blank."

    } catch (e: Exception) {
        "$HERO_NAME can't read what's on the bounty board."
    }
    println(message)
}

private fun obtainQuest(playerLevel: Int): String? {
//    if (playerLevel <= 0) {
//        throw IllegalArgumentException("The player's level must be at least 1.")
//    }
    require(playerLevel > 0) {
        "The player's level must be at least 1."
    }
    return when (playerLevel) {
        1 -> "Meet Mr. Bubbles in the land of soft things."
        6 -> "Locate the enchanted sword."
        7 -> "Recover the long-lost artifact of creation."
        8 -> "Defeat Nogartse, bringer of death and eater of worlds."
        else -> null
    }
}