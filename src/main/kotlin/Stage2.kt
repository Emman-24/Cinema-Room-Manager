fun main() {
    val price = 10

    println("Enter the number of rows:")
    val rows = readln().toInt()
    println("Enter the number of seats in each row:")
    val seats = readln().toInt()

    val totalSeats = rows * seats

    val profit = if (totalSeats <= 60) {
        totalSeats * price
    } else {
        val halfRows = rows / 2
        val restRows = rows - halfRows

        ((price * halfRows * seats) + (restRows * 8 * seats))

    }
    println("Total income:")
    println("$${profit}")

}