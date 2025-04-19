

### **Vorher: Lange if-else- oder switch-Anweisung**

```java
public class PaymentService {
    public void pay(String paymentType, double amount) {
        if ("CREDIT_CARD".equals(paymentType)) {
            System.out.println("Paying " + amount + " by credit card");
        } else if ("PAYPAL".equals(paymentType)) {
            System.out.println("Paying " + amount + " via PayPal");
        } else if ("BANK_TRANSFER".equals(paymentType)) {
            System.out.println("Paying " + amount + " by bank transfer");
        } else {
            throw new IllegalArgumentException("Unknown payment type");
        }
    }
}
```

---

### **Nachher: Strategy Pattern**

#### 1. **Strategy Interface**

```java
public interface PaymentStrategy {
    void pay(double amount);
}
```

#### 2. **Konkrete Strategien**

```java
public class CreditCardPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paying " + amount + " by credit card");
    }
}

public class PaypalPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paying " + amount + " via PayPal");
    }
}

public class BankTransferPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paying " + amount + " by bank transfer");
    }
}
```

#### 3. **Nutzung der Strategie im Service**

```java
public class PaymentService {
    private PaymentStrategy paymentStrategy;

    public PaymentService(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void pay(double amount) {
        paymentStrategy.pay(amount);
    }
}
```

#### 4. **Verwendung**

```java
public class Main {
    public static void main(String[] args) {
        PaymentService creditCardService = new PaymentService(new CreditCardPayment());
        creditCardService.pay(100.0);

        PaymentService paypalService = new PaymentService(new PaypalPayment());
        paypalService.pay(200.0);

        PaymentService bankTransferService = new PaymentService(new BankTransferPayment());
        bankTransferService.pay(300.0);
    }
}
```

---

**Vorteile:**
- Erweitern um neue Zahlungsarten ohne Änderung am bestehenden Code
- Offen für Erweiterung, geschlossen für Modifikation (Open/Closed Principle)
- Bessere Testbarkeit und Entkopplung [[1]](https://poe.com/citation?message_id=379255527691&citation=1).

---

**Quelle:**  
Das Beispiel orientiert sich an klassischen Refactoring- und Entwurfsmuster-Prinzipien, wie sie auch im Scrum- und Clean-Code-Kontext empfohlen werden [[1]](https://poe.com/citation?message_id=379255527691&citation=1).