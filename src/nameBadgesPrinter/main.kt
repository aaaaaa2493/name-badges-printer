package nameBadgesPrinter

import java.io.File
import java.util.*

fun getFont(path: String): Pair<Array<String>, Int> {
    val scanner = Scanner(File(path))
    val charset = Array(128) {""}
    val charHeight = scanner.nextInt()
    val charCount = scanner.nextInt()
    repeat(charCount) {_ ->
        val char = scanner.next()[0]
        scanner.nextLine()
        repeat(charHeight) {_ ->
            val line = scanner.nextLine()
            charset[char.toInt()] += line
        }
    }
    charset[' '.toInt()] = " ".repeat(charset['a'.toInt()].length)
    return Pair(charset, charHeight)
}

fun getText(fontName: String, text: String): Array<String> {
    val (font, fontSize) = getFont("fonts/$fontName.txt")
    val output = Array(fontSize) {""}
    for (ch in text) {
        val curChar = font[ch.toInt()]
        val charLength = curChar.length / fontSize
        for (row in 0 until fontSize) {
            output[row] += curChar.substring(row * charLength until (row+1) * charLength)
        }
    }
    return output
}

fun addAround(output: Array<String>, toLeft: String, toRight: String) {
    for (row in 0 until output.size) {
        output[row] = "$toLeft${output[row]}$toRight"
    }
}

fun fillWithSpaces(output: Array<String>, length: Int) {
    val needSpaces = length - output[0].length
    if (needSpaces <= 0) return
    val leftSpaces = " ".repeat(needSpaces / 2)
    val rightSpaces = " ".repeat(needSpaces - leftSpaces.length)
    addAround(output, leftSpaces, rightSpaces)
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    print("Enter name and surname: ")
    val name = scanner.next()
    val surname = scanner.next()

    print("Enter person's status: ")
    scanner.nextLine()
    val status = scanner.nextLine()

    val textToShow = "$name $surname"
    val nameOutput = getText("roman", textToShow)
    val statusOutput = getText("medium", status)

    val topBottomBorder = "8"
    val leftRightBorder = "88"
    val leftRightBlank = "  "

    addAround(nameOutput, leftRightBlank, leftRightBlank)
    addAround(statusOutput, leftRightBlank, leftRightBlank)
    fillWithSpaces(statusOutput, nameOutput[0].length)
    fillWithSpaces(nameOutput, statusOutput[0].length)
    addAround(nameOutput, leftRightBorder, leftRightBorder)
    addAround(statusOutput, leftRightBorder, leftRightBorder)

    val badgeBorder = topBottomBorder.repeat(nameOutput[0].length)
    println(badgeBorder)
    nameOutput.forEach { println(it) }
    statusOutput.forEach { println(it) }
    println(badgeBorder)
}