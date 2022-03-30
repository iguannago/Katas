package tenniskata2;

public enum Point {
    LOVE(0), FIFTEEN(1), THIRTY(2), FORTY(3);

    private final int point;

    Point(int point) {
        this.point = point;
    }

    public int getPoint() {
        return point;
    }
}
