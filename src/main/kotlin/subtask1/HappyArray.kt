package subtask1

class HappyArray {
    fun convertToHappy(sadArray: IntArray): IntArray {
        fun checkArray(arr: IntArray): IntArray {
            val newList = arr.filterIndexed { index, a ->
                if (index > 0 && index < arr.size - 1)
                    a < arr[index - 1] + arr[index + 1]
                else
                    true

            }
            return if (newList.size == arr.size)
                        newList.toIntArray()
                    else
                        checkArray(newList.toIntArray())
        }
        return checkArray(sadArray)
    }
}
