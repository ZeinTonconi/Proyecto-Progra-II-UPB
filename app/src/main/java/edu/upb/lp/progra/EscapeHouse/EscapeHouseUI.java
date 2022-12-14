package edu.upb.lp.progra.EscapeHouse;

import android.text.style.IconMarginSpan;

import edu.upb.lp.progra.adapterFiles.AndroidGameGUI;
import edu.upb.lp.progra.adapterFiles.UI;

public class EscapeHouseUI implements UI {
    private AndroidGameGUI gui;
    private EscapeHouse game;

    public EscapeHouseUI(AndroidGameGUI gui){
        this.gui=gui;
        game = new EscapeHouse(this);
    }

    @Override
    public void onButtonPressed(String name) {
        if(name == "Start"){
            gui.configureScreen(1,3,0,0,false,0.2);
            game.selectCharacter();
            gui.removeButton("Start");
            gui.addButton("Select", 20, 50);
        }
        if(name == "Select"){
            try {
                game.initGame();
                gui.removeButton("Select");
                gui.configureScreen(8,12,0,0,false,0);
                game.cambiarPantalla(0);
            } catch (NotSelectedPlayerException e){
                gui.showTemporaryMessage("Seleccione un personaje");
                return;
            }
        }
    }

    @Override
    public void onCellPressed(int vertical, int horizontal) {
        game.cellPressed(vertical,horizontal);
    }

    @Override
    public void initialiseInterface() {
        gui.configureScreen(1,1,1,1,false,0.2);
        gui.setImageOnCell(0,0,"escape_portrait");
        gui.addButton("Start",20,50);

    }

    public void drawScreen(int numberRows,int numberColumns,String[][] screen){
        int id=0;
        for(int i=0;i<screen.length;i++){
            for(int j=0;j<screen[i].length;j++){
                System.out.println(screen[i][j]);
            }
        }
        for(int i=0;i<numberRows;i++){
            for(int j=0;j<numberColumns;j++){
                gui.setImageOnCell(i,j,screen[i][j]);
                id++;
            }
        }
    }
    public void mostrarTexto(String text){
        gui.addTextField("Habilidad",text,20,50);
    }

    public void eliminarTexto(String text) {
        gui.removeTextField(text);
    }
}
