# REST APIs with WebFlux

---

## Implementation Details

- GET
  - /customers
  - /customers/{id}
- POST
  - /customers
- PUT
  - /customers{id}
- DELETE
  - /customers/{id}

---

## Notes about DTOs

- Matter of taste
  - DTO - represents the API / data we share with clients
  - Entity - It represents the data stored in the DB table
- Advantages of DTO
  - Decoupling
    - DB Table vs API
  - Security
    - Data exposure
    - Customer entity might have password files. CustomerDTO might not have
  - Versioning
  - Validation