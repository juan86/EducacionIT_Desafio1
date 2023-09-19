package model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class TorreControl implements ComprobadorContrato{
    List<Volador> listaDeVoladores;

    public TorreControl(){
        listaDeVoladores = new ArrayList<>();
    }

    /**
     * Metodo que da acceso o no a la primera pista siempre.
     * y cuando cumpla el contrato.
     * @param objetoVolador Se recibe un objeto volador para validar.
     * @return Devuelve un booleano dependiendo si cumple con la condicion.
     */
    @Override
    public boolean estaAutorizado(Volador objetoVolador) {
        return objetoVolador.cumploConElContrato();
    }

    /**
     * Metodo que da acceso o no a la segunda pista siempre.
     * y cuando sea de la clase avion o helicoptero.
     * @param objetoVolador Se recibe un objeto volador para validar.
     * @return Devuelve un booleano dependiendo si cumple con la condicion.
     */
    public boolean aterrizarEnSegundaPista(Volador objetoVolador){
        return (objetoVolador instanceof Avion || objetoVolador instanceof Helicoptero);
    }

    public void agregarEsperaAterrizaje(Volador volador){
        listaDeVoladores.add(volador);
    }

    public void validarAterrizajesEnCola(){
        AtomicInteger indice = new AtomicInteger();
        String mensaje = "El objeto volador en la posicion: ";
        listaDeVoladores.forEach(volador -> {
            Class<?> clase = volador.getClass();
            indice.getAndIncrement();
            if(estaAutorizado(volador)){
                System.out.println("El objeto volador "+clase.getSimpleName()+" en la posicion: " +indice+ " esta autorizado para aterrizar en la primera pista");
            } else if (aterrizarEnSegundaPista(volador)) {
                System.out.println("El objeto volador "+clase.getSimpleName()+" en la posicion: " +indice+ " esta autorizado para aterrizar en la segunda pista");
            }else {
                System.out.println("El objeto volador " + clase.getSimpleName() + " en la posicion: " + indice + " No esta autorizado");
            }
        });
    }

}
