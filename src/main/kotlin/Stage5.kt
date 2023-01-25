private var purchasedTickets = 0
private var currentIncome = 0
var totalIncome = 0


fun main() {
    println("Enter the number of rows:")
    val rows = readln().toInt()
    println("Enter the number of seats in each row:")
    val seats = readln().toInt()
    val cinema = MutableList(rows) { MutableList(seats) { 'S' } }

    do {
        val action = chooseAction()
        when (action) {
            "1" -> showSeats(seats, cinema)
            "2" -> buyTicket(rows, seats, cinema)
            "3" -> statistics(rows, seats)
        }
    } while (action != "0")

}

fun statistics(rows: Int, seats: Int) {
    val ticketsPercentage = purchasedTickets * 100 / (rows * seats).toDouble()
    val formatPercentage = "%.2f".format(ticketsPercentage)
    println("Number of purchased tickets: $purchasedTickets")
    println("Percentage: ${formatPercentage}%")
    println("Current income: $${currentIncome}")

    totalIncome = if (rows * seats <= 60) {
        rows * seats * 10
    } else {
        if (rows % 2 == 0) {
            (rows / 2 * seats) * 10 + (rows / 2 * seats) * 8
        } else {
            (rows / 2 * seats) * 10 + ((rows - seats / 2) * seats) * 8
        }
    }
    println("Total income: $${totalIncome}")
    println("")


}

fun showSeats(seats: Int, cinema: MutableList<MutableList<Char>>) {
    print("\nCinema:\n  ")
    for (i in 1..seats) print("$i ")
    for (i in cinema.indices) print("\n${i + 1} ${cinema[i].joinToString(" ")}")
    println("\n")
}

fun buyTicket(rows: Int, seats: Int, cinema: MutableList<MutableList<Char>>) {
    println("Enter a row number:")
    val rowNumber = readln().toInt()
    println("Enter a seat number in that row:")
    val seatNumber = readln().toInt()

    if (rowNumber > rows) {
        println("Wrong input!")
        return buyTicket(rows, seats, cinema)
    }
    if (seatNumber > seats) {
        println("Wrong input!")
        return buyTicket(rows, seats, cinema)
    }
    if (cinema[rowNumber - 1][seatNumber - 1] == 'B') {
        println("That ticket has already been purchased!")
        return buyTicket(rows, seats, cinema)

    } else {
        val cost = if (rows * seats <= 60) 10 else if (rowNumber > rows / 2) 8 else 10
        cinema[rowNumber - 1][seatNumber - 1] = 'B'
        purchasedTickets++
        currentIncome+=cost
        println("Ticket price: $$cost")
    }

}

fun chooseAction(): String {
    println(
        "1. Show the seats\n" +
                "2. Buy a ticket\n" +
                "3. Statistics\n" +
                "0. Exit"
    )
    return readln()
}
