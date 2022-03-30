package tenniskata2;

import java.util.Objects;

public final class Player {
    private final String name;
    private final Point points;

    public Player(String name, Point points) {
        this.name = name;
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public Point getPoints() {
        return points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name) && points == player.points;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, points);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", points=" + points +
                '}';
    }
}
