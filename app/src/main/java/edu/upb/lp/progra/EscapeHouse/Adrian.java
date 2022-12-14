package edu.upb.lp.progra.EscapeHouse;

public class Adrian extends Jugador{
    public Adrian(EscapeHouse game, String img,int row,int column){
        super(game,img,row,column);
    }
    @Override
    public String habilidadToString() {
        return "Adrian: Jejeje Tengo suerte";
    }

    @Override
    public void moverse() {

    }
}
