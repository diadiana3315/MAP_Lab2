package domain;

import domain.strategyPattern.PaymentStrategy;

public class Ticket{
    private int ticketId;
    private Passenger passenger;
    private Flight flight;
    private double price;
    private PaymentStrategy paymentStrategy;

    public Ticket(int ticketId, Passenger passenger, Flight flight, double price) {
        this.ticketId = ticketId;
        this.passenger = passenger;
        this.flight = flight;
        this.price = price;
    }
    public int getTicketId() {
        return ticketId;
    }
    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }
    public Passenger getPassengerId() {
        return passenger;
    }
    public void setPassengerId(Passenger passengerId) {
        this.passenger = passengerId;
    }
    public Flight getFlight() {
        return flight;
    }
    public void setFlight(Flight flight) {
        this.flight = flight;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId=" + ticketId +
                ", passengerId=" + passenger +
                ", flightId=" + flight +
                ", price=" + price +
                '}';
    }


    public void processPayment (PaymentStrategy paymentStrategy) {
        paymentStrategy.pay(price);
    }

    // add method pay -> strategy pattern (by card/ paypal)
}