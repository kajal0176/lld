import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Board {
Cell [][]board;
int size;
int numberOfSnakes;
int numberOfLadders;
public Board(int size,int numberOfSnakes,int numberOfLadders){
    board=new Cell[size][size];
    this.size=size;
    initializeBoard();
    this.numberOfLadders=numberOfLadders;
    this.numberOfSnakes=numberOfSnakes;
}
void initializeBoard(){
    for(int i=0;i<size;i++){
        for(int j=0;j<size;j++){
            board[i][j]=new Cell();
        }
    }
}
void addSnakeAndLadder(){
    while(numberOfSnakes>0){
        int snakeHead = ThreadLocalRandom.current().nextInt(1,board.length*board.length-1);
        int snakeTail = ThreadLocalRandom.current().nextInt(1,board.length*board.length-1);
        if(snakeTail >= snakeHead) {
            continue;
        }
       Jump jump=new Jump();
        jump.start=snakeHead;
        jump.end=snakeTail;
        Cell cell=getCell(snakeHead);
        cell.jump=jump;
        numberOfSnakes--;
    }
    while(numberOfLadders>0){
        int ladderEnd = ThreadLocalRandom.current().nextInt(1,board.length*board.length-1);
        int ladderStart = ThreadLocalRandom.current().nextInt(1,board.length*board.length-1);
        if(ladderEnd <= ladderStart) {
            continue;
        }
        Jump jump=new Jump();
        jump.start=ladderStart;
        jump.end=ladderEnd;
        Cell cell=getCell(ladderStart);
        cell.jump=jump;
        numberOfLadders--;
    }
}
    Cell getCell(int playerPosition) {
        int boardRow = playerPosition / board.length;
        int boardColumn = (playerPosition % board.length);
        return board[boardRow][boardColumn];
    }
//  void printBoard(){
//      ArrayList<List<Integer>>boardNum=new ArrayList<>();
//    for(int i=0;i<size;i++){
//        List<Integer>row=new ArrayList<>();
//        for(int j=0;j<size;j++){
//
//            if(i%2==0) {
//
//                row.add(j,100 - (i * size + j) );
//            }
//            else{
//                row.add(size-j-1,i*size+j);
//            }
//
//        }
//        boardNum.add(row);
//    }
//    for(int i=0;i<size;i++){
//        for(int j=0;j<size;j++){
//            if(board[i][j]==null){
//                System.out.print(boardNum.get(i).get(j)+" ");
//            }
//            else{
//                if(board[i][j].getJump().start>board[i][j].getJump().end){
//                    System.out.print("snake ");
//                }
//                else {
//                    System.out.println("ladder ");
//                }
//            }
//        }
//        System.out.println();
//    }
 // }
}
