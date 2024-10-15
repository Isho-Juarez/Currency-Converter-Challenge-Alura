import com.alura.challenge.conversormoneda.funciones.InfoAPI;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner listener = new Scanner(System.in);
        InfoAPI consulta = new InfoAPI();
        consulta.obtenInfoAPI("USD");

        while (true) {
            if (listener.nextInt() == 7) {
                break;
            }
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
        }
    }
}