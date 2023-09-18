import utils.ValidadorFecha;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese una fecha en formato dd/mm/yyyy:");
        String fechaIngresada = scanner.nextLine();

        if(ValidadorFecha.esValida(fechaIngresada)){
            System.out.println("La fecha ingresada: "+fechaIngresada+" Es valida");
        }
    }
}