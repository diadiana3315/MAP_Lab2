package domain;

public class FirstClassTicket implements TicketType {
    @Override
    public void displayInfo() {
        System.out.println("This is a first-class ticket");
    }

}