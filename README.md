# Sistema de Gestión de Actividades - Asociación de Pacientes Cardíacos de Córdoba

Este proyecto es una solución automatizada para gestionar las inscripciones de pacientes a los talleres y actividades de rehabilitación cardíaca, sustituyendo el control manual en papel o Excel.

## 📊 Diagrama Entidad-Relación (E-R)

```mermaid
erDiagram
    ESPECIALISTAS ||--o{ TALLERES : "imparte"
    PACIENTES ||--o{ INSCRIPCIONES : "se apunta"
    TALLERES ||--o{ INSCRIPCIONES : "contiene"

    ESPECIALISTAS {
        int id PK
        string nombre
        string especialidad
    }
    TALLERES {
        int id PK
        string titulo
        datetime fecha_hora
        int cupo_maximo
        int especialista_id FK
    }
    PACIENTES {
        int id PK
        string nombre
        string apellidos
        string telefono
        string cardiopatia
    }
    INSCRIPCIONES {
        int id PK
        int paciente_id FK
        int taller_id FK
        date fecha_registro
    }
🛠️ Requisitos Previos
Java 21 o superior instalado.

Maven instalado (o usar el mvnw incluido).

🚀 Instrucciones de Despliegue y Arranque
Clonar el repositorio:

Bash
git clone <URL_DE_TU_REPOSITORIO>
cd cardio
Ejecutar la aplicación:
Se puede arrancar desde el IDE (IntelliJ) o mediante terminal con el siguiente comando:

Bash
./mvnw spring-boot:run
La aplicación se iniciará en el puerto 8889.

Acceso a la Base de Datos (Consola H2):

URL: http://localhost:8889/h2-console

JDBC URL: jdbc:h2:mem:cardiodb

Usuario: sa (Sin contraseña).

🔀 Endpoints de la API (Pruebas en Postman)
Listar Pacientes (GET): http://localhost:8889/api/pacientes

Crear Paciente (POST): http://localhost:8889/api/pacientes (Enviar JSON en el Body).

Modificar Paciente (PUT): http://localhost:8889/api/pacientes/{id}

Eliminar Paciente (DELETE): http://localhost:8889/api/pacientes/{id}
