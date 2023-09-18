package utils;

public class ValidadorFecha {

    public ValidadorFecha(){}

    public static boolean esValida(String fechaIngresada){
        String[] partes = fechaIngresada.split("/");

        if (partes.length != 3) {
            System.out.println("Formato de fecha incorrecto. Debe ser dd/mm/yyyy.");
            return false;
        }

        int dia = Integer.parseInt(partes[0]);
        int mes = Integer.parseInt(partes[1]);
        int anio = Integer.parseInt(partes[2]);

        // Validar el día
        if (dia < 1 || dia > 31) {
            System.out.println("El día debe estar entre 1 y 31.");
            return false;
        }

        // Validar el mes
        if (mes < 1 || mes > 12) {
            System.out.println("El mes debe estar entre 1 y 12.");
            return false;
        }

        // Validar el año
        if (anio < 1900 || anio > 2099) {
            System.out.println("El año debe estar entre 1900 y 2099.");
            return false;
        }

        // Validar febrero en caso de año bisiesto
        boolean esBisiesto = (anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0);
        if (mes == 2 && (dia > 29 || (dia > 28 && !esBisiesto))) {
            System.out.println("Febrero tiene 28 o 29 días dependiendo del año bisiesto.");
            return false;
        }

        return true;
    }
}
