package subtask3

class BillCounter {

    // TODO: Complete the following function
    // The output could be "Bon Appetite" or the string with number(e.g "10")
    fun checkBrain() {

    }
    fun calculateFairlySplit(bill: IntArray, k: Int, b: Int): String {
        val commonBillPart = bill.reduce {sum, el -> sum + el} - bill[k];
        val fairCount =   b - commonBillPart / 2
        print(b)
        print(fairCount)
        return if (fairCount <= 0)
            "Bon Appetit"
        else
            (fairCount).toString()
    }
}
