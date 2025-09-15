# Web Calculator (Spring Boot + Thymeleaf)

![image](src/main/resources/static/images/snapshot.png)

A simple web-based calculator with **server-side processing** of arithmetic operations.

Supported operations: `+`, `-`, `*`, `/`, `%`, `√`, and sign change `±`.  

---

## Technologies

- Java 17
- Spring Boot 3.x
- Thymeleaf
- HTML / CSS / JavaScript
- Maven
- Fetch API for AJAX

---

## Project Structure
```courseignore
src/main/java/com/joit/tab
├─ controller
│  └─ CalculationController.java        
   └─ CalculationLogicController.java 
├─ service
│  ├─ CalculationService.java
   └─ base
       └─ OperationStrategy.java 
│  └─ strategy
│     ├─ OperationStrategy.java
│     ├─ AddOperation.java
│     ├─ SubtractOperation.java
│     ├─ MultiplyOperation.java
│     ├─ DivideOperation.java
│     ├─ SqrtOperation.java
│     ├─ PercentOperation.java
│     └─ PlusMinusOperation.java
├─ dtos
│  ├─ CalculationRequest.java
│  └─ CalculationResponse.java
```

## Running the Project
1. Clone the repository
```bash
 git clone git@github.com:dramaticLemon/web-calulator.git
 cd web-calulator 
```
2. Run with Meven
```courseignore
mvn spring-boot:run
```
3. Open in a browser
```courseignore
http://localhost:8080/app
```
