package edu.upb.lp.progra.EscapeHouse;

public class Gael extends Jugador{
    public Gael(EscapeHouse game, String img,int row,int column) {
        super(game,img,row,column);
    }

    @Override
    public String habilidadToString() {
        return "Gael: Estoy mamado!!! Aturdo a los enemigos";
    }

    @Override
    public void moverse() {

    }
}
