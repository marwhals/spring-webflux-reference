# Implementation Details

---

## Tables / Database Schema

### customer
- id
- name
- email

### product
- id
- description
- price 

### customer_order
- order_id
- customer_id
- product_id
- amount
- order_date

## ER Diagram

```mermaid

erDiagram
    CUSTOMER {
        int id PK
        string name
        string email
    }
    PRODUCT {
        int id PK
        string description
        float price
    }
    CUSTOMER_ORDER {
        int order_id PK
        int customer_id FK
        int product_id FK
        int amount
        date order_date
    }

    CUSTOMER ||--o{ CUSTOMER_ORDER : "places"
    PRODUCT  ||--o{ CUSTOMER_ORDER : "includes"



```

