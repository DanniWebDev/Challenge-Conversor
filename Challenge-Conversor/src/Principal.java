import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        ConsultaMoneda consulta = new ConsultaMoneda();

        int opcionSeleccionada = 0;
        while (opcionSeleccionada != 7) {
            // Mostrar el menú de opciones
            System.out.println("*********************************\n" +
                    "Bienvenidos al conversor de monedas\n\n" +
                    "Seleccione la conversión que desea realizar:\n\n" +
                    "1. Dólar a Peso Argentino\n" +
                    "2. Peso Argentino a Dólar\n" +
                    "3. Dólar a Real Brasileño\n" +
                    "4. Real Brasileño a Dólar\n" +
                    "5. Dólar a Peso Colombiano\n" +
                    "6. Peso Colombiano a Dólar\n" +
                    "7. Salir");
            opcionSeleccionada = lector.nextInt();
            lector.nextLine(); // Limpiar el buffer del Scanner

            // Ejecutar la opción seleccionada
            switch (opcionSeleccionada) {
                case 1:
                    ConvertirMoneda.convertir("USD", "ARS", consulta, lector);
                    break;
                case 2:
                    ConvertirMoneda.convertir("ARS", "USD", consulta, lector);
                    break;
                case 3:
                    ConvertirMoneda.convertir("USD", "BRL", consulta, lector);
                    break;
                case 4:
                    ConvertirMoneda.convertir("BRL", "USD", consulta, lector);
                    break;
                case 5:
                    ConvertirMoneda.convertir("USD", "COP", consulta, lector);
                    break;
                case 6:
                    ConvertirMoneda.convertir("COP", "USD", consulta, lector);
                    break;
                case 7:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        }
    }
}
