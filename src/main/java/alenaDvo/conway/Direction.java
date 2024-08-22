package alenaDvo.conway;

import java.util.stream.Stream;

public enum Direction {
    UP(0, 1),
    DOWN(0, -1),
    LEFT(-1, 0),
    RIGHT(1, 0),
    LEFTUP(-1, 1),
    RIGHTUP(1, 1),
    LEFTDOWN(-1, -1),
    RIGHTDOWN(1, -1);

    Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }

    private final int x;
    private final int y;

    public int getX() {
        return x;
    }

    public int getY() { return y; }

    public static Stream<Direction> stream() {
        return Stream.of(Direction.values());
    }
}
