package model.domain;

public class Alumno {
    private String nombre;
    private String apellido;
    private double nota;

    public Alumno(String nombre, String apellido, double nota){
        this.nombre = nombre;
        this.apellido = apellido;
        this.nota = nota;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public double getNota() {
        return nota;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", nota=" + nota +
                '}';
    }
}
