package nameBadgesPrinter

import java.util.*

fun main(args: Array<String>) {

    val scanner = Scanner(System.`in`)

    val a = "____" +
            "|__|" +
            "|  |"

    val b = "___ " +
            "|__]" +
            "|__]"

    val c = "____" +
            "|   " +
            "|___"

    val d = "___ " +
            "|  \\" +
            "|__/"

    val e = "____" +
            "|___" +
            "|___"

    val f = "____" +
            "|___" +
            "|   "

    val g = "____" +
            "| __" +
            "|__]"

    val h = "_  _" +
            "|__|" +
            "|  |"

    val i = "_" +
            "|" +
            "|"

    val j = " _" +
            " |" +
            "_|"

    val k = "_  _" +
            "|_/ " +
            "| \\_"

    val l = "_   " +
            "|   " +
            "|___"

    val m = "_  _" +
            "|\\/|" +
            "|  |"

    val n = "_  _" +
            "|\\ |" +
            "| \\|"

    val o = "____" +
            "|  |" +
            "|__|"

    val p = "___ " +
            "|__]" +
            "|   "

    val q = "____" +
            "|  |" +
            "|_\\|"

    val r = "____" +
            "|__/" +
            "|  \\"

    val s = "____" +
            "[__ " +
            "___]"

    val t = "___" +
            " | " +
            " | "

    val u = "_  _" +
            "|  |" +
            "|__|"

    val v = "_  _" +
            "|  |" +
            " \\/ "

    val w = "_ _ _" +
            "| | |" +
            "|_|_|"

    val x = "_  _" +
            " \\/ " +
            "_/\\_"

    val y = "_   _" +
            " \\_/ " +
            "  |  "

    val z = "___ " +
            "  / " +
            " /__"

    val space = "    " +
                "    " +
                "    "

    val alphabet = arrayOf(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, space)
    val alphabetSize = 3
    val output = Array(alphabetSize) {""}

    print("Enter name and surname: ")

    val name = scanner.next()
    val surname = scanner.next()

    print("Enter person's status: ")
    scanner.nextLine()
    val status = scanner.nextLine()

    val textToShow = "$name $surname".toLowerCase()

    for ((index, ch) in textToShow.withIndex()) {
        val curChar = if (ch == ' ') alphabet.last() else alphabet[ch - 'a']
        val charLength = curChar.length / alphabetSize
        for (row in 0 until alphabetSize) {
            val partOfChar = curChar.subSequence(row * charLength until (row+1) * charLength).toString()
            output[row] += partOfChar
            if (index != textToShow.lastIndex) {
                output[row] += " "
            }
        }
    }

    for (row in 0 until alphabetSize) {
        output[row] = "*  " + output[row] + "  *"
    }

    val badgeLength = output[0].length

    val badgeLengthWithoutBorders = badgeLength - 2
    val needSpaces = badgeLengthWithoutBorders - status.length
    val leftSpaces: Int = needSpaces / 2
    val rightSpaces: Int = needSpaces - leftSpaces

    val infoRow = "*${" ".repeat(leftSpaces)}$status${" ".repeat(rightSpaces)}*"

    val badgeBorder = "*".repeat(badgeLength)

    println(badgeBorder)
    for (row in 0 until alphabetSize) {
        println(output[row])
    }
    println(infoRow)
    println(badgeBorder)
}