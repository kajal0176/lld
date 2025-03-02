public class Player {
    String name;
    int currentPosition;
    Player(String name){
        this.name=name;
        this.currentPosition=0;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public String getName() {
        return name;
    }
}
