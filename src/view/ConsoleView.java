package view;

import java.util.Scanner;

public class ConsoleView {

    private Scanner sc = new Scanner(System.in);

    public void mostrarMenu() {
        System.out.println();
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║    SISTEMA DE COMIDAS RAPIDAS        ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.println("║  1. Gestionar Productos               ║");
        System.out.println("║  2. Gestionar Clientes                ║");
        System.out.println("║  0. Salir                             ║");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.print("  Seleccione una opcion: ");
    }

    public void mostrarMenuProductos() {
        System.out.println();
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║         GESTION DE PRODUCTOS         ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.println("║  1. Crear producto                    ║");
        System.out.println("║  2. Consultar productos               ║");
        System.out.println("║  3. Actualizar producto               ║");
        System.out.println("║  4. Eliminar producto                 ║");
        System.out.println("║  0. Volver al menu principal          ║");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.print("  Seleccione una opcion: ");
    }

    public void mostrarMenuClientes() {
        System.out.println();
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║         GESTION DE CLIENTES          ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.println("║  1. Crear cliente                     ║");
        System.out.println("║  2. Consultar clientes                ║");
        System.out.println("║  3. Actualizar cliente                ║");
        System.out.println("║  4. Eliminar cliente                  ║");
        System.out.println("║  0. Volver al menu principal          ║");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.print("  Seleccione una opcion: ");
    }

    public int leerEntero() {
        while (true) {
            try {
                int valor = Integer.parseInt(sc.nextLine().trim());
                return valor;
            } catch (NumberFormatException e) {
                System.out.print("  Ingrese un numero valido: ");
            }
        }
    }

    public String leerTexto() {
        return sc.nextLine().trim();
    }

    public void imprimirMensaje(String msg) {
        System.out.println("  >> " + msg);
    }
}
