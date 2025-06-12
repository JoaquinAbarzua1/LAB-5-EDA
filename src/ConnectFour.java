public class ConnectFour {
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

    public boolean makeMove(int z){}

    public void isGameOver(){} //por ahora void, hay que definir cómo se
    // hará el método

    public
}
