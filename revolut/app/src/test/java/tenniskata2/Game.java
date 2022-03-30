package tenniskata2;

public final class Game {
    private final Player player1;
    private final Player player2;
    private final Score score;

    public Game(Score score) {
        this.score = score;
        this.player1 = score.getPlayer1();
        this.player2 = score.getPlayer2();
    }

    public Score play(String winner) {
        if (player1.getName().equals(winner)
                && player2.getPoints().getValue() < Point.FORTY.getValue()
                && player1.getPoints().getValue() < Point.FORTY.getValue()
        ) {
            return new Score(new Player(player1.getName(), giveMeNextPoint(player1.getPoints())), player2);
        }
        return new Score(player1, player2);
    }

    private Point giveMeNextPoint(Point givenPoint) {
        switch (givenPoint) {
            case LOVE:
                return Point.FIFTEEN;
            case FIFTEEN:
                return Point.THIRTY;
            case THIRTY:
                return Point.FORTY;
        }
        throw new RuntimeException("Point is not recognised");
    }
}
