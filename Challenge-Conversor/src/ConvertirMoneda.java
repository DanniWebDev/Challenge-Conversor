import java.util.Scanner;

public class ConvertirMoneda {

    public static void convertir(String monedaOrigen, String monedaDestino, ConsultaMoneda consulta, Scanner lector) {

        System.out.println("Ingrese la cantidad de " + monedaOrigen + ": ");
        double cantidad = lector.nextDouble();


        Monedas monedas = consulta.buscarMoneda(monedaOrigen, monedaDestino);
        double tasaConversion = monedas.conversion_rate();
        System.out.println("Tasa de conversión: 1 " + monedaOrigen + " = " + tasaConversion + " " + monedaDestino);


        double cantidadConvertida = cantidad * tasaConversion;


        System.out.printf("%.2f %s = %.2f %s\n", cantidad, monedaOrigen, cantidadConvertida, monedaDestino);
    }
}
