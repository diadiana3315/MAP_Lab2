package domain.strategyPattern;

public class CreditCardPayment implements PaymentStrategy{
    private String cardNumber;
    private String expiryDate;


    public CreditCardPayment(String cardNumber, String expiryDate) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
    }


    @Override
    public void pay(double amount) {
        System.out.println(amount + " paid via credit card (" + cardNumber.substring(12) + ")");
    }
}
