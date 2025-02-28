package Player;

import PlayingPiece.playingPiece;

public class Player {
   private final playingPiece piece;
   private final String name;
    public Player(playingPiece piece,String name){
        this.piece=piece;
        this.name=name;
    }

    public playingPiece getPiece() {
        return piece;
    }

    public String getName() {
        return name;
    }
}
