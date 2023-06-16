import java.util.Scanner;

public class CajeroAutomatico {
    private static double saldo = 1000000; // Saldo inicial
    private static final int PIN_CORRECTO = 1234; // PIN de ejemplo

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese su PIN: ");
        int pinIngresado = scanner.nextInt();

        if (verificarPin(pinIngresado)) {
            while (true) {
                mostrarMenu();

                int opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        consultarSaldo();
                        break;
                    case 2:
                        retirarDinero();
                        break;
                    case 3:
                        depositarDinero();
                        break;
                    case 4:
                        System.out.println("Gracias por utilizar el cajero automático. ¡Hasta luego!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                        break;
                }
            }
        } else {
            System.out.println("PIN incorrecto. El programa se cerrará.");
        }
    }

    public static boolean verificarPin(int pinIngresado) {
        return pinIngresado == PIN_CORRECTO;
    }

    public static void mostrarMenu() {
        System.out.println("Bienvenido al cajero automático");
        System.out.println("1. Consultar saldo");
        System.out.println("2. Retirar dinero");
        System.out.println("3. Depositar dinero");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public static void consultarSaldo() {
        System.out.println("Su saldo actual es: " + saldo + " colones");
    }

    public static void retirarDinero() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la cantidad a retirar: ");
        double cantidad = scanner.nextDouble();

        if (cantidad > saldo) {
            System.out.println("No tiene saldo suficiente");
        } else {
            saldo -= cantidad;
            System.out.println("Ha retirado " + cantidad + " colones. Saldo restante: " + saldo + " colones");
        }
    }

    public static void depositarDinero() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la cantidad a depositar: ");
        double cantidad = scanner.nextDouble();

        saldo += cantidad;
        System.out.println("Ha depositado " + cantidad + " colones. Saldo actual: " + saldo + " colones");
    }
}

