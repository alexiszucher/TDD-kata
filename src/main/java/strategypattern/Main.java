package strategypattern;

public class Main {
    public static void main(String... args) {
        Order orderWithPaypal = new Order(new PaypalPaymentStrategy("toto@gmail.com", "123"));
        Order orderWithCreditCard = new Order(new CreditCardPaymentStrategy("2837 8344 2843 2934"));

        orderWithPaypal.pay();
        orderWithCreditCard.pay();
    }
}
