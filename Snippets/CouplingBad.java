public class OrderService {
    private PaymentService paymentService = new PaymentService();

    public void processOrder(Order order) {
        paymentService.pay(order.getTotal());
    }
}