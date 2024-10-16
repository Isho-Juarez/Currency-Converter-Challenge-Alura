import com.alura.challenge.conversormoneda.funciones.ConvierteMoneda;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner listener = new Scanner(System.in);
        int opcion = 0;
        String cantidad;
        double monto = 0;


        while (true) {
            System.out.println("****************************");
            System.out.println("Sea bienvenido/a al Conversor de Moneda");
            System.out.println("Elija una opción válida:");
            System.out.println("1)Dólar ==> Peso Argentino");
            System.out.println("2)Peso Argentino ==> Dólar");
            System.out.println("3)Dólar ==> Real Brasileño");
            System.out.println("4)Real Brasileño ==> Dólar");
            System.out.println("5)Dólar ==> Peso Colombiano");
            System.out.println("6)Peso Colombiano ==> Dólar");
            System.out.println("7)Salir");
            opcion = listener.nextInt();
            if (opcion == 7) {
                System.out.println("Gracias por utilizar nuestro Conversor de Monedas");
                break;
            } else if (opcion != 7) {
                System.out.println("Ingrese el monto que desea convertir");
                cantidad = listener.next();
                monto = Double.parseDouble(cantidad);
                ConvierteMoneda conversor = new ConvierteMoneda();
                conversor.relacionConversion(opcion,monto);
            }



        }
    }
}