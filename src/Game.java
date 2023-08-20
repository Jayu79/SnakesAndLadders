import Services.DiceService;
import entities.*;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Game {

    Board board;
    Queue<Player> players;
    Queue<Player> winners;
    int diceCount;
    int dimension;
    int size;

    public Game(Builder b){  //This ideally has to be written using a builder pattern
        this.size = b.getSize();
        this.diceCount = b.getDiceCount();
        this.dimension = b.getDimension();
        this.board = b.getBoard();
        players = b.getPlayers();
        winners = b.getWinners();

    }

    public void addPlayers(Player player) {
        this.players.add(player);
    }
    public static Builder getBuilder(){
        return new Builder();
    }

    public static class Builder{
        Queue<Player> players;
        Queue<Player> winners;
        int diceCount;
        int dimension;
        int size;
        Board board;

        public Builder(){
            players = new LinkedList<Player>();
            winners = new LinkedList<Player>();

        }

        public void setBoard(int dimension){
            this.board = new Board(dimension);
        }
        public Board getBoard() {
            return board;
        }

        public Queue<Player> getPlayers() {
            return players;
        }

        public Queue<Player> getWinners() {
            return winners;
        }

        public int getDiceCount() {
            return diceCount;
        }

        public void setDiceCount(int diceCount) {
            this.diceCount = diceCount;
        }

        public int getDimension() {
            return dimension;
        }

        public void setDimension(int dimension) {
            this.dimension = dimension;
            setBoard(dimension);
        }

        public int getSize() {
            return size;
        }

        public void setSize(int dimension) {
            this.size = dimension*dimension;
        }

        public Game build(){
            return new Game(this);
        }


    }


    public void launch(){

        this.board.print();
        while (players.size()>1){

            Player currPlayer = this.players.poll();
            System.out.println();
            System.out.println(currPlayer.getUserName()+"'s turn");
            System.out.println("Press r to roll the dice");

            Scanner sc = new Scanner(System.in);
            char c = sc.next().charAt(0);
            makeMove(currPlayer);
            if(currPlayer.getPosition()==size-1){
                System.out.println("Player "+currPlayer.getUserName()+" has won!!");
                winners.add(currPlayer);
            }
            else{
                players.add(currPlayer);
            }
            printPositions();

        }

    }

    private void printPositions(){
        for(Player player: players){
            System.out.println(player.getUserName()+" : "+player.getPosition());
        }
    }


    private void makeMove(Player player){

        int currPosition = player.getPosition();
        int move = 0;
        int roll = 0;
        do{  //this piece of code is to add if there are multiple 6s in the game
            //We can also handle the case if we have multiple dices in this section.
            roll = DiceService.roll(this.diceCount);
            move += roll;
            if(roll==6){
                System.out.println("You have got a 6 and rolling again");
            }
        }while(roll == diceCount*6);

        System.out.println("You have got "+move);
        int finalPos = currPosition+move;
        if(finalPos <= size) {
            if (board.hasSnakeOrLAdder(finalPos)) {
                System.out.println(board.getEntity(finalPos).getEncounterMesage());
                finalPos = board.getEntity(finalPos).getEnd();
            }
            System.out.println("Taking you to the Final position " + finalPos);
        }
            else{
                System.out.println("Better luck next time");
                finalPos = currPosition;
        }


        player.setPosition(finalPos);

    }

}




