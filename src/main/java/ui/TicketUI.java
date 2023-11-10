package ui;

import controller.TicketController;
import domain.Flight;
import domain.Passenger;
import domain.Ticket;
import domain.strategyPattern.CreditCardPayment;
import domain.strategyPattern.PayPalPayment;
import domain.strategyPattern.PaymentStrategy;

import java.util.Scanner;

public class TicketUI {
    private TicketController ticketController;

    public TicketUI(TicketController ticketController) {
        this.ticketController = ticketController;
    }

    public void handleTicketOperations(){

        int option;
        boolean exit = true;
        Scanner scanner = new Scanner(System.in);
        while (exit) {
            System.out.println("Select an option:\n");
            System.out.println("1. Buy a ticket\n");
            System.out.println("2. Remove a ticket\n");
            System.out.println("3. View all tickets\n");
            option = scanner.nextInt();
            int ticketId;
            switch (option) {
                case 1:
                    int flightId = scanner.nextInt();
                    scanner.nextLine();
                    String airline = scanner.nextLine();
                    String departureTime = scanner.nextLine();
                    String arrivalTime = scanner.nextLine();
                    Flight flight = new Flight(flightId, airline, departureTime, arrivalTime);

                    String firstName = scanner.nextLine();
                    String lastName = scanner.next();
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    String gender = scanner.nextLine();
                    int passengerId = scanner.nextInt();
                    scanner.nextLine();
                    int passportNumber = scanner.nextInt();
                    scanner.nextLine();
                    Passenger passenger = new Passenger(firstName, lastName, age, gender, passengerId, passportNumber);

                    ticketId = scanner.nextInt();
                    scanner.nextLine();
                    double price = scanner.nextDouble();
                    Ticket newTicket = new Ticket(ticketId, passenger, flight, price);

                    PaymentStrategy creditCardPayment = new CreditCardPayment("1234 5678 9012 3456", "12/23");
                    PaymentStrategy paypalPayment = new PayPalPayment("user@example.com");

                    ticketController.createTicket(newTicket, creditCardPayment);
                    break;
                case 2:
                    ticketId = scanner.nextInt();
                    ticketController.removeTicket(ticketId);
                    break;
                case 3:
                    System.out.println(ticketController.getAllTickets());
                    break;
                case 0:
                    exit = false;
            }
        }

    }
}
