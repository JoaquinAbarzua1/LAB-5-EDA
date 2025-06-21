import java.util.*

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

    private TreeMap<Integer, List<String>> winTree;
    
    //Se usa implementación estándar de Java TreeMap (por ahora hasta que me lo aclaren)
    //Usa List<String> porque varios jugadores pueden tener la misma cantidad de victorias


    private Map<String, Player> players;//Se usa implementación estándar de Java de HashMap (por ahora hasta que me lo aclaren)

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
            playedGames++;
        }
        else{
            players.get(looserPlayerName).addLoss();
            players.get(winnerPlayerName).addWin();
            playedGames++;
        }

    }

    public void registerPlayer (String playerName){
        if(!players.containsKey(playerName)){
            Player p = new Player(playerName);
            palyers.put(player , p ) ;
            addToWinTree(p);
    }

 //check player ingresado en el register

    public Player[] winRange (int lo, int hi){
     List<player> result = new Arraylist<>();
        // con un for tal vez recorriendo el mapa 
        // no sabria como avanzar aca 
       
        }
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

/*
//------------------------Clase implementación BST (por ahora usaré TreeMap que es la implementación estándar de Java, le preguntaré al profe Karol------------------------
//implementación según el libro del profe

class BST<Key extends Comparable<Key>, Value> {

    private Node root;

    //Nodos del arbol
    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        public Node(Key key, Value val) {
            this.key = key;
            this.val = val;
        }
    }
    //método recursivo para colocar elementos en el arbol
    public void put(Key key, Value val) { root = put(root, key, val); }

    private Node put(Node node, Key key, Value val) {
        if (node == null) { return new Node(key, val); } //si el arbol está vacío, crea el nodo raiz o padre

        int cmp = key.compareTo(node.key); //crea un comparador, en este caso, compara la clave que será el
        // número de victorias

        if (cmp < 0) { node.left = put(node.left, key, val); }//si la clave del nodo que quiero insertar es menor que la
        // clave del nodo que estoy viendo, me voy por la izquierda

        else if (cmp > 0) { node.right = put(node.right, key, val); }//si la clave es mayor, me voy por la derecha

        else { node.val = val; }

        return node;
    }

    //método que retorna el valor (nombre del jugador, o supuestamente la lista de jugadores)
    // asociado a la clave (numero de victorias)
    public Value get(Key key) {
        Node node = root;
        while (node != null) {
            int cmp = key.compareTo(node.key);
            if (cmp < 0) { node = node.left; }
            else if (cmp > 0) { node = node.right; }
            else { return node.val; }
        }
        return null; //retorna null en caso de que no hayan jugadores con esta cantidad de victorias
    }

    //no sé si habrá que agregar más métodos, pero esto es lo mínimo que se pide
}
*/




/*
//---------------------Clase HashST--------------------------------
class HashST{}

*/



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
