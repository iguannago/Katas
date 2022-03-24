package teniskata;

public final class Game {
    private final Player player1;
    private final Player player2;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public Score playPoint(Points player1Points, Points player2Points, Player pointWinner) {
        if (Points.FORTY.equals(player1Points)
                && (pointWinner.equals(player2) && Points.THIRTY.equals(player2Points))) {
            return new Score(Points.FORTY, Points.FORTY, "deuce");
        }
        if (Points.FORTY.equals(player2Points)
                && (pointWinner.equals(player1) && Points.THIRTY.equals(player1Points))) {
            return new Score(Points.FORTY, Points.FORTY, "deuce");
        }
        if (pointWinner.equals(player1)) {
            if (player1Points.equals(Points.LOVE)) {
                return new Score(Points.FIFTEEN, player2Points, pointWinner.getName() + " wins the point");
            }
        }
        return new Score(player1Points, player2Points, pointWinner.getName() + " wins the game");
    }
}
