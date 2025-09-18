package strategypattern;

public class Order {
    private final PaymentStrategy paymentStrategy;

    public Order(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void pay() {
        this.paymentStrategy.pay();
    }
}
