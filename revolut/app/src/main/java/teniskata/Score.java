package teniskata;

import java.util.Objects;

public final class Score {
    private final Points player1;
    private final Points player2;
    private final String result;

    public Score(Points player1, Points player2, String result) {
        this.player1 = player1;
        this.player2 = player2;
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Score score = (Score) o;
        return player1 == score.player1 && player2 == score.player2 && Objects.equals(result, score.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(player1, player2, result);
    }

    @Override
    public String toString() {
        return "Score{" +
                "player1=" + player1 +
                ", player2=" + player2 +
                ", result='" + result + '\'' +
                '}';
    }
}
