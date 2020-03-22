package subtask2

class MiniMaxSum {

    fun getResult(input: IntArray): IntArray {
        val sum = input.reduce {sum, el  -> sum + el}
        return listOf(sum - input?.max()!!, sum - input?.min()!!).toIntArray()
    }
}
