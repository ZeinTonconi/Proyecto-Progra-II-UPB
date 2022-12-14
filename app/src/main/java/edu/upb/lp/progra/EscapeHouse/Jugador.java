package edu.upb.lp.progra.EscapeHouse;

public abstract class Jugador extends Personaje{
    public Jugador(String img) {
        super(img);
    }

    public abstract String habilidadToString();

}
