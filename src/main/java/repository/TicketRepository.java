package repository;

import domain.Ticket;

import java.util.ArrayList;
import java.util.List;

public class TicketRepository implements Repository<Ticket> {

    List<Ticket> tickets = new ArrayList<>();

    @Override
    public void save(Ticket ticket) {
        tickets.add(ticket);
    }

    @Override
    public void remove(Ticket ticket) {
        tickets.remove(ticket);
    }

    @Override
    public List<Ticket> getAll() {
        return tickets;
    }
}
