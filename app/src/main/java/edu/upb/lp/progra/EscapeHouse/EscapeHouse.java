package edu.upb.lp.progra.EscapeHouse;

public class EscapeHouse {
    private int numberRows = 8;
    private int numberColumns = 12;
    private int numberHabs = 1;
    private  EscapeHouseUI ui;
    private boolean selectingCharacter = false;
    private Jugador player;
    private int habJugador = 0;


    public EscapeHouse(EscapeHouseUI ui) {
        this.ui = ui;
    }

    public int getNumberRows() {
        return numberRows;
    }

    public int getNumberColumns(){
        return numberColumns;
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
        mapaImg[player.getFila()][player.getColumna()] = player.getImg();
        for(int i=0;i<numberRows;i++){
            for(int j=0;j<numberColumns;j++){
                if(mapaImg[i][j]==null)
                    mapaImg[i][j]=mapa[id][i][j].getImagen();
            }
        }
        return mapaImg;
    }


    private void iniciarHabitaciones(){
        for(int i=0;i<numberHabs;i++){
            mapa[i][numberRows-2][0]= new Casilla("escape_button_left",false);
            mapa[i][numberRows-1][1]= new Casilla("escape_button_down",false);
            mapa[i][numberRows-2][2]= new Casilla("escape_button_right",false);
            mapa[i][numberRows-3][1]= new Casilla("escape_button_up",false);
            mapa[i][numberRows-2][numberColumns-1]= new Casilla("escape_button_especial",false);
            mapa[i][numberRows-1][numberColumns-3] = new Casilla("escape_button_interactuar",false);
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
            if(horizontal==0) player = new Zein(this,"escape_character_1",0,2);
            if(horizontal==1) player = new Gael(this,"escape_character_2",0,2);
            if(horizontal==2) player = new Adrian(this,"escape_character_3",0,2);
            String[] character = charactersMenu();
            character[horizontal]="escape_character_"+(horizontal+1);
            ui.drawScreen(1,3,new String[][]{character});
            ui.eliminarTexto("Habilidad");
            ui.mostrarTexto(player.habilidadToString());
        }
        else{
            // Si estamos presionando un boton de movimiento
            // si es asi le decimos al objeto jugador q se mueva
            // el jugador deberia saber como moverse


            if(vertical == 5 && horizontal == 1){
                player.subir();
            } else if(vertical == 6 && horizontal == 2){
                player.derecha();
            } else if(vertical == 7 && horizontal == 1){
                player.bajar();
            } else if(vertical == 6 && horizontal == 0){
                player.izquierda();
            }





        }
    }


    public boolean puedoEntrar(int fila, int columna) {
        return mapa[habJugador][fila][columna].isPuedoEntrar();
    }

    public void dibujar(int fila, int columna) {
        String img = mapa[habJugador][fila][columna].getImagen();
        if(player.getFila()==fila && player.getColumna()==columna)
            img=player.getImg();
        //TODO dibujar enemigo
        ui.drawOnCell(fila,columna,img);
    }
}
