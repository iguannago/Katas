package teniskata;

public final class Game {
    public static final String WINS_THE_POINT = " wins the point";
    public static final String WINS_THE_GAME = " wins the game";
    public static final String DEUCE = "deuce";
    private final Player player1;
    private final Player player2;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public Score play(Points player1Points, Points player2Points, Player pointWinner) {
        if (pointWinner.equals(player1)) {
            if (Points.LOVE.equals(player1Points)) {
                return new Score(Points.FIFTEEN, player2Points, pointWinner.getName() + WINS_THE_POINT);
            }
            if (Points.FIFTEEN.equals(player1Points)) {
                return new Score(Points.THIRTY, player2Points, pointWinner.getName() + WINS_THE_POINT);
            }
            if (Points.THIRTY.equals(player1Points)) {
                if (Points.FORTY.equals(player2Points)) {
                    return new Score(Points.FORTY, player2Points, DEUCE);
                }
                return new Score(Points.FORTY, player2Points, pointWinner.getName() + WINS_THE_POINT);
            }
            if (Points.FORTY.equals(player1Points)) {
                if (Points.A.equals(player2Points)) {
                    return new Score(player1Points, Points.FORTY, DEUCE);
                }
                if (!Points.FORTY.equals(player2Points)) {
                    return new Score(player1Points, player2Points, pointWinner.getName() + WINS_THE_GAME);
                } else {
                    return new Score(Points.A, player2Points, pointWinner.getName() + " advantage");
                }
            }
            if (Points.A.equals(player1Points)) {
                return new Score(player1Points, player2Points, pointWinner.getName() + WINS_THE_GAME);
            }
        } else {
            if (Points.LOVE.equals(player2Points)) {
                return new Score(player1Points, Points.FIFTEEN, pointWinner.getName() + WINS_THE_POINT);
            }
            if (Points.FIFTEEN.equals(player2Points)) {
                return new Score(player1Points, Points.THIRTY, pointWinner.getName() + WINS_THE_POINT);
            }
            if (Points.THIRTY.equals(player2Points)) {
                if (Points.FORTY.equals(player1Points)) {
                    return new Score(player1Points, Points.FORTY, DEUCE);
                }
                return new Score(player1Points, Points.FORTY, pointWinner.getName() + WINS_THE_POINT);
            }
            if (Points.FORTY.equals(player2Points)) {
                if (Points.A.equals(player1Points)) {
                    return new Score(Points.FORTY, player2Points, DEUCE);
                }
                if (!Points.FORTY.equals(player1Points)) {
                    return new Score(player1Points, player2Points, pointWinner.getName() + WINS_THE_GAME);
                } else {
                    return new Score(player2Points, Points.A, pointWinner.getName() + " advantage");
                }
            }
            if (Points.A.equals(player2Points)) {
                return new Score(player1Points, player2Points, pointWinner.getName() + WINS_THE_GAME);
            }
        }
        return null;
    }

}
