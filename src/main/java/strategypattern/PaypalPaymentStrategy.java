package strategypattern;

public class PaypalPaymentStrategy implements PaymentStrategy {
    private final String email;
    private final String password;

    public PaypalPaymentStrategy(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public void pay() {
        System.out.println("Paiement en se connectant au compte paypal "+email+ " et "+password);
    }
}
