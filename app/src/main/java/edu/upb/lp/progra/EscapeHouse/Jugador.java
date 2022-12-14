package edu.upb.lp.progra.EscapeHouse;

public abstract class Jugador extends Personaje{
    public Jugador(EscapeHouse game,String img, int row,int column) {
        super(game,img,row,column);

    }
    public abstract String habilidadToString();

}
