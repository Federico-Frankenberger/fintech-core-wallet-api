<div align="center">

# 🏦 Wallet API - Fintech Core (MVP)

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens)
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)

**Núcleo transaccional de alta integridad diseñado para la gestión de billeteras digitales.**

[Descripción](#-descripción) • [Arquitectura](#-arquitectura) • [Pilares de Ingeniería](#-pilares-de-ingeniería) • [Stack Tecnológico](#-stack-tecnológico) • [Roadmap](#-roadmap-de-implementación) • [Autor](#-autor)

---
</div>

## 📄 Descripción

Este proyecto implementa el motor transaccional de una **Wallet API (Fintech MVP)**. A diferencia de un CRUD tradicional, este sistema está diseñado bajo estándares de **integridad financiera**, priorizando la consistencia de los datos, el manejo de concurrencia y la resiliencia ante fallos de red.

El objetivo es demostrar la aplicación de patrones avanzados en Java para resolver problemas críticos en sistemas de pago: duplicidad de transacciones, condiciones de carrera en balances y trazabilidad total.

---

## 🏗 Arquitectura (Hexagonal & Clean Architecture)

El sistema utiliza una **Arquitectura Hexagonal (Puertos y Adaptadores)** combinada con principios de **Clean Architecture**, asegurando un desacoplamiento total entre la lógica de negocio y la infraestructura.

* **Diseño:** Arquitectura por capas desacopladas (Core, Application, Infrastructure).
* **Gestión de Errores:** Implementación del **Result Pattern** para un flujo de negocio predecible y determinista.
* **Persistencia:** Gestión de estados transaccionales ACID con PostgreSQL.
* **CI/CD:** Pipeline automatizado en GitHub Actions para compilación, testing y reporte de cobertura.

### Estructura de Carpetas:

* **`core` (Dominio):** El centro del sistema. Contiene las reglas de negocio puras, excepciones de dominio y casos de uso. No tiene dependencias de Spring.
* **`application` (Orquestación):** El puente de comunicación.
    * `service`: Implementa la lógica de orquestación y gestiona la transaccionalidad (`@Transactional`).
    * `web`: Adaptadores de entrada (Controllers, DTOs y Mappers) para transformar datos externos.
* **`infrastructure` (Adaptadores de Salida):** Detalles técnicos.
    * `persistence`: Implementación de datos con entidades JPA y repositorios.
    * `config`: Configuraciones globales como Seguridad JWT y Beans de sistema.
  
---

## 🛡 Pilares de Ingeniería (Fintech Core)

Para garantizar la fiabilidad del sistema, se han implementado los siguientes patrones:

### 1. 🔄 Idempotencia (Resiliencia de Red)
Prevención de transacciones duplicadas mediante el uso de `Idempotency-Key` (UUID). Si una petición se reintenta por un fallo de conexión, el sistema reconoce el identificador y evita procesar el cargo dos veces.

### 2. 🔒 Concurrencia (Optimistic Locking)
Protección del balance de la billetera mediante `@Version` (JPA). Evita el problema de la "actualización perdida" cuando múltiples hilos intentan modificar el mismo saldo simultáneamente.

### 3. 📉 Integridad Monetaria
Uso estricto de **BigDecimal** para evitar errores de redondeo en punto flotante y encapsulamiento en un **Value Object `Money`** (Monto + Moneda ISO 4217).

### 4. 🧹 Borrado Lógico (Soft Delete)
Cumplimiento de normativas financieras: ninguna transacción o usuario se elimina físicamente de la base de datos, manteniendo un historial íntegro para auditorías mediante `@SQLDelete`.

---

## 🛠 Stack Tecnológico

### 🧱 Core & Seguridad
* **Java 21:** Uso de Records, Streams API y Pattern Matching.
* **Spring Boot 3.4.x:** Framework base para el desarrollo del ecosistema.
* **Spring Security:** Implementación de **JWT Stateless Auth**.
* **Lombok:** Reducción de boilerplate en Entidades y modelos.

### 🏛️ Comunicación y Datos
* **MapStruct:** Mapeo profesional para desacoplar Entidades de DTOs.
* **Bean Validation:** Validaciones mediante `@Valid` y validadores personalizados.
* **Spring Data JPA:** Manejo de persistencia y gestión de `@Transactional`.
* **PostgreSQL / H2:** Bases de datos para desarrollo y testing (en memoria).
* **Flyway:** Migraciones de esquema SQL versionadas.

### 🧪 Calidad e Infraestructura
* **JUnit 5 & Mockito:** Testing unitario y de integración.
* **Jacoco:** Generación de reportes de cobertura (Meta: >80%).
* **SpringDoc OpenAPI 2.x:** Documentación técnica interactiva (Swagger UI).
* **Docker & Docker Compose:** Containerización de App y DB.

---

## 🗺️ Roadmap de Implementación

- [x] **Fase 0:** Setup de infraestructura, Gradle, Docker y CI/CD Pipeline.
- [ ] **Fase 1:** Dominio, Persistencia blindada y Migraciones SQL (Flyway).
- [ ] **Fase 2:** Lógica de Negocio, Result Pattern e Idempotencia.
- [ ] **Fase 3:** API REST y Mapeo profesional de DTOs.
- [ ] **Fase 4:** Seguridad con Spring Security + JWT.
- [ ] **Fase 5:** Observabilidad (Actuator) y Calidad Final.

---

## 🚀 Instalación y Ejecución

Sigue estos pasos para levantar el entorno de desarrollo localmente:

1.  **Clonar el repositorio:**
    ```bash
    git clone https://github.com/Federico-Frankenberger/fintech-core-wallet-api.git
    ```

2.  **Levantar la Base de Datos:**
    Asegúrate de tener Docker corriendo y ejecuta:
    ```bash
    docker-compose up -d
    ```

3.  **Ejecutar la Aplicación:**
    ```bash
    ./gradlew bootRun
    ```

---

## 👤 Autor

**Federico Agustín Frankenberger**
<br>
**Rol:** Java Backend Developer

* 💼 **LinkedIn:** [Ver Perfil](https://www.linkedin.com/in/federico-frankenberger/)
* 🐙 **GitHub:** [Ver Repositorio](https://github.com/Federico-Frankenberger)
* 📧 **Email:** [fafrankenberger@gmail.com](mailto:fafrankenberger@gmail.com)