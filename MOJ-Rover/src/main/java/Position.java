/**
 * Created by davicres on 17/05/2016.
 */
public final class Position {
    private final int x;
    private final int y;
    private final char direction;

    private Position(int x, int y, char direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public static Position create(int x, int y, char direction) {
        return new Position(x,y,direction);
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                ", direction=" + direction +
                '}';
    }
}
