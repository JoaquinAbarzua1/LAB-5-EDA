//---------------------------Clase Player----------------------*--

import java.util.Hashtable;
import java.util.Map;

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
    //no sé realmente cómo se debe implementar esto
    //hay que buscar en las clases del profe o no sé
    private Map<Integer, String> winTree;

    private Hashtable<String, Player> players;

    private int playedGames;

    public Scoreboard() {}

    //dejo escrito los métodos por mientras, aún no sé cómo debo manejar los atributos
    public void addGameResult (String winnerPlayerName, String looserPlayerName, boolean draw){ ;}

    public void registerPlayer (String playerName){}

    public void checkPlayer (String playerName){}

    public Player[] winRange (int lo, int hi){}

    public Player[] winSuccesor (int wins) {}


}

//------------------------Clase implementación BST------------------------
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

//---------------------Clase HashST--------------------------------
class HashST{}


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