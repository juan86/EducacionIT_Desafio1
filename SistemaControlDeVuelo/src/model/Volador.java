package model;

public class Volador {
    private boolean cumpleContrato;

    public Volador(boolean cumpleContrato){
        this.cumpleContrato = cumpleContrato;
    }

    public boolean cumploConElContrato(){
        return cumpleContrato;
    }
}
