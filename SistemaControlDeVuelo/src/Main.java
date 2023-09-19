import model.*;

public class Main {
    public static void main(String[] args) {
        TorreControl torreControlEzeiza = new TorreControl();

        torreControlEzeiza.agregarEsperaAterrizaje(new Avion(true));
        torreControlEzeiza.agregarEsperaAterrizaje(new Avion(false));
        torreControlEzeiza.agregarEsperaAterrizaje(new Zeppelin(true));
        torreControlEzeiza.agregarEsperaAterrizaje(new Zeppelin(false));
        torreControlEzeiza.agregarEsperaAterrizaje(new Helicoptero(true));
        torreControlEzeiza.agregarEsperaAterrizaje(new Helicoptero(false));
        torreControlEzeiza.agregarEsperaAterrizaje(new AutoVolador(false));
        torreControlEzeiza.agregarEsperaAterrizaje(new AutoVolador(false));

        torreControlEzeiza.validarAterrizajesEnCola();
    }
}
