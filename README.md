
---

### 📁 `README.md` del Backend (Java - Spring Boot)

```markdown
# Backend - API Tienda Virtual

Este es el backend de una aplicación para administrar una tienda. Permite registrar productos, procesar ventas y pedidos, y generar estadísticas.

## 🛠️ Tecnologías utilizadas

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database (en memoria, opcional para pruebas)
- Maven

## 📦 Endpoints disponibles

- `GET /api/productos` - Listar productos
- `POST /api/productos` - Crear producto
- `POST /api/ventas` - Vender productos
- `POST /api/pedidos` - Pedir productos
- `GET /api/estadisticas` - Ver estadísticas

## 🚀 Cómo ejecutar

1. Clona el proyecto o descomprime los archivos.
2. Abre en tu IDE (IntelliJ, Eclipse, etc.).
3. Ejecuta la clase `TiendaApplication`.
4. El servidor estará disponible en: `http://localhost:8080`

## 📁 Instrucciones para la construcción

1. Clona este repositorio en tu máquina local.
   ```bash
   https://github.com/AndresFC500/Tienda.git
    ```
2. Compila y empaqueta el proyecto utilizando Maven.
   ```bash
   mvn clean package
    ```


