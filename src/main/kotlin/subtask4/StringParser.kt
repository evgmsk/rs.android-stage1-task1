package subtask4

import sun.security.ec.point.ProjectivePoint

class StringParser {

    fun getResult(inputString: String): Array<String> {
        val brackets = mutableListOf<IndexedValue<Char>>()
        fun defineOpen(c: Char): Char {
            return when (c) {
                '>' -> '<'
                ')' -> '('
                ']' -> '['
                else -> '_'
            }
        }
        fun isOpenBr(c: Char): Boolean {
            return c == '<' || c == '(' || c == '['
        }
        fun isCloseBr(c: Char): Boolean {
            return c == '>' || c == ')' || c == ']'
        }
        val bracketsOnly = inputString.withIndex().filter { isOpenBr(it.value) || isCloseBr(it.value) }
        val openBrackets = bracketsOnly.filter { isOpenBr(it.value) }
        val result = Array<String>(openBrackets.size) {_ -> "_"}

        for (l in bracketsOnly) {
            when {
                isOpenBr(l.value) -> {
                    brackets.add(brackets.size, l)
                }
                isCloseBr(l.value) -> {
                    val lastInd = brackets.indexOfLast {it.value == defineOpen(l.value)}
                    val start = brackets.removeAt(lastInd)
                    val startInt = start.index + 1
                    val endInt = l.index - 1
                    val index = openBrackets.indexOfFirst { it.index == start.index }
                    result[index] = inputString.slice(startInt..endInt)
                }
            }
        }
        return result
    }
}
