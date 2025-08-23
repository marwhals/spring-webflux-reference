# Spring Data R2DBC

---

## R2DBC

- JPA is a specification
  - It is for traditional synchronous programming
- R2DBC is a separate specification
  - For reactive programming
- R2DDBC $\neq$ JPA
- R2DBC Prioritises
  - Performance
  - Scalability
  - Streaming + Backpressure
- It does NOT have feature like
  - `@OneToMany`
  - `@ManyToMany`
- See documentation

---

## StepVerifier

- StepVerifier.create(...)
- Next
  - expectNext(...)
  - expectNextCount()
  - thenConsumeWhile(...)
  - assertNext(...)
- Complete / Error
  - expectComplete()
  - expectError()
- Verify (This is what subscribes and runs the test)
  - verify()