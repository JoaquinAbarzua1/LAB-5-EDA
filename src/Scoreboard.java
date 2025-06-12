
import java.util.Hashtable;
import java.util.Map;

public class Scoreboard {
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

