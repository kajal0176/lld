public class Main {
    public static void main(String[] args) {

        TicTacToeGame game=new TicTacToeGame();
        game.initialized();
        String winner=game.startGame();
        System.out.println("congratulation "+winner+" you won the game");
    }
}