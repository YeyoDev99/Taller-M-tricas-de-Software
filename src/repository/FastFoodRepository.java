package repository;

import model.Cliente;
import model.Producto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FastFoodRepository implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final String DATA_FILE = "fastfood_data.dat";

    private List<Producto> productos = new ArrayList<>();
    private List<Cliente>  clientes  = new ArrayList<>();
    private int nextProductoId = 1;
    private int nextClienteId  = 1;

    // ── Singleton ─────────────────────────────────────────────────────────────
    private static FastFoodRepository instance;

    private FastFoodRepository() {}

    public static FastFoodRepository getInstance() {
        if (instance == null) {
            instance = cargar();
        }
        return instance;
    }

    // ── Persistencia ─────────────────────────────────────────────────────────
    private static FastFoodRepository cargar() {
        File f = new File(DATA_FILE);
        if (f.exists()) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(f))) {
                return (FastFoodRepository) in.readObject();
            } catch (Exception e) {
                System.out.println("Iniciando base de datos nueva...");
            }
        }
        return new FastFoodRepository();
    }

    private void guardar() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            out.writeObject(this);
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    // ── Productos ─────────────────────────────────────────────────────────────
    public void crearProducto(Producto p) {
        p = new Producto(nextProductoId++, p.getNombre(), p.getPrecio());
        productos.add(p);
        guardar();
    }

    public List<Producto> obtenerProductos() {
        return new ArrayList<>(productos);
    }

    public boolean eliminarProducto(int id) {
        boolean removed = productos.removeIf(p -> p.getId() == id);
        if (removed) guardar();
        return removed;
    }

    public boolean actualizarProducto(int id, String nuevoNombre, double nuevoPrecio) {
        for (Producto p : productos) {
            if (p.getId() == id) {
                p.setNombre(nuevoNombre);
                p.setPrecio(nuevoPrecio);
                guardar();
                return true;
            }
        }
        return false;
    }

    // ── Clientes ──────────────────────────────────────────────────────────────
    public void crearCliente(Cliente c) {
        c = new Cliente(nextClienteId++, c.getNombre(), c.getTelefono());
        clientes.add(c);
        guardar();
    }

    public List<Cliente> obtenerClientes() {
        return new ArrayList<>(clientes);
    }

    public boolean eliminarCliente(int id) {
        boolean removed = clientes.removeIf(c -> c.getId() == id);
        if (removed) guardar();
        return removed;
    }

    public boolean actualizarCliente(int id, String nuevoNombre, String nuevoTelefono) {
        for (Cliente c : clientes) {
            if (c.getId() == id) {
                c.setNombre(nuevoNombre);
                c.setTelefono(nuevoTelefono);
                guardar();
                return true;
            }
        }
        return false;
    }
}
