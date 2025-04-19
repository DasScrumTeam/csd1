## 1. **Ausgangssituation: Monolithische Klasse**

Angenommen, du hast eine Service-Klasse, die Geschäftslogik, Datenbankzugriff und externe Schnittstellen mischt:

```java
public class OrderService {
    private final DataSource dataSource;

    public OrderService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void placeOrder(Order order) {
        // Geschäftslogik
        if(order.getTotal() > 1000) {
            order.setDiscount(0.1);
        }
        // Datenbankzugriff
        try(Connection conn = dataSource.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO orders ...");
            // ...
            stmt.executeUpdate();
        } catch(SQLException e) {
            // ...
        }
        // Benachrichtigung per E-Mail
        EmailSender.send(order.getCustomerEmail(), "Ihre Bestellung wurde aufgenommen");
    }
}
```

Hier sind Logik, Persistenz und externe Kommunikation eng gekoppelt.

---

## 2. **Vorgehensweise beim Refactoring zur hexagonalen Architektur**

### **Schritt 1: Identifiziere Kernlogik und externe Abhängigkeiten**

- **Kernlogik**: Rabattberechnung, Statusänderungen etc.
- **Extern**: Datenhaltung (DB), E-Mail-Versand.

---

### **Schritt 2: Definiere Ports (Interfaces) für externe Abhängigkeiten**

```java
public interface OrderRepository {
    void save(Order order);
}

public interface NotificationService {
    void notifyCustomer(String email, String message);
}
```
Diese Ports abstrahieren die Infrastruktur. Die Geschäftslogik kennt nur die Interfaces, nicht die Implementierung [[1]](https://poe.com/citation?message_id=379257848075&citation=1).

---

### **Schritt 3: Extrahiere die Business-Logik in die "Application"-Schicht**

```java
public class OrderService {
    private final OrderRepository orderRepository;
    private final NotificationService notificationService;

    public OrderService(OrderRepository orderRepository, NotificationService notificationService) {
        this.orderRepository = orderRepository;
        this.notificationService = notificationService;
    }

    public void placeOrder(Order order) {
        if(order.getTotal() > 1000) {
            order.setDiscount(0.1);
        }
        orderRepository.save(order);
        notificationService.notifyCustomer(order.getCustomerEmail(), "Ihre Bestellung wurde aufgenommen");
    }
}
```

Jetzt ist die Anwendungsschicht (Innen) unabhängig von Infrastrukturdetails [[1]](https://poe.com/citation?message_id=379257848075&citation=1)[[2]](https://poe.com/citation?message_id=379257848075&citation=2).

---

### **Schritt 4: Implementiere die Adapter („Outside“) für konkrete Infrastruktur**

```java
public class JdbcOrderRepository implements OrderRepository {
    private final DataSource dataSource;

    public JdbcOrderRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void save(Order order) {
        // Implementiere Datenbankzugriff wie zuvor
    }
}

public class EmailNotificationService implements NotificationService {
    @Override
    public void notifyCustomer(String email, String message) {
        EmailSender.send(email, message);
    }
}
```

Diese Adapter implementieren die Ports und sind beliebig austauschbar [[1]](https://poe.com/citation?message_id=379257848075&citation=1).

---

### **Schritt 5: Anwendung verdrahten**

```java
DataSource ds = ...;
OrderRepository repo = new JdbcOrderRepository(ds);
NotificationService notif = new EmailNotificationService();

OrderService orderService = new OrderService(repo, notif);
```

---

## **Vorteile und Begründung der Vorgehensweise**

- **Klare Trennung von Domänenlogik und Technik**: Die Kernlogik ist isoliert testbar, unabhängig von Datenbank oder Netzwerk [[1]](https://poe.com/citation?message_id=379257848075&citation=1).
- **Leichtere Testbarkeit**: Für Unit- und Integrationstests können Mocks oder alternative Adapter verwendet werden.
- **Erweiterbarkeit**: Neue Adapter (z.B. REST, Messaging) können hinzugefügt werden, ohne die Kernlogik zu ändern.
- **Agile Architektur**: Schrittweise, in kleinen Refactoring-Einheiten, kann die Struktur verbessert werden, ohne das Verhalten zu ändern („Refactoring in kleinen Schritten“, siehe auch [[4]](https://poe.com/citation?message_id=379257848075&citation=4)) [[1]](https://poe.com/citation?message_id=379257848075&citation=1)[[2]](https://poe.com/citation?message_id=379257848075&citation=2)[[4]](https://poe.com/citation?message_id=379257848075&citation=4).

---

**Zusammenfassung:**  
Durch das Refactoring etablierst du eine hexagonale Architektur, indem du externe Abhängigkeiten abstrahierst (Ports), die Geschäftslogik in eine unabhängige Applikationsschicht verschiebst und konkrete Adapter für die Infrastruktur implementierst. Dies verbessert Wartbarkeit, Testbarkeit und Flexibilität des Systems entscheidend [[1]](https://poe.com/citation?message_id=379257848075&citation=1)[[2]](https://poe.com/citation?message_id=379257848075&citation=2)[[4]](https://poe.com/citation?message_id=379257848075&citation=4).

