# Input validation, Error handling notes

---

- Standardised format for problem details
    - RFC7807 / RFC9457
    - Structured error response
    - Machine/Human readable

| Properties | Description                                                                |
|------------|----------------------------------------------------------------------------|
| type       | A link to the documentation fro the callers to read more about the problem |
| title      | Human readable summary of the problem                                      |
| status     | HTTP Status code                                                           |
| detail     | Detailed message specific to the problem                                   |
| instance   | The URI which caused the problem                                           |

---

## Bean validation -- see docs !Spring Webflux Validation"

---

## Summary

- Bean Validation + Webflux
- Error signals can be caught via Controller Advice and then a appropriate status code can be returned