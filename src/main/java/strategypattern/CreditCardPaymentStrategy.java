package strategypattern;

public class CreditCardPaymentStrategy implements PaymentStrategy{
    private final String number;

    public CreditCardPaymentStrategy(String number) {
        this.number = number;
    }

    @Override
    public void pay() {
        System.out.println("Paiement par carte avec le numéro "+number);
    }
}
