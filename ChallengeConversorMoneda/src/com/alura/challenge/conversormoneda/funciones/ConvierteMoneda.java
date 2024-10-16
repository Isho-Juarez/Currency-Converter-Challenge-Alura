package com.alura.challenge.conversormoneda.funciones;

public class ConvierteMoneda {

    public void relacionConversion(int conversion, double montoAConvertir) {
        if (conversion==1||conversion==3||conversion==5){
            InfoAPI consulta = new InfoAPI();
            consulta.obtenInfoAPI("USD");
            double monedaLat = 1;
            if (conversion==1){
                monedaLat = consulta.valores.get(1);
                System.out.println("El valor en Pesos Argentinos es:");
            } else if (conversion==3) {
                monedaLat = consulta.valores.get(2);
                System.out.println("El valor en Reales Brasileños es:");
            } else if (conversion==5) {
                monedaLat = consulta.valores.get(3);
                System.out.println("El valor en Pesos Colombianos es:");
            }
            double montoConvertido = montoAConvertir*monedaLat;
            System.out.println(montoConvertido);
        } else if (conversion==2) {
            InfoAPI consulta = new InfoAPI();
            consulta.obtenInfoAPI("ARS");
            double montoConvertido = montoAConvertir * consulta.valores.get(3);
            System.out.println("U$D"+montoConvertido);
        } else if (conversion==4) {
            InfoAPI consulta = new InfoAPI();
            consulta.obtenInfoAPI("BRL");
            double montoConvertido = montoAConvertir * consulta.valores.get(3);
            System.out.println("U$D"+montoConvertido);
        } else if (conversion==6) {
            InfoAPI consulta = new InfoAPI();
            consulta.obtenInfoAPI("COP");
            double montoConvertido = montoAConvertir * consulta.valores.get(3);
            System.out.println("U$D"+montoConvertido);
        }
    }




}
