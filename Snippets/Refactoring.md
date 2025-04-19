Hier sind typische Beispiele für Refactorings in Java sowie zwei konkrete Beispiele für das Refactoring von Tests:

---

### 1. **Extract Method (Methode extrahieren)**

**Vorher:**
```java
public void printOwing() {
    printBanner();
    // Details ausgeben
    System.out.println("Name: " + name);
    System.out.println("Amount: " + getOutstanding());
}
```

**Nachher:**
```java
public void printOwing() {
    printBanner();
    printDetails();
}

private void printDetails() {
    System.out.println("Name: " + name);
    System.out.println("Amount: " + getOutstanding());
}
```
*Vorteil: Bessere Lesbarkeit und Wiederverwendbarkeit* [[1]](https://poe.com/citation?message_id=379251327243&citation=1).

---

### 2. **Rename Variable (Variable umbenennen)**

**Vorher:**
```java
double d;
d = order.getAmount();
```

**Nachher:**
```java
double outstandingAmount;
outstandingAmount = order.getAmount();
```
*Vorteil: Klarheit über die Bedeutung der Variable* [[1]](https://poe.com/citation?message_id=379251327243&citation=1)[[6]](https://poe.com/citation?message_id=379251327243&citation=6).

---

### 3. **Replace Magic Number with Constant (Magische Zahl durch Konstante ersetzen)**

**Vorher:**
```java
if (order.getStatus() == 3) {
    // Bestellung abgeschlossen
}
```

**Nachher:**
```java
private static final int STATUS_COMPLETE = 3;

if (order.getStatus() == STATUS_COMPLETE) {
    // Bestellung abgeschlossen
}
```
*Vorteil: Verständlichkeit und Wartbarkeit verbessert* [[1]](https://poe.com/citation?message_id=379251327243&citation=1).

---

### 4. **Introduce Interface (Interface einführen, zur Reduktion von Kopplung)**

**Vorher:**
```java
public class PaymentService {
    // ...
}
public class OrderService {
    private PaymentService paymentService = new PaymentService();
}
```

**Nachher:**
```java
public interface Payment {
    void pay(double amount);
}
public class PaymentService implements Payment {
    public void pay(double amount) { /* ... */ }
}
public class OrderService {
    private Payment payment;
    public OrderService(Payment payment) {
        this.payment = payment;
    }
}
```
*Vorteil: Flexible Austauschbarkeit, geringere Kopplung* [[1]](https://poe.com/citation?message_id=379251327243&citation=1).

---

### 5. **Split Large Class (Große Klasse aufteilen, für bessere Kohäsion)**

**Vorher:**
```java
public class UserManager {
    public void addUser(User user) { ... }
    public void deleteUser(User user) { ... }
    public void sendEmail(User user, String message) { ... }
    public void generateReport() { ... }
}
```

**Nachher:**
```java
public class UserManager {
    public void addUser(User user) { ... }
    public void deleteUser(User user) { ... }
}
public class EmailService {
    public void sendEmail(User user, String message) { ... }
}
public class ReportGenerator {
    public void generateReport() { ... }
}
```
*Vorteil: Klare Verantwortlichkeiten, höhere Kohäsion* [[1]](https://poe.com/citation?message_id=379251327243&citation=1).

---

## **Refactoring von Tests**

### 6. **Fixture Setup vereinfachen**

**Vorher:**
```java
@Test
public void testOrderTotal() {
    Order order = new Order();
    order.addItem(new Item("Book", 10));
    order.addItem(new Item("Pen", 2));
    assertEquals(12, order.getTotal());
}
```

**Nachher:**
```java
private Order order;

@Before
public void setUp() {
    order = new Order();
    order.addItem(new Item("Book", 10));
    order.addItem(new Item("Pen", 2));
}

@Test
public void testOrderTotal() {
    assertEquals(12, order.getTotal());
}
```
*Vorteil: Wiederverwendbarkeit, Lesbarkeit, reduzierter doppelter Code* [[1]](https://poe.com/citation?message_id=379251327243&citation=1).

---

### 7. **Mehrere Assertions auf einzelne Tests aufteilen**

**Vorher:**
```java
@Test
public void testUser() {
    User user = new User("Max");
    assertEquals("Max", user.getName());
    assertTrue(user.isActive());
}
```

**Nachher:**
```java
@Test
public void testUserName() {
    User user = new User("Max");
    assertEquals("Max", user.getName());
}

@Test
public void testUserIsActive() {
    User user = new User("Max");
    assertTrue(user.isActive());
}
```
*Vorteil: Fehlerursachen werden klarer, gezieltere Fehlersuche und bessere Teststruktur* [[1]](https://poe.com/citation?message_id=379251327243&citation=1)[[2]](https://poe.com/citation?message_id=379251327243&citation=2).

---

Diese Refactorings und Test-Refactorings verbessern Lesbarkeit, Wartbarkeit, Testbarkeit und die Architektur deines Codes – zentrale Ziele im agilen Umfeld und im TDD-Zyklus [[1]](https://poe.com/citation?message_id=379251327243&citation=1)[[2]](https://poe.com/citation?message_id=379251327243&citation=2)[[6]](https://poe.com/citation?message_id=379251327243&citation=6).