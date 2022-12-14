package edu.upb.lp.progra.EscapeHouse;

public class Zein extends Jugador {

    public Zein(EscapeHouse game,String img,int row,int column){
        super(game,img,row,column);
    }

    @Override
    public String habilidadToString() {
        return "Zein: Booo! Puedo ser un fantasma por 5 seg";
    }

    @Override
    public void moverse() {

    }
}
