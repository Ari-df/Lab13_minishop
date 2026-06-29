# Feature: Pruebas de Aceptación - MiniShop
# Curso: Construcción y Pruebas de Software
# Laboratorio 16 - Semana 16

Feature: Visualización del catálogo de productos

  Background:
    Given que el sistema MiniShop está en funcionamiento
    And la aplicación responde en http://localhost:8080

  Scenario: CA-01-01 - Consultar catálogo con código HTTP 200
    Given que existen productos registrados en el sistema
    When el cliente realiza una petición GET a "/productos"
    Then el sistema responde con código HTTP 200

  Scenario: CA-01-02 - Catálogo retorna lista con datos de productos
    Given que existen productos registrados en el sistema
    When el cliente realiza una petición GET a "/productos"
    Then la respuesta contiene una lista con id, nombre y precio de cada producto

  Scenario: CA-01-03 - Catálogo vacío
    Given que no existen productos registrados en el sistema
    When el cliente realiza una petición GET a "/productos"
    Then el sistema responde con código HTTP 200
    And la respuesta contiene una lista vacía []

Feature: Consulta de producto individual

  Scenario: CA-02-01 - Consultar producto con ID existente
    Given que existe un producto con ID 1 en el sistema
    When el cliente realiza una petición GET a "/productos/1"
    Then el sistema responde con código HTTP 200
    And la respuesta contiene el id, nombre y precio del producto

  Scenario: CA-02-02 - Consultar producto con ID inexistente
    Given que no existe un producto con ID 999 en el sistema
    When el cliente realiza una petición GET a "/productos/999"
    Then el sistema responde con código HTTP 404

Feature: Registro de nuevo producto

  Scenario: CA-03-01 - Crear producto con datos válidos
    Given que el sistema está en funcionamiento
    When el administrador realiza una petición POST a "/productos"
    And el cuerpo contiene nombre "Monitor" y precio 450.00
    Then el sistema responde con código HTTP 200
    And la respuesta contiene el producto creado con su ID asignado

  Scenario: CA-03-02 - Producto creado aparece en el catálogo
    Given que se creó un producto con nombre "Monitor" y precio 450.00
    When el cliente realiza una petición GET a "/productos"
    Then la respuesta contiene el producto "Monitor" en la lista
