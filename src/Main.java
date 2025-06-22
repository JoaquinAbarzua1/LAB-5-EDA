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
            players.put(player, p);
            addToWinTree(p);
        }
    }

 //check player ingresado en el register

    public Player[] winRange (int lo, int hi){
            List<Player> result = new Arraylist<>();

            for(Integer ganadas : winTree.keySet()) { //.keySet() retorna un Set (conjunto) de llaves iterables (para recorrerlas)
                if (ganadas >= lo && ganadas <= hi) {
                    List<String> jugadores = winTree.get(ganadas);
                    for (String nombreJugador : jugadores) {
                        result.add(players.get(nombreJugador));
                    }
                }
            }
            return result.toArray(new Player[0]);
        }




    public Player[] winSuccesor (int wins) {
        Interger higher = winTree.higherKey(wins);
        if(higher == null){
            return new Player[0]; // si no hay retorna nada 
        }
        list<Player> result = new Arraylist<>();
        for ( string name : winTree.get(higher)){
        result.add(players.get(name));
        }
        return result.toArray(new Player[0]);
    }


}


//-------------------------Clase ConnectFour-----------------------
class ConnectFour {
    char[][] grid;
    char currentSymbol;

    public ConnectFour() {
        grid = new char[7][6];

        //llenar todas las filas y columnas con "espacio"
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                grid[i][j] = ' ';
            }
        }

        this.currentSymbol = 'X';
    }

    public boolean makeMove(int z) {
    }

    public void isGameOver() {
    } //por ahora void, hay que definir cómo se
    // hará el método

}

//-------------------------Clase Game------------------------
class Game {
    private String status;
    private String winnerPlayerName;
    private String playerNameA;
    private String playerNameB;
    private ConnectFour connectFour;

    public Game (String playerNameA, String playerNameB) {
        connectFour = new ConnectFour();
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
