import Player.Player;
import PlayingPiece.playingPiece;
import PlayingPiece.playingPieceO;
import PlayingPiece.playingPieceX;
import board.Board;


import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {
   Deque<Player>players;
    Board board;
    void initialized(){
        players=new LinkedList<>();
        Player playerX=new Player(new playingPieceX(),"Kajal");
        Player playerO=new Player(new playingPieceO(),"sonam");
        board=new Board(3);
        players.add(playerO);
        players.add(playerX);
    }
    public boolean checkWinner(int row,int column,playingPiece piece){
        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        for(int i=0;i<board.size;i++){
            if(board.board[row][i]==null||board.board[row][i].getType()!=piece.getType()){
                rowMatch=false;
                break;
            }
        }
        for(int i=0;i<board.size;i++){
            if(board.board[i][column]==null||board.board[i][column].getType()!=piece.getType()){
                columnMatch=false;
                break;
            }
        }
        for(int i=0, j=0; i<board.size;i++,j++) {
            if (board.board[i][j] == null || board.board[i][j].getType() != piece.getType()) {
                diagonalMatch = false;
            }
        }

        //need to check anti-diagonals
        for(int i=0, j=board.size-1; i<board.size;i++,j--) {
            if (board.board[i][j] == null || board.board[i][j].getType() != piece.getType()) {
                antiDiagonalMatch = false;
            }
        }

        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;

    }
    public String startGame(){
        boolean noWinner=true;
        while(noWinner){
            Player player=players.removeFirst();
            board.printBoard();
            List<List<Integer>>freeCells=board.getFreeCells();
            if(freeCells.isEmpty()){
                noWinner=false;
                continue;
            }
            System.out.println(player.getName()+" enter your position of "+player.getPiece().getType().name());
            Scanner sc=new Scanner(System.in);
            String s = sc.nextLine();
            String[] values = s.split(",");
            int inputRow = Integer.parseInt(values[0]);
            int inputColumn = Integer.parseInt(values[1]);
            boolean success=board.addPiece(player.getPiece(),inputRow,inputColumn);
            if(!success){
                System.out.println("this position is filled try another");
                players.addFirst(player);
                continue;
            }
           players.addLast(player);
            boolean winner=checkWinner(inputRow,inputColumn,player.getPiece());
            if(winner){
                return player.getName();
            }
        }
        return "tie";
    }
}
