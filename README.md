# 🚀 Professional Expense Tracker API
**Standardized Backend for Personal Finance Management**

### 🛠 Technical Architecture
* **Core:** Java 17 / Spring Boot 4.0.3
* **Database:** MySQL 8.0 (Relational Data Integrity)
* **Persistence:** Spring Data JPA (Hibernate)
* **Documentation:** Swagger UI / OpenAPI 3.0 (Self-documenting API)
* **Security:** JSR-380 (Bean Validation)

---

### 🌟 Key "Salary-Booster" Features

#### 1. Professional Layered Architecture
Instead of "fat controllers," this project uses a strict **Controller → Service → Repository** flow. 
* **Benefit:** Decouples API logic from database logic, making the code unit-testable and scalable.

#### 2. DTO (Data Transfer Object) Pattern
Used an `ExpenseRequest` DTO to receive data.
* **Security Angle:** Prevents "Mass Assignment" vulnerabilities by ensuring users can only modify specific fields, protecting internal database IDs.

#### 3. Automated Business Logic (The "Smart" Layer)
* **Auto-Categorization:** If a user leaves the category blank, the Service layer scans the description. 
    * *Example:* "Uber to Indiranagar" is automatically categorized as `Travel`.
* **Sanitization:** Automatically rounds currency and formats descriptions before saving.

#### 4. Global Exception Handling
Implemented a `@RestControllerAdvice` to handle 404s and 400s.
* **Why:** Prevents leaking server stack traces, which is a critical security requirement in Cyber Security consulting.

---

### 🛣 API Documentation (Swagger)
Once the app is running, visit:
`http://localhost:8080/swagger-ui/index.html`

| Method | Endpoint | Use Case |
| :--- | :--- | :--- |
| `POST` | `/api/expenses` | Securely add an expense via JSON Body |
| `GET` | `/api/expenses` | Fetch all indexed transactions |
| `GET` | `/api/expenses/search` | Dynamic filtering by Category |
| `DELETE`| `/api/expenses/{id}` | Idempotent deletion of a resource |

---

### ⚙️ Installation & Setup
1.  **DB Setup:**
    ```sql
    CREATE DATABASE expense_db;
    ```
2.  **Config:** Update `application.properties` with your local MySQL credentials.
3.  **Build:**
    ```bash
    mvn clean install
    mvn spring-boot:run
    ```



