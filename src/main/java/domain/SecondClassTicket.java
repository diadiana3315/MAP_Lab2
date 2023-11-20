package domain;

public class SecondClassTicket implements TicketType{
    @Override
    public void displayInfo() {
        System.out.println("This is a second-class ticket");
    }
}
