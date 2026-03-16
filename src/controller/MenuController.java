package controller;

import model.Cliente;
import model.Producto;
import repository.FastFoodRepository;
import view.ConsoleView;

import java.util.List;

public class MenuController {

    private ConsoleView       view = new ConsoleView();
    private FastFoodRepository repo = FastFoodRepository.getInstance();

    public void iniciar() {
        int opcion;
        do {
            view.mostrarMenu();
            opcion = view.leerEntero();
            switch (opcion) {
                case 1 -> gestionarProductos();
                case 2 -> gestionarClientes();
                case 0 -> view.imprimirMensaje("Cerrando el sistema. Hasta pronto!");
                default -> view.imprimirMensaje("Opcion no valida. Intente de nuevo.");
            }
        } while (opcion != 0);
    }

    public void gestionarProductos() {
        int opcion;
        do {
            view.mostrarMenuProductos();
            opcion = view.leerEntero();
            switch (opcion) {
                case 1 -> crearProducto();
                case 2 -> consultarProductos();
                case 3 -> actualizarProducto();
                case 4 -> eliminarProducto();
                case 0 -> view.imprimirMensaje("Volviendo al menu principal...");
                default -> view.imprimirMensaje("Opcion no valida.");
            }
        } while (opcion != 0);
    }

    public void gestionarClientes() {
        int opcion;
        do {
            view.mostrarMenuClientes();
            opcion = view.leerEntero();
            switch (opcion) {
                case 1 -> crearCliente();
                case 2 -> consultarClientes();
                case 3 -> actualizarCliente();
                case 4 -> eliminarCliente();
                case 0 -> view.imprimirMensaje("Volviendo al menu principal...");
                default -> view.imprimirMensaje("Opcion no valida.");
            }
        } while (opcion != 0);
    }

    // ── CRUD Productos ────────────────────────────────────────────────────────
    private void crearProducto() {
        System.out.print("  Nombre del producto: ");
        String nombre = view.leerTexto();
        System.out.print("  Precio: ");
        double precio;
        try {
            precio = Double.parseDouble(view.leerTexto());
        } catch (NumberFormatException e) {
            view.imprimirMensaje("Precio invalido. Operacion cancelada.");
            return;
        }
        repo.crearProducto(new Producto(0, nombre, precio));
        view.imprimirMensaje("Producto creado exitosamente.");
    }

    private void consultarProductos() {
        List<Producto> lista = repo.obtenerProductos();
        if (lista.isEmpty()) {
            view.imprimirMensaje("No hay productos registrados.");
            return;
        }
        System.out.println();
        System.out.println("  -------- LISTA DE PRODUCTOS --------");
        for (Producto p : lista) {
            System.out.println(p);
        }
        System.out.println("  ------------------------------------");
    }

    private void actualizarProducto() {
        consultarProductos();
        System.out.print("  ID del producto a actualizar: ");
        int id = view.leerEntero();
        System.out.print("  Nuevo nombre: ");
        String nombre = view.leerTexto();
        System.out.print("  Nuevo precio: ");
        double precio;
        try {
            precio = Double.parseDouble(view.leerTexto());
        } catch (NumberFormatException e) {
            view.imprimirMensaje("Precio invalido. Operacion cancelada.");
            return;
        }
        if (repo.actualizarProducto(id, nombre, precio)) {
            view.imprimirMensaje("Producto actualizado correctamente.");
        } else {
            view.imprimirMensaje("No se encontro un producto con ese ID.");
        }
    }

    private void eliminarProducto() {
        consultarProductos();
        System.out.print("  ID del producto a eliminar: ");
        int id = view.leerEntero();
        if (repo.eliminarProducto(id)) {
            view.imprimirMensaje("Producto eliminado correctamente.");
        } else {
            view.imprimirMensaje("No se encontro un producto con ese ID.");
        }
    }

    // ── CRUD Clientes ─────────────────────────────────────────────────────────
    private void crearCliente() {
        System.out.print("  Nombre del cliente: ");
        String nombre = view.leerTexto();
        System.out.print("  Telefono: ");
        String telefono = view.leerTexto();
        repo.crearCliente(new Cliente(0, nombre, telefono));
        view.imprimirMensaje("Cliente creado exitosamente.");
    }

    private void consultarClientes() {
        List<Cliente> lista = repo.obtenerClientes();
        if (lista.isEmpty()) {
            view.imprimirMensaje("No hay clientes registrados.");
            return;
        }
        System.out.println();
        System.out.println("  --------- LISTA DE CLIENTES ---------");
        for (Cliente c : lista) {
            System.out.println(c);
        }
        System.out.println("  -------------------------------------");
    }

    private void actualizarCliente() {
        consultarClientes();
        System.out.print("  ID del cliente a actualizar: ");
        int id = view.leerEntero();
        System.out.print("  Nuevo nombre: ");
        String nombre = view.leerTexto();
        System.out.print("  Nuevo telefono: ");
        String telefono = view.leerTexto();
        if (repo.actualizarCliente(id, nombre, telefono)) {
            view.imprimirMensaje("Cliente actualizado correctamente.");
        } else {
            view.imprimirMensaje("No se encontro un cliente con ese ID.");
        }
    }

    private void eliminarCliente() {
        consultarClientes();
        System.out.print("  ID del cliente a eliminar: ");
        int id = view.leerEntero();
        if (repo.eliminarCliente(id)) {
            view.imprimirMensaje("Cliente eliminado correctamente.");
        } else {
            view.imprimirMensaje("No se encontro un cliente con ese ID.");
        }
    }
}
