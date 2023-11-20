package domain;

public class TicketFactory {
    public static TicketType createTicket(String type) {
        if (type.equals("First-class"))
            return new FirstClassTicket();

        if (type.equals("Second-class"))
            return new SecondClassTicket();
        return null;
    }
}
