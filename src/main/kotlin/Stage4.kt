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
        }
    } while (action != "0")

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
    val cost = if (rows * seats <= 60) 10 else if (rowNumber > rows / 2) 8 else 10
    println("Ticket price: $$cost")
    cinema[rowNumber - 1][seatNumber - 1] = 'B'
}

fun chooseAction(): String {
    println(
        "1. Show the seats\n" +
                "2. Buy a ticket\n" +
                "0. Exit"
    )
    return readln()
}
