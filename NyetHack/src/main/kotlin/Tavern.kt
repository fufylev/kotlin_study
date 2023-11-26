import java.io.File

private const val TAVERN_MASTER = "Taernyl"
private const val TAVERN_NAME = "$TAVERN_MASTER's Folly"

private val firstNames = setOf("Alex", "Mordoc", "Sophie", "Tariq")
private val lastNames = setOf("Ironfoot", "Fernsworth", "Baggins", "Downstrider")

fun visitTavern() {
    narrate("$heroName enters $TAVERN_NAME\n")
    narrate("There are several items for sale:")
    List(menuItems.size) { index ->
        val (name, price) = menuItems[index].split(",")
        val longest = longestMenu(menuItems)
        val dots: String =
            ".".repeat(if (menuItems[index].length == longest) 5 else longest + 5 - menuItems[index].length)
        val str = "$name$dots$price"
        narrate(str)
    }

    val patrons: MutableSet<String> = mutableSetOf()
    val patronGold = mutableMapOf(
        TAVERN_MASTER to 86.00,
        heroName to 4.50
    )

    println(patronGold)

    while (patrons.size < 10) {
        patrons += "${firstNames.random()} ${lastNames.random()}"
    }

    narrate("\n$heroName sees several patrons in the tavern:")
    narrate(patrons.joinToString())
    println(patronGold)
    repeat(3) {
        placeOrder(patrons.random(), menuItems.random(), patronGold)
    }
    println(patronGold)

}


private fun placeOrder(
    patronName: String,
    menuItemName: String,
    patronGold: MutableMap<String, Double>
) {
    val itemPrice = 1.0
    narrate("$patronName speaks with $TAVERN_MASTER to place an order")
    if (itemPrice <= patronGold.getOrDefault(patronName, 0.0)) {
        narrate("$TAVERN_MASTER hands $patronName a $menuItemName")
        narrate("$patronName pays $TAVERN_MASTER $itemPrice gold")
        patronGold[patronName] = patronGold.getValue(patronName) - itemPrice
        patronGold[TAVERN_MASTER] = patronGold.getValue(TAVERN_MASTER) + itemPrice
    } else {
        narrate("$TAVERN_MASTER says, \"You need more coin for a $menuItemName\"")
    }
}

private val menuData = File("data/tavern-menu-data.txt")
    .readText()
    .split("\n")

private val menuItems = List(menuData.size) { index ->
    val (_, name, price) = menuData[index].split(",")
    "$name,$price"
}

private fun longestMenu(str: List<String>): Int {
    var longest: Int = 0;
    for (item in str) {
        if (item.length > longest) longest = item.length
    }
    return longest;
}

private val menuItemPrices: Map<String, Double> = List(menuData.size) { index ->
    val (_, name, price) = menuData[index].split(",")
    name to price.toDouble()
}.toMap()