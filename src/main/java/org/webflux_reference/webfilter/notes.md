# Webfilter notes

---

- Handles cross cutting concerns like authentication, authorisation
  - Do not do request body validation
- Can access path,header, parameters, cookies etc
- We can chain multiple WebFilters to do multiple validations before the request reaches the controller
- Ordered using the `@Order(x)` annotation

```mermaid
graph TD
    
    Z[Client]
    A["webfilter one - @Order(1)"]
    B["webfilter two - @Order(2)"]
    C[controller]
    
    Z ==> A --> B --> C
    A -.->|return a Mono of failure| Z

```