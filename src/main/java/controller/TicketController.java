package controller;

import domain.Ticket;
import domain.strategyPattern.PaymentStrategy;
import repository.Repository;
import repository.TicketRepository;

import java.util.ArrayList;
import java.util.List;

public class TicketController {
    private Repository<Ticket> ticketRepository;

    public TicketController(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public void saveTicket(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    public void removeTicket(int ticketId) {
        List<Ticket> tickets = ticketRepository.getAll();
        List<Ticket> ticketsToRemove = new ArrayList<>();
        for (Ticket ticket : tickets) {
            if (ticket.getTicketId() == ticketId) {
                ticketsToRemove.add(ticket);
            }
        }
        for (Ticket ticket : ticketsToRemove) {
            ticketRepository.remove(ticket);
        }
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.getAll();
    }

    public void createTicket(Ticket ticket, PaymentStrategy paymentStrategy) {
        saveTicket(ticket);
        ticket.processPayment(paymentStrategy);
    }

}

