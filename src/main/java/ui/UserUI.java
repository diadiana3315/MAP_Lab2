package ui;

import controller.TicketController;
import domain.*;
import domain.strategyPattern.CreditCardPayment;
import domain.strategyPattern.PayPalPayment;
import domain.strategyPattern.PaymentStrategy;

import java.sql.SQLException;
import java.util.Scanner;

public class UserUI {

    TicketController ticketController;

    public UserUI(TicketController ticketController) {
        this.ticketController = ticketController;
    }

    public void handleTicketOperations() throws SQLException {

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
                    System.out.println("Enter flight details:");
                    System.out.print("Flight ID: ");
                    int flightId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Airline: ");
                    String airline = scanner.nextLine();
                    System.out.print("Departure Time: ");
                    String departureTime = scanner.nextLine();
                    System.out.print("Arrival Time: ");
                    String arrivalTime = scanner.nextLine();
                    Flight flight = new Flight(flightId, airline, departureTime, arrivalTime);

                    System.out.println("Enter passenger details:");
                    System.out.print("First Name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Last Name: ");
                    String lastName = scanner.next();
                    System.out.print("Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Gender: ");
                    String gender = scanner.nextLine();
                    System.out.print("Passenger ID: ");
                    int passengerId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Passport Number: ");
                    int passportNumber = scanner.nextInt();
                    scanner.nextLine();
                    Passenger passenger = new Passenger(firstName, lastName, age, gender, passengerId, passportNumber);

                    System.out.println("Enter ticket details:");
                    System.out.print("Ticket ID: ");
                    ticketId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();
                    Ticket newTicket = new Ticket(ticketId, passenger, flight, price);

                    System.out.println("Enter class of the ticket:");
                    String ticketType = scanner.nextLine();
                    TicketType ticket = TicketFactory.createTicket(ticketType);
                    ticket.displayInfo();


                    System.out.println("Select payment method:");
                    System.out.println("1. Credit Card");
                    System.out.println("2. PayPal");
                    int paymentOption = scanner.nextInt();
                    PaymentStrategy paymentStrategy = null;

                    switch (paymentOption) {
                        case 1:
                            System.out.print("Enter Credit Card Number: ");
                            String cardNumber = scanner.next();
                            System.out.print("Enter Expiry Date: ");
                            String expiryDate = scanner.next();
                            paymentStrategy = new CreditCardPayment(cardNumber, expiryDate);
                            break;
                        case 2:
                            System.out.print("Enter PayPal Email: ");
                            String email = scanner.next();
                            paymentStrategy = new PayPalPayment(email);
                            break;
                        default:
                            System.out.println("Invalid payment option");
                            break;
                    }

                    if (paymentStrategy != null) {
                        ticketController.createTicket(newTicket, paymentStrategy);
                    } else {
                        System.out.println("Ticket creation canceled due to invalid payment option.");
                    }
                    break;

                case 2:
                    ticketId = scanner.nextInt();
                    ticketController.removeTicket(ticketId);
                    break;
                case 3:
                    ticketController.getAllTickets();
                    break;
                case 0:
                    exit = false;
            }
        }
    }
}
