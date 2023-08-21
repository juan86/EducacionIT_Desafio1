package model.domain;

public class Alumno {
    private String nombre;
    private String apellido;
    private int numeroDeExamen;
    private double nota;

    public Alumno(String nombre, String apellido, int numeroDeExamen, double nota){
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroDeExamen = numeroDeExamen;
        this.nota = nota;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getNumeroDeExamen(){
        return numeroDeExamen;
    }

    public double getNota() {
        return nota;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alumno alumno = (Alumno) o;
        return nombre.equals(alumno.getNombre()) && apellido.equals(alumno.getApellido());
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nombre ='" + nombre + '\'' +
                ", apellido ='" + apellido + '\'' +
                ", N° de Examen ='" + numeroDeExamen + '\'' +
                ", nota =" + nota +"}\n";
    }
}
