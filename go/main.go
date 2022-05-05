package main

import (
	"fmt"
	"strings"
)

func main() {
	conferenceName := "Go Conference"
	const conferenceTickets = 50
	remainingTickets := 50

	fmt.Printf("Welcome to our %v booking application\n", conferenceName)
	fmt.Printf("We have total of %v tickets and %v are still available\n", remainingTickets, conferenceTickets)
	fmt.Println("Get your tickets here to attend")

	var bookings []string

	for {

		var firstName string
		var lastName string
		var email string
		var userTickets int

		fmt.Print("Enter your first name: ")
		fmt.Scan(&firstName)
		fmt.Print("Enter your last name: ")
		fmt.Scan(&lastName)
		fmt.Print("Enter your email: ")
		fmt.Scan(&email)
		fmt.Print("Enter number of tickets: ")
		fmt.Scan(&userTickets)

		bookings = append(bookings, firstName+" "+lastName)
		fmt.Printf("Bookings: %v\n", bookings)
		fmt.Printf("The first element: %v\n", bookings[0])

		printBookingFirstNames(bookings)

		fmt.Printf("Thank you %v %v for booking %v tickets.\n", firstName, lastName, userTickets)
		remainingTickets = remainingTickets - userTickets
		fmt.Printf("We have a total of %v tickets and %v are still available\n", conferenceTickets, remainingTickets)

	}

}

func printBookingFirstNames(bookings []string) {
	firstNames := []string{}
	for _, booking := range bookings {
		names := strings.Fields(booking)
		firstNames = append(firstNames, names[0])
	}
	fmt.Printf("Booking first names: %v\n", firstNames)
}
