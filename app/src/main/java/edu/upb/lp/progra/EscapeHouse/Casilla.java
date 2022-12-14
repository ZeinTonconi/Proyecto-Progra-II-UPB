package edu.upb.lp.progra.EscapeHouse;

public class Casilla {
    private String imagen;
    private boolean puedoEntrar;
    public Casilla (String img, boolean puedoEntrar){
        this.imagen = img;
        this.puedoEntrar = puedoEntrar;
    }
    public String getImagen(){
        return imagen;
    }

    public boolean isPuedoEntrar(){
        return puedoEntrar;
    }
}
