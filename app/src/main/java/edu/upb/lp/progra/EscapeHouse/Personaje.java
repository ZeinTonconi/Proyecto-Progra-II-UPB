package edu.upb.lp.progra.EscapeHouse;

public abstract class Personaje {
    private String img;
    public Personaje(String img) {
        this.img=img;
    }
    public String getImg(){
        return img;
    }
    public abstract void moverse();
}
