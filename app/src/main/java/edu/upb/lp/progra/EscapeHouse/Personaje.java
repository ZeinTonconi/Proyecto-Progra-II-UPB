package edu.upb.lp.progra.EscapeHouse;

public abstract class Personaje {
    private String img;
    private int fila, columna;
    private EscapeHouse game;
    public Personaje(EscapeHouse game,String img, int fila, int columna) {
        this.img=img;
        this.columna = columna;
        this.fila = fila;
        this.game = game;
    }
    public String getImg(){
        return img;
    }
    public int getFila(){
        return fila;
    }
    public int getColumna(){
        return columna;
    }
    public abstract void moverse();

    public boolean puedoEntrar(int nrow,int ncolumn){
        return (nrow>=0 && nrow<game.getNumberRows() && ncolumn>=0 && ncolumn< game.getNumberColumns() && game.puedoEntrar(nrow,ncolumn));
    }

    public void subir(){
        if(puedoEntrar(fila-1,columna)) {
            fila--;
            game.dibujar(fila+1,columna);
            game.dibujar(fila,columna);
        }
    }
    public void derecha(){
        if(puedoEntrar(fila,columna+1)){
            columna++;
            game.dibujar(fila,columna-1);
            game.dibujar(fila,columna);
        }
    }
    public void bajar(){
        if(puedoEntrar(fila+1,columna)){
            fila++;
            game.dibujar(fila-1,columna);
            game.dibujar(fila,columna);
        }

    }
    public void izquierda(){
        if(puedoEntrar(fila,columna-1)){
            columna--;
            game.dibujar(fila,columna+1);
            game.dibujar(fila,columna);
        }
    }
}
