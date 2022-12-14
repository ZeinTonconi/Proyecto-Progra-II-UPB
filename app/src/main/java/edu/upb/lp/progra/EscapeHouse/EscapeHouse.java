package edu.upb.lp.progra.EscapeHouse;

import android.util.Pair;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EscapeHouse {
    private int numberRows = 8;
    private int numberColumns = 12;
    private int numberHabs = 1;
    private  EscapeHouseUI ui;
    private boolean selectingCharacter = false;
    private Jugador player;

    public EscapeHouse(EscapeHouseUI ui) {
        this.ui = ui;
    }

    private Casilla[][][] mapa = new Casilla[numberHabs][numberRows][numberColumns];

    public void initGame() throws NotSelectedPlayerException{
        if(player == null)
            throw new NotSelectedPlayerException();
        selectingCharacter=false;

        iniciarHabitaciones();
        //TODO poner enemigos y al jugador

    }

    public void cambiarPantalla(int id) {
        ui.drawScreen(numberRows,numberColumns, mapaString(id));
    }

    private String[][] mapaString(int id) {
        String[][] mapaImg=new String[numberRows][numberColumns];
        for(int i=0;i<numberRows;i++){
            for(int j=0;j<numberColumns;j++){
                mapaImg[i][j]=mapa[id][i][j].getImagen();
            }
        }
        return mapaImg;
    }

    private void iniciarHabitaciones(){
        for(int i=0;i<numberHabs;i++){
            mapa[i][6][0]= new Casilla("escape_button_left",false);
            mapa[i][7][1]= new Casilla("escape_button_down",false);
            mapa[i][6][2]= new Casilla("escape_button_right",false);
            mapa[i][5][1]= new Casilla("escape_button_up",false);
            mapa[i][6][10]= new Casilla("escape_button_especial",false);
        }
        //TODO poner a los enemigos y q sean fijos


        // TODO posicionar los objetos aleatoriamente

        // Configuracion Fija
        //TODO poner objetos
        for(int i=0;i<numberHabs;i++){
            for(int j=0;j<numberRows;j++){
                for(int k=0;k<numberColumns;k++){
                    if(mapa[i][j][k]==null){
                        mapa[i][j][k]=new Casilla("escape_mapa_0_piso",true);
                    }
                }
            }
        }
        // Random
        // TODO
    }

    public String[] charactersMenu(){
        String[] characters = new String[3];
        for(int i=1;i<=3;i++){
            characters[i-1]="escape_character_"+i+"_unselected";
        }
        return characters;
    }

    public void selectCharacter() {
        ui.drawScreen(1,3, new String[][]{charactersMenu()});
        selectingCharacter = true;
    }

    public void cellPressed(int vertical, int horizontal) {
        if(selectingCharacter){
            if(horizontal==0) player = new Zein("escape_character_1");
            if(horizontal==1) player = new Gael("escape_character_2");
            if(horizontal==2) player = new Adrian("escape_character_3");
            String[] character = charactersMenu();
            character[horizontal]="escape_character_"+(horizontal+1);
            ui.drawScreen(1,3,new String[][]{character});
            ui.eliminarTexto("Habilidad");
            ui.mostrarTexto(player.habilidadToString());
        }
        else{

        }
    }

}
