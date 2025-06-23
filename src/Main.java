import java.util.*;

//---------------------------Clase Player----------------------*--

class Player {
    private String playerName;
    private int wins;
    private int draws ;
    private int losses;
    private int jugadas; //

    public Player (String playerName) {
        this.playerName = playerName;
        this.wins = 0;
        this.draws = 0;
        this.losses = 0;
        this.jugadas = 0;
    }

    public void addWin(){
        this.wins+=1;
        this.jugadas+=1;
    }
    public void addDraw(){
        this.draws+=1;
        this.jugadas+=1;
    }
    public void addLoss(){
        this.losses+=1;
        this.jugadas+=1;
    }
    public float winRate(){
        if (jugadas == 0){return 0;}
        return (float)wins/(jugadas); //hay que "castear"
        // para poder transformar el entero (wins y jugadas) a float
        // también hay que ver la forma de cortar los decimales, para
        // que el porcentaje quede como entero (13% pero no 13.5%)
    }

    public Integer getWins(){ return this.wins; }
}



//------------------------Clase Scoreboard--------------------------

class Scoreboard {

    private TreeMap<Integer, List<String>> winTree; //Se usa implementación estándar de Java TreeMap
    //Usa List<String> porque varios jugadores pueden tener la misma cantidad de victorias
    private Map<String, Player> players;//Se usa implementación estándar de Java de HashMap
    private int playedGames;

    public Scoreboard() {
        winTree = new TreeMap<>();
        players = new HashMap<>();
        playedGames = 0;

    }

    public void addGameResult (String winnerPlayerName, String looserPlayerName, boolean draw){
        if(draw){
            players.get(looserPlayerName).addDraw();
            players.get(winnerPlayerName).addDraw();
        }
        else{
            players.get(looserPlayerName).addLoss();
            players.get(winnerPlayerName).addWin();
            //falta actualizar winTree, pero hay que ver cómo sacar al jugador, actualizarle sus ganadas
            // y volver a insertarlo donde corresponda
        }
        playedGames++;

    }

    public void registerPlayer (String playerName){
        if(!players.containsKey(playerName)) {
            Player p = new Player(playerName);
            players.put(playerName, p);

            //si aún no se ha creado la lista con 0 ganadas
            if (!winTree.containsKey(0)) {
                winTree.put(0, new ArrayList<>());
            } //crea la lista

            winTree.get(0).add(playerName);
        }
    }

 //check player ingresado en el register

    public Player[] winRange (int lo, int hi){
            List<Player> result = new Arraylist<>();

            for(Integer ganadas : winTree.keySet()) { //.keySet() retorna un Set (conjunto) de llaves iterables (para recorrerlas)
                //"ganadas" es un Integer que recorre todas las llaves del mapa (que también son Integer)
                //entonces "ganadas" irá tomando el valor de cada llave
                if (ganadas >= lo && ganadas <= hi) { //revisa si la llave está dentro del rango buscado
                    List<String> jugadores = winTree.get(ganadas);

                    //"nombreJugador" es un String que recorre cada elemento de la lista que esté en la llave del mapa
                    for (String nombreJugador : jugadores) { //y los va agregando a la lista "result"
                        result.add(players.get(nombreJugador));
                    }
                }
            }
            return result.toArray(new Player[0]);
        }




    public Player[] winSuccesor (int wins) {
        Interger higher = winTree.higherKey(wins); //.higherKey() retorna la llave más pequeña que sea estrictamente mayor
        // que la llave entregada, si no existe, retorna null

        if(higher == null){
            return new Player[0]; // si no hay una llave mayor, retorna nada
        }
        List<Player> result = new Arraylist<>();
        for ( String nombre : winTree.get(higher)){
            result.add(players.get(nombre));
        }
        return result.toArray(new Player[0]);
    }


}


//-------------------------Clase ConnectFour-----------------------
class ConnectFour {
    char[][] grid;
    char currentSymbol;

    public ConnectFour() {
        grid = new char[7][6]; //habría que cambiarlo, el juego original son 6 filas y 7 columnas (aquí son 7 filas 7 6 columnas)
        for (int i = 0; i < 7; i++) {//llenar todas las filas y columnas con "espacio"
            for (int j = 0; j < 6; j++) {
                grid[i][j] = ' ';
            }
        }
        this.currentSymbol = 'X';
    }


    public boolean makeMove(int z) {    //z es la columna escogida
        if (z < 0 || z > 5 || grid[6][z] != ' ') { return false; }//por ahora dejo el método revisando que la columna escogida sean dentro
        // de lass 6 disponibles (en vez de 7 que sería lo original)
        //y también revisa que la fila de más arriba no esté ocupada

        if (grid[0][z] == ' ') {    //reviso que la fila de más abajo esté libre para hacer el movimiento de una
            grid[0][z] = currentSymbol;
            if (currentSymbol == 'X') { currentSymbol = 'O'; }
            else if (currentSymbol == 'O') { currentSymbol = 'X'; }
            return true;
        }

        int i = 6;  //comienzo a revisar desde la fila de más arriba
        while (grid[i-1][z] == ' ') {   //reviso que la de abajo esté libre
            i--;    //sí está libre, me voy a la de abajo
        }

        if (grid[i][z] == ' ') {    //reviso que esté vacía para hacer el movimiento y retornar true
            grid[i][z] = currentSymbol;
            if (currentSymbol == 'X') { currentSymbol = 'O'; }
            else if (currentSymbol == 'O') { currentSymbol = 'X'; }
            return true;
        }
        return false;
    }

    public void isGameOver() { } //por ahora void, ni si quiera sé cómo hacer este método

}

//-------------------------Clase Game------------------------

class Game {
    private String status;
    private String winnerPlayerName;
    private String playerNameA;
    private String playerNameB;
    private ConnectFour ConnectFour;

    public Game (String playerNameA, String playerNameB) {
        ConnectFour = new ConnectFour();
        this.playerNameA = playerNameA;
        this.playerNameB = playerNameB;
        this.status = "IN_PROGRESS";
    }

    public void play(){ //tremendo método, hay que analizar

    }
}








public class Main {
    public static void main(String[] args) {
        System.out.println("Prueba");
    }
}
