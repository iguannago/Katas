package tenniskata2;

public final class Game {
    private final Player player1;
    private final Player player2;

    public Game(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name, Point.LOVE);
        this.player2 = new Player(player2Name, Point.LOVE);
    }

    public Score play(String winner) {
        if (player1.getName().equals(winner)) {
            return new Score(new Player(player1.getName(), Point.FIFTEEN), player2);
        }
        return new Score(player1, player2);
    }
}
