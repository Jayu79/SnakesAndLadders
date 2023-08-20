package entities;

public class Player {

    int position;
    String userName;

    public Player(String userName){
        this.position = 0;
        this.userName = userName;
    }
    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getUserName() {
        return userName;
    }


}
