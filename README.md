# Proyecto: Java Hexagonal Astrad Factory

## Descripción

Este proyecto implementa una arquitectura hexagonal en Java con una fábrica de conexiones a bases de datos. Se utiliza Maven como gestor de dependencias y se siguen principios de desacoplamiento entre capas para mejorar la mantenibilidad y escalabilidad del código.

## Estructura del Proyecto

El proyecto está organizado en los siguientes paquetes:

- **Application.Usecase.Client**: Contiene la lógica de negocio relacionada con los clientes.
- **Config**: Incluye configuraciones generales del proyecto, como `HexaSingleton`.
- **Domain.Entity**: Define las entidades del dominio, como `Client`.
- **Domain.Repository**: Define las interfaces para los repositorios, como `ClientRepository`.
- **Infrastructure.Database**: Contiene la lógica de conexión a la base de datos, incluyendo `ConnectionFactory` y `ConnMySql`.
- **Infrastructure.Persistence.Client**: Implementaciones concretas de los repositorios.

## Instalación y Ejecución

### Prerrequisitos

- Tener instalado Java 11 o superior.
- Tener Maven instalado.
- Tener configurada una base de datos MySQL si se desea persistencia de datos.

### Pasos

1. Clonar el repositorio o descargar el código fuente.
2. Navegar al directorio del proyecto.
3. Ejecutar el siguiente comando para compilar el proyecto:
   ```sh
   mvn clean install
   ```
4. Para ejecutar la aplicación:
   ```sh
   mvn exec:java -Dexec.mainClass="java_hexagonal_abstract.Main"
   ```

## Principales Clases y Funcionalidades

### `Main.java`

Punto de entrada de la aplicación, donde se inicializan los componentes principales.

### `Client.java`

Entidad que representa a un cliente en el sistema.

### `ClientUseCase.java`

Contiene la lógica de negocio para la gestión de clientes.

### `ClientRepository.java`

Interfaz que define los métodos para el acceso a datos de clientes.

### `ClientRepositoryImpl.java`

Implementación de `ClientRepository`, maneja la persistencia de los clientes.

### `ConnectionFactory.java`

Fábrica de conexiones a bases de datos, permite cambiar de proveedor de base de datos sin afectar la lógica de negocio.

## Desarrollador : Stivenco12

