package tenniskata2;

public enum Point {
    LOVE(0), FIFTEEN(1), THIRTY(2), FORTY(3);

    private final int value;

    Point(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
