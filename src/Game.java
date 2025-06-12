public class Game {
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
