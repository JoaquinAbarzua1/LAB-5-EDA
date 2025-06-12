public class Player {
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
