package board;

import PlayingPiece.playingPiece;

import java.util.*;

public class Board {
   public playingPiece [][]board;
   public int size;
    public Board(int size){
        this.size=size;
        board=new playingPiece[size][size];
    }
    public boolean addPiece(playingPiece piece,int row,int column){
        if(board[row][column]!=null){

            return false;
        }
        board[row][column]=piece;
        return true;
    }
    public List<List<Integer>>getFreeCells(){
        List<List<Integer>> freeCells = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == null) {
                    List<Integer>rowColumn=new ArrayList<>();
                    rowColumn.add(i);
                    rowColumn.add(j);
                    freeCells.add(rowColumn);
                }
            }
        }

        return freeCells;

    }
    public void printBoard(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(board[i][j]!=null) {
                    playingPiece piece = board[i][j];
                    System.out.print(piece.getType().name() + " ");
                }
                else{
                    System.out.print(" ");
                }
                System.out.print(" | ");
            }
            System.out.println();
        }
    }
}
