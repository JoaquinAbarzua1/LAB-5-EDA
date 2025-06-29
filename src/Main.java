import java.util.*;

//---------------------------Clase Player----------------------*--

class Player {
    private String playerName;
    private int wins;
    private int draws ;
    private int losses;
    private int jugadas; //para tener eltiro el total de jugadas

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
    public Integer getDraws(){ return this.draws; }
    public Integer getLosses(){ return this.losses; }
    public Integer getTotal() {return this.jugadas;}
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

            List<String> listaActual = winTree.get(players.get(winnerPlayerName).getWins()); //lista donde está actualmente el ganador
            listaActual.remove(players.get(winnerPlayerName)); //lo saco de la lista


            players.get(winnerPlayerName).addWin(); //le agrego la victoria
            List<String> listaNueva = winTree.get(players.get(winnerPlayerName).getWins()); //voy a la lista que corresponde a la nueva cantidad de victorias
            if (listaNueva == null){ //reviso si la lista existe
                listaNueva = new ArrayList<>();
                winTree.put(players.get(winnerPlayerName).getWins(), listaNueva);
            }
            listaNueva.add(winnerPlayerName);
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

    public boolean checkPlayer (String playerName) {
        return players.containsKey(playerName);
    }
    //check player ingresado en el register (creo que igual hay que agregarlo, por más innecesario que sea, el ayudante me dijo que lo ponga igual)

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
        Integer higher = winTree.higherKey(wins); //.higherKey() retorna la llave más pequeña que sea estrictamente mayor
        // que la llave entregada, si no existe, retorna null

        if(higher == null){
            return new Player[0]; // si no hay una llave mayor, retorna nada
        }
        List<Player> result = new ArrayList<>();
        for ( String nombre : winTree.get(higher)){
            result.add(players.get(nombre));
        }
        return result.toArray(new Player[0]);
    }

    public Player getPlayer(String playerName) {
        return players.get(playerName);
    }

}


//-------------------------Clase ConnectFour-----------------------
class ConnectFour {
    char[][] grid;
    char currentSymbol;

    public ConnectFour() {
        grid = new char[7][6];
        for (int fila = 0; fila < 7; fila++) {//llenar todas las filas y columnas con "espacio"
            for (int col = 0; col < 6; col++) {
                grid[fila][col] = ' ';
            }
        }
        this.currentSymbol = 'X';
    }

    public char getCurrentSymbol() { return currentSymbol; }

    public boolean makeMove(int z) {    //z es la columna escogida
        if (z < 0 || z > 5) {
            System.out.println("Movimiento no valido, intentelo de nuevo...");
            return false; }//revisa que la columna escogida sea dentro
        // de las 6 disponibles
        //y también revisa que la fila de más arriba no esté ocupada
        if (grid[0][z] != ' '){
            System.out.println("Columna completa, elija otra");
            return false;
        }

        if (grid[6][z] == ' ') {    //reviso que la fila de más abajo esté libre para hacer el movimiento altiro
            grid[6][z] = currentSymbol;
            if (currentSymbol == 'X') { currentSymbol = 'O'; }
            else if (currentSymbol == 'O') { currentSymbol = 'X'; }
            return true;
        }

        int fila = 0;  //comienzo a revisar desde la fila de más arriba
        while ((grid[fila+1][z] == ' ') && (fila < 5)) {   //reviso que la de abajo esté libre
            fila++;    //sí está libre, me voy a la de abajo
        }

        if (grid[fila][z] == ' ') {    //reviso que esté vacía para hacer el movimiento y retornar true
            grid[fila][z] = currentSymbol;
            if (currentSymbol == 'X') { currentSymbol = 'O'; }
            else if (currentSymbol == 'O') { currentSymbol = 'X'; }
            return true;
        }

        return false;
    }

    public void isGameOver() { } //por ahora void, ni si quiera sé cómo hacer este método


    public void imprimirTablero() {
        for (char [] fila : grid) {//imprimo toda la fila de una
            for (char c : fila) { //recorro cada fila
                System.out.print("|" + c);
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println(" _ _ _ _ _ _ ");
        System.out.println(" 1 2 3 4 5 6 ");
    }


}

//-------------------------Clase Game------------------------

class Game {
    private String status;
    private String winnerPlayerName;
    private String looserPlayerName; //
    private boolean draw;
    private String playerNameA;
    private String playerNameB;
    private ConnectFour ConnectFour;

    public Game (String playerNameA, String playerNameB) {
        ConnectFour = new ConnectFour();
        this.playerNameA = playerNameA;
        this.playerNameB = playerNameB;
        this.status = "IN_PROGRESS";
    }

    public String getWinnerPlayerName() { return winnerPlayerName; }
    public String getLooserPlayerName() { return looserPlayerName; }
    public boolean getDraw() { return draw; }
    public void setStatus(String status) { this.status = status; }

    public String play(){
        char resultado;



        Scanner scanner = new Scanner(System.in);
        while (status.equals("IN_PROGRESS")) { //mientras el juego esté en progreso

            if (ConnectFour.getCurrentSymbol() == 'X') {
                System.out.println("Turno de: " + playerNameA);
            } else if (ConnectFour.getCurrentSymbol() == 'O') {
                System.out.println("Turno de: " + playerNameB);
            }

            ConnectFour.imprimirTablero();//imprime el tablero en cada ciclo


            int columna;
            do { //ciclo que primero ejecuta y luego revisa condición
                System.out.println("Ingrese una columna [1-6]: ");
                columna = scanner.nextInt();
            } while (!ConnectFour.makeMove(columna - 1)); //mientras no se haga un movimiento válido, se repite

            resultado = ConnectFour.isGameOver();
            if(resultado != ' ') {
                ConnectFour.imprimirTablero(); //cuando alguien ganaba no se imprimia la jugada ganadora
                if (resultado == 'D'){
                    status = "DRAW";
                    draw = true;
                    return "EMPATE";

                }
                else if (resultado == 'X'){
                    status = "VICTORY";
                    winnerPlayerName = playerNameA;
                    looserPlayerName = playerNameB;
                    draw = false;

                }
                else if (resultado == 'O'){
                    status = "VICTORY";
                    winnerPlayerName = playerNameB;
                    looserPlayerName = playerNameA;
                    draw = false;
                }
            }
        }
        return winnerPlayerName;
    }
}







public class Main {
    public static void main(String[] args) {
        System.out.println("Prueba");
    }
}
