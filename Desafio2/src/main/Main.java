package main;

import model.domain.Alumno;
import model.domain.GestorDeAlumnos;

import java.util.Scanner;

public class Main {
        private static Scanner input = new Scanner(System.in);
        private static GestorDeAlumnos gestorAlumnos;
        private static boolean correrPrograma = true;
    public static void main(String[] arg){
        System.out.print("Cantidad de Alumnos a gestionar: ");
        int cantidadDeAlumnos = input.nextInt();
        gestorAlumnos = new GestorDeAlumnos(cantidadDeAlumnos);

        do{
            System.out.println("╔=========================================================╗");
            System.out.println("║ Bienvenido al gestor de notas de Alumnos de EducacionIT ║");
            System.out.println("╠=========================================================╣");
            System.out.println("║                                                         ║");
            System.out.println("║ 1. Registrar Alumno.                                    ║");
            System.out.println("║ 2. Alumno con calificacion mas alta.                    ║");
            System.out.println("║ 3. Alumno con calificacion mas baja.                    ║");
            System.out.println("║ 4. Alumnos que Promocionan.                             ║");
            System.out.println("║ 5. Alumnos que Recursan.                                ║");
            System.out.println("║ 6. Ver alumnos Registrados                              ║");
            System.out.println("║ 7. Salir.                                               ║");
            System.out.println("║                                                         ║");
            System.out.println("║ Ingrese el numero de la opcion para continuar.          ║");
            System.out.println("║                                                         ║");
            System.out.println("╚=========================================================╝");
            System.out.print("Opcion: ");
            int opcion = input.nextInt();
            System.out.println("Valor ingresado: "+opcion);

            switch (opcion){
                case 1:
                    opcion1(cantidadDeAlumnos);
                    break;
                case 2:
                    opcion2();
                    break;
                case 3:
                    opcion3();
                    break;
                case 4:
                    opcion4();
                    break;
                case 5:
                    opcion5();
                    break;
                case 6:
                    opcion6();
                    break;
                case 7:
                    correrPrograma = false;
                    break;
                default:
                    System.out.println("Valor invalido...");
            }

        }while (correrPrograma);

        System.out.println("Fin del programa...");

    }

    private static void opcion1(int cantidadDeRegistros){
        if(cantidadDeRegistros <= 0){
            System.out.println("No hay cupos...");
            return;
        }

        for (int i = 0; i < cantidadDeRegistros; i++) {
            System.out.println("╔=======================╗");
            System.out.println("║ 1. Registro de Alumno ║");
            System.out.println("╚=======================╝");
            System.out.println("");
            System.out.print("Ingrese el nombre del alumno: ");
            String nombre = input.next();
            System.out.print("Ingrese el apellido del alumno: ");
            String apellido = input.next();
            System.out.print("Ingrese el numero de examen: ");
            int numeroExamen = input.nextInt();
            System.out.print("Ingrese la nota de la materia: ");
            double notaExamen = input.nextDouble();
            gestorAlumnos.registrarAlumno(new Alumno(nombre, apellido, numeroExamen, notaExamen));
        }
    }
    private static void opcion2(){
        System.out.println("╔======================================╗");
        System.out.println("║ 2. Alumno con calificacion mas alta. ║");
        System.out.println("╚======================================╝");
        System.out.println("");
        Alumno alumno = gestorAlumnos.calificacionMasAlta();
        if (alumno == null){
            System.out.println("No hay Alumnos");
        }else{
            System.out.println(alumno);
        }
    }

    private static void opcion3(){
        System.out.println("╔======================================╗");
        System.out.println("║ 3. Alumno con calificacion mas baja. ║");
        System.out.println("╚======================================╝");
        System.out.println("");
        Alumno alumno = gestorAlumnos.calificacionMasBaja();
        if (alumno == null){
            System.out.println("No hay Alumnos");
        }else{
            System.out.println(alumno);
        }
    }

    private static void opcion4(){
        System.out.println("╔=============================╗");
        System.out.println("║ 4. Alumnos que Promocionan. ║");
        System.out.println("╚=============================╝");
        System.out.println("");
        System.out.println("Alumnos que promocionan: ");
        System.out.println(gestorAlumnos.AlumnosQuePromocionan());
    }

    private static void opcion5(){
        System.out.println("╔==========================╗");
        System.out.println("║ 5. Alumnos que Recursan. ║");
        System.out.println("╚==========================╝");
        System.out.println("");
        System.out.println("Alumnos que recursan: ");
        System.out.println(gestorAlumnos.AlumnosQueRecursan());
    }

    private static void opcion6(){
        System.out.println("╔============================╗");
        System.out.println("║ 6. Ver alumnos Registrados ║");
        System.out.println("╚============================╝");
        String listaDeAlumnos = gestorAlumnos.getListaAlumnosRegistrados();

        if(listaDeAlumnos.equals("")) {
            listaDeAlumnos = "Sin Alumnos registrados";
        }

        System.out.println(listaDeAlumnos);
    }

}