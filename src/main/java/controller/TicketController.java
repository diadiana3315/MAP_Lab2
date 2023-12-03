package controller;

import domain.Ticket;
import domain.strategyPattern.PaymentStrategy;
import repository.TicketRepository;

import java.sql.SQLException;
import java.util.List;

public class TicketController {
    private TicketRepository ticketRepository;

    public TicketController(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public void saveTicket(Ticket ticket) throws SQLException {
        ticketRepository.addTicket(ticket);
    }

    public void removeTicket(int ticketId) throws SQLException {
        ticketRepository.deleteTicket(ticketId);
    }

    public void getAllTickets() throws SQLException {
        ticketRepository.viewTickets();
    }

    public void createTicket(Ticket ticket, PaymentStrategy paymentStrategy) throws SQLException {
        saveTicket(ticket);
        ticket.processPayment(paymentStrategy);
    }
}
