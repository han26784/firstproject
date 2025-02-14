
public enum Direction {
    NORTH(2),
    SOUTH(0),
    EAST(3),
    WEST(1);

    private int FrameLineNumber; // the number of rows in sprite sheet thing


    Direction(int FrameLineNumber) {
        this.FrameLineNumber = FrameLineNumber;
    }
    public int getFrameLineNumber() {
        return FrameLineNumber;
    }
}