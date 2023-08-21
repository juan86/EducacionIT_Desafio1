package model.domain;

public class GestorDeAlumnos {
    private Alumno[] alumnos;
    private int ultimoAlumno;

    public GestorDeAlumnos(int cantidadDeAlumnos){
        alumnos = new Alumno[cantidadDeAlumnos];
        ultimoAlumno = 0;
    }

    public void registrarAlumno(Alumno alumno){
        this.alumnos[ultimoAlumno] = alumno;
        ultimoAlumno++;
    }

    public Alumno calificacionMasAlta(){
        if(ultimoAlumno == 0) return null;

        Alumno alumnoConMayorNota = alumnos[0];

        for(int i = 1; i < alumnos.length; i++){
            if(alumnos[i].getNota() > alumnoConMayorNota.getNota()) alumnoConMayorNota = alumnos[i];
        }

        return alumnoConMayorNota;
    }

    public Alumno calificacionMasBaja(){
        if(ultimoAlumno == 0) return null;

        Alumno alumnoConMenorNota = alumnos[0];

        for(int i = 1; i < alumnos.length; i++){
            if(alumnos[i].getNota() < alumnoConMenorNota.getNota()) alumnoConMenorNota = alumnos[i];
        }

        return alumnoConMenorNota;
    }

    public String AlumnosQuePromocionan(){
        String listaPromocion = "";

        if(ultimoAlumno == 0) return "No hay Alumnos";

        int contadorDeAlumnosSinRepetir = 0;
        Alumno[] alumnosSinRepetir = getAlumnosSinRepetir();

        while(alumnosSinRepetir[contadorDeAlumnosSinRepetir] != null){
            if(getPromedioAlumno(alumnosSinRepetir[contadorDeAlumnosSinRepetir]) >= 7){
                String nombreCompleto = alumnosSinRepetir[contadorDeAlumnosSinRepetir].getNombre() +" "+ alumnosSinRepetir[contadorDeAlumnosSinRepetir].getApellido()+"\n";
                listaPromocion += nombreCompleto;
            }
            contadorDeAlumnosSinRepetir++;
        }
        return listaPromocion;
    }

    public String AlumnosQueRecursan(){
        String listaRecursantes = "";

        if(ultimoAlumno == 0) return "No hay Alumnos";

        int contadorDeAlumnosSinRepetir = 0;
        Alumno[] alumnosSinRepetir = getAlumnosSinRepetir();

        while(alumnosSinRepetir[contadorDeAlumnosSinRepetir] != null){
            if(getPromedioAlumno(alumnosSinRepetir[contadorDeAlumnosSinRepetir]) < 7){
                String nombreCompleto = alumnosSinRepetir[contadorDeAlumnosSinRepetir].getNombre() +" "+ alumnosSinRepetir[contadorDeAlumnosSinRepetir].getApellido()+"\n";
                listaRecursantes += nombreCompleto;
            }
            contadorDeAlumnosSinRepetir++;
        }
        return listaRecursantes;
    }

    public String getListaAlumnosRegistrados(){
        String listaAlumnos = "";

        if(ultimoAlumno == 0) return listaAlumnos;

        Alumno[] alumnosRegistrados = getAlumnosSinRepetir();
        int contadorAlumnos = 0;

        if(alumnosRegistrados != null ) {
            while(contadorAlumnos < alumnosRegistrados.length && alumnosRegistrados[contadorAlumnos] != null){
                listaAlumnos += "Alumno "+(contadorAlumnos+1)+": "+alumnosRegistrados[contadorAlumnos].getNombre() +" "+alumnosRegistrados[contadorAlumnos].getApellido()+"\n";
                contadorAlumnos++;
            }
        }



        return listaAlumnos;
    }
    private double getPromedioAlumno(Alumno alumno){
        int cantidadDeNotas = 0;
        double sumatoriaDeNotas = .0;

        for(int i = 0; i < alumnos.length; i++){
            if(alumno.equals(alumnos[i])){
                cantidadDeNotas++;
                sumatoriaDeNotas += alumnos[i].getNota();
            }
        }

        return sumatoriaDeNotas / cantidadDeNotas;
    }

    private Alumno[] getAlumnosSinRepetir(){
        Alumno[] alumnosSinRepetir = new Alumno[alumnos.length];

        if(alumnos[0] == null) return null;

        int contadorAlunossinRepetir = 0;
        for(int i = 0; i < alumnos.length; i++){
            if(!estaRepetido(alumnosSinRepetir, alumnos[i])){
                alumnosSinRepetir[contadorAlunossinRepetir] = alumnos[i];
                contadorAlunossinRepetir++;
            }
        }
        return alumnosSinRepetir;
    }

    private boolean estaRepetido(Alumno[] alumnos, Alumno alumno){
        for(int i = 0; i < alumnos.length; i++){
            if(alumno.equals(alumnos[i])) return true;
        }
        return false;
    }
}
