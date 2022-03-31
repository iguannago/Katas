package tenniskata2;

public final class Game {
    private final Player player1;
    private final Player player2;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }


    public Score play(String winner) {
        System.out.println(winner + " wins the point");
        if (player1.getName().equals(winner)) {
            if (isNormalGame(player1, player2)) {
                Player player1 = new Player(this.player1.getName(), giveMeNextPoint(this.player1.getPoints()));
                return new Score(player1, player2, null);
            }
            if (isWinningGame(player1, player2)) {
                return new Score(player1, player2, player1.getName() + " wins the game");
            }
            if (isDeuce(player1, player2)) {
                if (player2.getPoints().equals(Point.ADVANTAGE)) {
                    Player player2 = new Player(this.player2.getName(), giveMeNextPoint(this.player2.getPoints()));
                    return new Score(player1, player2, "deuce");
                } else {
                    Player player1 = new Player(this.player1.getName(), giveMeNextPoint(this.player1.getPoints()));
                    return new Score(player1, player2, "deuce");
                }
            }
            if (isAdvantage(player1, Point.FORTY, player2)) {
                Player player1 = new Player(this.player1.getName(), giveMeNextPoint(this.player1.getPoints()));
                return new Score(player1, player2, player1.getName() + "'s advantage");
            }
            return new Score(player1, player2, null);
        }
        if (player2.getName().equals(winner)) {
            if (isNormalGame(player2, player1)) {
                Player player2 = new Player(this.player2.getName(), giveMeNextPoint(this.player2.getPoints()));
                return new Score(player1, player2, null);
            }
            if (isWinningGame(player2, player1)) {
                return new Score(player1, player2, player2.getName() + " wins the game");
            }
            if (isDeuce(player2, player1)) {
                if (player1.getPoints().equals(Point.ADVANTAGE)) {
                    Player player1 = new Player(this.player1.getName(), giveMeNextPoint(this.player1.getPoints()));
                    return new Score(player1, player2, "deuce");
                }
                Player player2 = new Player(this.player2.getName(), giveMeNextPoint(this.player2.getPoints()));
                return new Score(player1, player2, "deuce");
            }
            if (isAdvantage(player2, Point.FORTY, player1)) {
                Player player2 = new Player(this.player2.getName(), giveMeNextPoint(this.player2.getPoints()));
                return new Score(player1, player2, player2.getName() + "'s advantage");
            }

        }
        return new Score(player1, player2, null);
    }

    private boolean isAdvantage(Player player2, Point point, Player player1) {
        return player2.getPoints().equals(point) && player1.getPoints().equals(Point.FORTY);
    }

    private boolean isDeuce(Player player1, Player player2) {
        return isAdvantage(player1, Point.THIRTY, player2)
                || player1.getPoints().equals(Point.FORTY) && player2.getPoints().equals(Point.ADVANTAGE);
    }

    private boolean isWinningGame(Player player1, Player player2) {
        return player1.getPoints().equals(Point.FORTY)
                && player2.getPoints().getValue() < Point.FORTY.getValue()
                || player1.getPoints().equals(Point.ADVANTAGE)
                && player2.getPoints().equals(Point.FORTY);
    }

    private boolean isNormalGame(Player player1, Player player2) {
        return player1.getPoints().getValue() < Point.FORTY.getValue()
                && player2.getPoints().getValue() < Point.FORTY.getValue();
    }

    private Point giveMeNextPoint(Point givenPoint) {
        switch (givenPoint) {
            case LOVE:
                return Point.FIFTEEN;
            case FIFTEEN:
                return Point.THIRTY;
            case THIRTY:
            case ADVANTAGE:
                return Point.FORTY;
            case FORTY:
                return Point.ADVANTAGE;
        }
        throw new RuntimeException("Point is not recognised");
    }
}
