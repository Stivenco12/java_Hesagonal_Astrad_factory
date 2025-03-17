# Proyecto: Arquitectura Hexagonal con Fábricas en Java

Este proyecto implementa la **arquitectura hexagonal** en Java, utilizando patrones de diseño como **Factory** y **Singleton** para la gestión de bases de datos, clientes y productos. 
La arquitectura hexagonal permite desacoplar la lógica del negocio de las interfaces de usuario y la infraestructura, facilitando la escalabilidad y mantenibilidad del sistema.

## 🚀 Tecnologías Utilizadas
- **Java 8+**: Lenguaje de programación.
- **Maven**: Para la gestión de dependencias y compilación del proyecto.
- **Arquitectura Hexagonal**: Estructura que separa la lógica de negocio de la infraestructura y las interfaces de usuario.
- **Patrón Factory**: Para la creación de objetos sin especificar la clase exacta.
- **Patrón Singleton**: Para garantizar una única instancia de la base de datos y otros servicios esenciales.

## 📂 Estructura del Proyecto
```
java_Hesagonal_Astrad_factory-main/
│── pom.xml                                    # Configuración de Maven
│── src/main/java/java_hexagonal_abstract/     # Código fuente principal
│   │── Main.java                               # Punto de entrada del programa
│   │── guardar.java                            # Clase para persistencia de datos
│   │── Application/Usecase/                    # Casos de uso
│   │   │── Basedatos/BasedatosUseCase.java     # Lógica para base de datos
│   │   │── Client/ClientUseCase.java           # Lógica para clientes
│   │   │── Product/ProductUseCase.java         # Lógica para productos
│   │── Config/HexaSingleton.java               # Implementación del patrón Singleton
│   │── Domain/Entity/                          # Entidades del dominio
│   │   │── BaseDeDatos.java                    # Representación de la base de datos
│   │   │── Client.java                         # Representación de un cliente
│   │   │── Product.java                        # Representación de un producto
│── target/                                    # Archivos compilados
```

## 📌 Instalación y Uso
1. Clona el repositorio:
   ```bash
   git clone https://github.com/tuusuario/tu-repo.git
   ```
2. Accede al directorio del proyecto:
   ```bash
   cd java_Hesagonal_Astrad_factory-main
   ```
3. Compila y ejecuta con Maven:
   ```bash
   mvn clean install
   mvn exec:java -Dexec.mainClass="java_hexagonal_abstract.Main"
   ```

## ✨ Explicación del Código
### **Patrón Singleton (`HexaSingleton.java`)**
El **patrón Singleton** se implementa en `HexaSingleton.java` para garantizar que solo exista una única instancia de la base de datos en toda la aplicación. Esto evita la duplicación de conexiones y mejora la eficiencia.

### **Patrón Factory y Casos de Uso**
- **`BasedatosUseCase.java`**: Contiene la lógica de negocio para manejar la base de datos.
- **`ClientUseCase.java`**: Maneja las operaciones de los clientes.
- **`ProductUseCase.java`**: Administra la lógica relacionada con los productos.
- **`guardar.java`**: Implementa la persistencia de datos, asegurando que la información se almacene correctamente.
- **`Domain/Entity/`**: Contiene las entidades principales del dominio como `BaseDeDatos.java`, `Client.java` y `Product.java`, que representan la estructura de los datos en el sistema.

### **Beneficios de la Arquitectura Hexagonal**
1. **Desacoplamiento**: Permite que los componentes del negocio sean independientes de la infraestructura.
2. **Mantenibilidad**: Se pueden cambiar las tecnologías de persistencia o interfaces sin afectar la lógica central.
3. **Escalabilidad**: Facilita la adición de nuevos módulos sin afectar los existentes.
4. **Reutilización**: La lógica del negocio puede ser utilizada por múltiples interfaces, como una API REST o una aplicación de escritorio.

## 📌 Posibles Mejoras
- Implementar pruebas unitarias para garantizar el correcto funcionamiento de cada módulo.
- Añadir una capa de persistencia más avanzada con un ORM como Hibernate.
- Integrar una API REST para interactuar con la aplicación desde otros sistemas.
- Implementar un sistema de logs para mejorar la depuración y mantenimiento del código.

## 👨‍💻 Desarrollador
- **Stivenco12**

