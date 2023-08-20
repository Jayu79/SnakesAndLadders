import entities.Player;

public class Main {
    public static void main(String[] args) {
        Game.Builder gameBuilder = new Game.Builder();
        gameBuilder.setDimension(10);
        gameBuilder.setSize(10);
        gameBuilder.setDiceCount(1);

        Game game = gameBuilder.build();

        game.addPlayers(new Player("A"));
        game.addPlayers(new Player("B"));
        game.addPlayers(new Player("C"));
        game.addPlayers(new Player("D"));

        game.launch();


    }
}