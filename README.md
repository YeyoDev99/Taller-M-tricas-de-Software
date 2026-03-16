# 🍟 Sistema de Comidas Rápidas
**Aplicación CRUD con Interfaz Gráfica en Java (Swing)**

---

## 📁 Estructura del Proyecto

```
FastFoodApp/
├── src/
│   ├── Main.java                          # Punto de entrada
│   ├── model/
│   │   ├── Producto.java                  # Entidad Producto (id, nombre, precio, categoría, descripción)
│   │   └── Cliente.java                   # Entidad Cliente (id, nombre, teléfono, email, dirección)
│   ├── repository/
│   │   └── FastFoodRepository.java        # Repositorio singleton con persistencia en archivo
│   └── view/
│       ├── MainFrame.java                 # Ventana principal con sidebar de navegación
│       ├── ProductosPanel.java            # Panel CRUD de Productos
│       └── ClientesPanel.java             # Panel CRUD de Clientes
├── compilar_y_ejecutar.sh                 # Script para compilar y ejecutar (Linux/Mac)
└── README.md
```

---

## ⚙️ Requisitos

- **Java JDK 8 o superior**
- No se necesitan librerías externas (solo Java Standard Library + Swing)

---

## 🚀 Cómo compilar y ejecutar

### Opción 1 – Script automático (Linux / macOS)
```bash
chmod +x compilar_y_ejecutar.sh
./compilar_y_ejecutar.sh
```

### Opción 2 – Manual
```bash
mkdir -p out
javac -d out src/model/Producto.java src/model/Cliente.java \
             src/repository/FastFoodRepository.java \
             src/view/ProductosPanel.java src/view/ClientesPanel.java \
             src/view/MainFrame.java src/Main.java
cd out
java Main
```

### Opción 3 – IDE (IntelliJ IDEA / Eclipse)
1. Abrir el proyecto apuntando a la carpeta `FastFoodApp/`
2. Marcar `src/` como "Sources Root"
3. Ejecutar `Main.java`

---

## 🖥️ Funcionalidades

### Módulo Productos 🍔
| Operación | Descripción |
|-----------|-------------|
| **Crear**     | Agrega un nuevo producto con nombre, precio, categoría y descripción |
| **Consultar** | Visualiza todos los productos en tabla |
| **Actualizar**| Selecciona un producto en la tabla, edita y guarda |
| **Eliminar**  | Elimina el producto seleccionado (con confirmación) |

### Módulo Clientes 👤
| Operación | Descripción |
|-----------|-------------|
| **Crear**     | Registra un nuevo cliente con nombre, teléfono, email y dirección |
| **Consultar** | Visualiza todos los clientes en tabla |
| **Actualizar**| Selecciona un cliente en la tabla, edita y guarda |
| **Eliminar**  | Elimina el cliente seleccionado (con confirmación) |

---

## 💾 Persistencia de Datos
Los datos se guardan automáticamente en el archivo `fastfood_data.dat` ubicado en el directorio donde se ejecute la aplicación. Al reiniciar la app, los datos se cargan automáticamente.

---

## 🏗️ Arquitectura (POO)

```
Main ──► MainFrame (JFrame con CardLayout)
              ├── ProductosPanel (JPanel)  ──► FastFoodRepository
              └── ClientesPanel  (JPanel)  ──► FastFoodRepository
                                                    ├── List<Producto>
                                                    └── List<Cliente>
```

Sigue el patrón **MVC simplificado** con:
- **Model**: `Producto`, `Cliente`
- **Repository**: `FastFoodRepository` (Singleton + Serialización)
- **View**: `MainFrame`, `ProductosPanel`, `ClientesPanel`

---

## 🎨 Diseño de la UI
- Tema oscuro moderno (dark mode)
- Sidebar de navegación lateral
- Tablas con filas alternas coloreadas
- Panel de formulario lateral integrado
- Retroalimentación visual en botones (hover)
