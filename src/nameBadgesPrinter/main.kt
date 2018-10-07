package nameBadgesPrinter

import java.util.*

fun main(args: Array<String>) {

    val scanner = Scanner(System.`in`)

    print("Enter name and surname: ")

    val name = scanner.next()
    val surname = scanner.next()

    val badgeMain = "* $name $surname *"
    val badgeBorder = "*".repeat(badgeMain.length)

    println(badgeBorder)
    println(badgeMain)
    println(badgeBorder)
}