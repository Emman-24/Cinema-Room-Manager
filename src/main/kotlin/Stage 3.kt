fun main() {
    println("Enter the number of rows:")
    val rows = readln().toInt()

    println("Enter the number of seats in each row:")
    val seats = readln().toInt()

    val cinema = MutableList(rows) { MutableList(seats) { 'S' } }

    print("\nCinema:\n  ")
    for (i in 1..seats) print("$i ")
    for (i in cinema.indices) print("\n${i + 1} ${cinema[i].joinToString(" ")}")
    println("\n")

    println("Enter a row number:")
    val rowNumber = readln().toInt()
    println("Enter a seat number in that row:")
    val seatNumber = readln().toInt()

    val cost = if (rows * seats <= 60) 10 else if (rowNumber > rows / 2) 8 else 10
    println("Ticket price: $$cost")

    cinema[rowNumber - 1][seatNumber - 1] = 'B'

    print("\nCinema:\n  ")
    for (i in 1..seats) print("$i ")
    for (i in cinema.indices) print("\n${i + 1} ${cinema[i].joinToString(" ")}")
    println("\n")
}