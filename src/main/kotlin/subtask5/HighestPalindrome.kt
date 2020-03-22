package subtask5

class HighestPalindrome {

    fun highestValuePalindrome(n: Int, k: Int, digitString: String): String {
        val medium = n / 2
        var firstPart = ""
        var changesRequired = 0
        for (i in 0 until medium) {
            val start = digitString[i]
            val end = digitString[digitString.length - 1 - i]
            if (changesRequired > k) {
                return "-1"
            }
            if (start != end) {
                changesRequired += 1
                firstPart += if (start.toInt() > end.toInt()) start else end
            } else {
                firstPart += digitString[i]
            }
        }
        if (k - changesRequired > 0) {
            var valMin = 9
            var indMin = 0
            for (i in 0 until medium) {
                if (firstPart[i].toString().toInt() < valMin) {
                    indMin = i
                    valMin = firstPart[i].toString().toInt()
                }
            }
            val newFirstPart = firstPart.toCharArray()
            newFirstPart[indMin] = '9'
            firstPart = String(newFirstPart)
        }
        val secondPart = if (n % 2 == 0) firstPart.reversed() else firstPart.slice(0 until medium).reversed()
        return "$firstPart$secondPart"
    }
}
