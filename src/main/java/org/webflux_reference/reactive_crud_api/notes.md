# REST APIs with WebFlux

---

## Implementation Details

- GET
  - /customers
  - /customers/{id}
  - /customers/paginated?page=$n$size=$x$
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

---

### CustomerDto vs Mono<CustomerDto>

- One passes an object, another sets up a reactive "pipeline". Clearer when dealing with Flux

---

### How to return HTTP Status codes

- Mono/Flux are publisher types
  - data/empty = 200
  - error = 500
- ResponseEntity
  - Mono<ResponseEntity<T>> -- will send appropriate status code. 400,404,429 etc
- See documentation

---

## Testing

- WebClient
  - To send non-blocking HTTP requests
- WebTestClient
  - To write unit/integration tests

---

### WebTestClient

- client.get()
  - post()
  - put()
  - delete()
- uri("/path")
- exchange() -> sends the reqeust and gets the 
- after exchange() we can assert status, header, response content etc
- can also use JSON path