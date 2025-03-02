import java.util.Deque;
import java.util.LinkedList;

public class Game {
    Board board;
    Deque<Player>players;
    Dice dice;
    public Game(){
        initialize();
    }
    void initialize(){
        board=new Board(10,5,5);
        Player player1=new Player("Kajal");
        Player player2=new Player("sonam");
        players=new LinkedList<>();
        players.add(player1);
        players.add(player2);
        dice=new Dice();
    }
    Player findPlayerTurn(){
        Player playerTurns = players.removeFirst();
        players.addLast(playerTurns);
        return playerTurns;
    }
    void start(){
        boolean noWinner=true;
       // board.printBoard();
        String winner = "";
        while(noWinner){
            //check whose turn now
            Player playerTurn = findPlayerTurn();
            System.out.println("player turn is:" + playerTurn.getName() + " current position is: " + playerTurn.currentPosition);

            //roll the dice
            int diceNumbers = dice.roll();

            //get the new position
            int playerNewPosition = playerTurn.currentPosition + diceNumbers;
            playerNewPosition = jumpCheck(playerNewPosition);
            playerTurn.currentPosition = playerNewPosition;

            System.out.println("player turn is:" + playerTurn.getName() + " new Position is: " + playerNewPosition);
            //check for winning condition
            if(playerNewPosition >= board.board.length * board.board.length){

               noWinner=false;
               winner=playerTurn.getName();

            }
       }
        System.out.println(winner+ " won the game");
}

    private int jumpCheck(int playerNewPosition) {
        if(playerNewPosition > board.board.length * board.board.length-1 ){
            return playerNewPosition;
        }

        Cell cell = board.getCell(playerNewPosition);
        if(cell.jump != null && cell.jump.start == playerNewPosition) {
            String jumpBy = (cell.jump.start < cell.jump.end)? "ladder" : "snake";
            System.out.println("jump done by: " + jumpBy);
            return cell.jump.end;
        }
        return playerNewPosition;

    }
    }
