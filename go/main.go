package main

import "fmt"

func main() {
	var conferenceName = "Go Conference"
	const conferenceTickets = 50
	var remainingTickets = 50

	fmt.Printf("Welcome to our %v booking application\n", conferenceName)
	fmt.Printf("We have total of %v tickets and %v are still available\n", remainingTickets, conferenceTickets)
	fmt.Println("Get your tickets here to attend")

	var userName string
	var userTickets int
	//ask user for his name

	userName = "Tom"
	fmt.Printf("User %v booked %v tickets.\n", userName, userTickets)
}
