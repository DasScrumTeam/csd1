public class OrderService {
    private final Payment payment;

    public OrderService(Payment payment) {
        this.payment = payment;
    }

    public void processOrder(Order order) {
        // ... andere Logik
        payment.pay(order.getTotal());
    }
}

public interface Payment {
    void pay(double amount);
}

public class PaymentService implements Payment {
    public void pay(double amount) {
        // Implementierung
    }
}