# Reporte de Pruebas de Aceptación — MiniShop

**Curso:** Construcción y Pruebas de Software  
**Laboratorio:** 16  
**Fecha:** 29/06/2026  
**Ejecutado por:** Dafne  
**URL base:** http://localhost:8080  

---

## 1. Historias de usuario evaluadas

| ID | Historia de usuario | ¿Implementada? | ¿Tiene criterios escritos? |
|---|---|---|---|
| HU-01 | Como cliente, quiero ver el catálogo de productos para elegir qué comprar | Sí | Sí |
| HU-02 | Como cliente, quiero consultar el detalle de un producto por su ID para ver su información | Sí | Sí |
| HU-03 | Como administrador, quiero registrar un nuevo producto para que esté disponible en el catálogo | Sí | Sí |

---

## 2. Criterios de aceptación

### HU-01 — Ver catálogo de productos

| ID Criterio | Descripción |
|---|---|
| CA-01-01 | Cuando se consulta el catálogo, el sistema debe retornar código HTTP 200 |
| CA-01-02 | Cuando hay productos registrados, el sistema debe retornar una lista con id, nombre y precio |
| CA-01-03 | Cuando no hay productos registrados, el sistema debe retornar una lista vacía |

### HU-02 — Consultar producto por ID

| ID Criterio | Descripción |
|---|---|
| CA-02-01 | Cuando se consulta un producto con ID existente, el sistema debe retornar código HTTP 200 con sus datos |
| CA-02-02 | Cuando se consulta un producto con ID inexistente, el sistema debe retornar código HTTP 404 |

### HU-03 — Registrar un nuevo producto

| ID Criterio | Descripción |
|---|---|
| CA-03-01 | Cuando se envía un producto con nombre y precio válidos, el sistema debe retornar HTTP 200 y el producto creado con su ID |
| CA-03-02 | Cuando se crea un producto, este debe aparecer en el catálogo al consultarlo después |

---

## 3. Estado inicial del sistema

| Dato | Valor actual |
|---|---|
| Número de productos en la base de datos | 3 |
| Número de pedidos existentes | 0 |
| Usuarios de prueba disponibles | N/A |
| URL base de la aplicación | http://localhost:8080 |

---

## 4. Registro de ejecución de escenarios

### CA-01-01 — Consultar catálogo con código HTTP 200

| Campo | Contenido |
|---|---|
| ID del escenario | CA-01-01 |
| Historia de usuario | HU-01 |
| Nombre del escenario | Consultar catálogo con código HTTP 200 |
| Fecha y hora de ejecución | 29/06/2026 03:52 |
| Ejecutado por | Dafne |
| Pasos ejecutados | GET http://localhost:8080/productos |
| Resultado esperado (Then) | HTTP 200 |
| Resultado obtenido | HTTP 200 |
| Estado | ✅ Aprobado |
| Observación | — |
| Evidencia | `[{"id":1,"nombre":"Teclado","precio":89.0},{"id":2,"nombre":"Laptop","precio":2500.0},{"id":3,"nombre":"Mouse","precio":35.0}]` |

---

### CA-01-02 — Catálogo retorna lista con datos de productos

| Campo | Contenido |
|---|---|
| ID del escenario | CA-01-02 |
| Historia de usuario | HU-01 |
| Nombre del escenario | Catálogo retorna lista con datos de productos |
| Fecha y hora de ejecución | 29/06/2026 03:52 |
| Ejecutado por | Dafne |
| Pasos ejecutados | GET http://localhost:8080/productos |
| Resultado esperado (Then) | Lista con id, nombre y precio |
| Resultado obtenido | Lista con id, nombre y precio |
| Estado | ✅ Aprobado |
| Observación | — |
| Evidencia | `[{"id":1,"nombre":"Teclado","precio":89.0},{"id":2,"nombre":"Laptop","precio":2500.0},{"id":3,"nombre":"Mouse","precio":35.0}]` |

---

### CA-01-03 — Catálogo vacío

| Campo | Contenido |
|---|---|
| ID del escenario | CA-01-03 |
| Historia de usuario | HU-01 |
| Nombre del escenario | Catálogo vacío |
| Fecha y hora de ejecución | 29/06/2026 04:24 |
| Ejecutado por | Dafne |
| Pasos ejecutados | GET http://localhost:8080/productos con base de datos vacía (servidor recién iniciado) |
| Resultado esperado (Then) | HTTP 200 con lista vacía `[]` |
| Resultado obtenido | HTTP 200 con `[]` |
| Estado | ✅ Aprobado |
| Observación | — |
| Evidencia | `[]` |

---

### CA-02-01 — Consultar producto con ID existente

| Campo | Contenido |
|---|---|
| ID del escenario | CA-02-01 |
| Historia de usuario | HU-02 |
| Nombre del escenario | Consultar producto con ID existente |
| Fecha y hora de ejecución | 29/06/2026 04:00 |
| Ejecutado por | Dafne |
| Pasos ejecutados | GET http://localhost:8080/productos/1 |
| Resultado esperado (Then) | HTTP 200 con id, nombre y precio |
| Resultado obtenido | HTTP 200 con `{"id":1,"nombre":"Teclado","precio":89.0}` |
| Estado | ✅ Aprobado |
| Observación | — |
| Evidencia | `{"id":1,"nombre":"Teclado","precio":89.0}` |

---

### CA-02-02 — Consultar producto con ID inexistente

| Campo | Contenido |
|---|---|
| ID del escenario | CA-02-02 |
| Historia de usuario | HU-02 |
| Nombre del escenario | Consultar producto con ID inexistente |
| Fecha y hora de ejecución | 29/06/2026 04:00 |
| Ejecutado por | Dafne |
| Pasos ejecutados | GET http://localhost:8080/productos/999 |
| Resultado esperado (Then) | HTTP 404 |
| Resultado obtenido | HTTP 404 |
| Estado | ✅ Aprobado |
| Observación | — |
| Evidencia | `Error en el servidor remoto: (404) No se encontró` |

---

### CA-03-01 — Crear producto con datos válidos

| Campo | Contenido |
|---|---|
| ID del escenario | CA-03-01 |
| Historia de usuario | HU-03 |
| Nombre del escenario | Crear producto con datos válidos |
| Fecha y hora de ejecución | 29/06/2026 04:10 |
| Ejecutado por | Dafne |
| Pasos ejecutados | POST http://localhost:8080/productos con `{"nombre":"Monitor","precio":450.00}` |
| Resultado esperado (Then) | HTTP 200 con producto creado e ID asignado |
| Resultado obtenido | HTTP 200 con `{"id":4,"nombre":"Monitor","precio":450.0}` |
| Estado | ✅ Aprobado |
| Observación | — |
| Evidencia | `{"id":4,"nombre":"Monitor","precio":450.0}` |

---

### CA-03-02 — Producto creado aparece en el catálogo

| Campo | Contenido |
|---|---|
| ID del escenario | CA-03-02 |
| Historia de usuario | HU-03 |
| Nombre del escenario | Producto creado aparece en el catálogo |
| Fecha y hora de ejecución | 29/06/2026 04:18 |
| Ejecutado por | Dafne |
| Pasos ejecutados | GET http://localhost:8080/productos |
| Resultado esperado (Then) | "Monitor" aparece en la lista |
| Resultado obtenido | `{"id":4,"nombre":"Monitor","precio":450.0}` presente en la lista |
| Estado | ✅ Aprobado |
| Observación | — |
| Evidencia | `[{"id":1,"nombre":"Teclado","precio":89.0},{"id":2,"nombre":"Laptop","precio":2500.0},{"id":3,"nombre":"Mouse","precio":35.0},{"id":4,"nombre":"Monitor","precio":450.0}]` |

---

## 5. Resumen de resultados

| ID Historia | Historia | Total escenarios | ✅ Aprobados | ❌ Fallidos | ⚠️ Parciales |
|---|---|---|---|---|---|
| HU-01 | Catálogo de productos | 3 | 3 | 0 | 0 |
| HU-02 | Consulta de producto por ID | 2 | 2 | 0 | 0 |
| HU-03 | Registro de nuevo producto | 2 | 2 | 0 | 0 |
| **TOTAL** | | **7** | **7** | **0** | **0** |

---

## 6. Tabla de defectos

No se encontraron defectos durante la ejecución. Todos los escenarios fueron aprobados.

| ID Defecto | Escenario fallido | Descripción | Severidad | Acción recomendada |
|---|---|---|---|---|
| — | — | Sin defectos encontrados | — | — |

---

## 7. Decisión del Product Owner

**Criterios de salida evaluados:**
- 100% de escenarios críticos aprobados ✅
- 0% de escenarios con estado Parcial ✅
- 0 escenarios Fallidos ✅

**Decisión: El sistema es aceptado sin condiciones.**

Firma del Product Owner: _________________________ Fecha: 29/06/2026
