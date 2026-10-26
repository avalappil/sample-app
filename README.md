# Sample Spring Boot Order Application

Java 25 / Spring Boot 4.0.6 Maven project. No database needed.

## Run

```bash
mvn spring-boot:run
```

## Test

```bash
curl http://localhost:8080/api/orders/ORD-1001
curl -X POST http://localhost:8080/api/orders -H 'Content-Type: application/json' -d '{"orderId":"ORD-1002","customerId":"CUSTOMER-200","status":"NEW"}'
```

## Commit impact test

Modify `OrderServiceImpl.getOrder()` and trace its impact to `GET /api/orders/{orderId}`.
Modify `OrderServiceImpl.createOrder()` and trace its impact to `POST /api/orders`.
