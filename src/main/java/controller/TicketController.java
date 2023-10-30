package controller;

import domain.Ticket;
import repository.Repository;

import java.util.List;

public class TicketController {
    private Repository<Ticket> ticketRepository;

    public TicketController(Repository<Ticket> ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public void saveTicket(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    public void removeTicket(Ticket ticket) {
        ticketRepository.remove(ticket);
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.getAll();
    }
}

