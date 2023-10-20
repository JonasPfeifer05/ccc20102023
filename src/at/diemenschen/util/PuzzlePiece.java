package at.diemenschen.util;

public class PuzzlePiece {
    private KnobType top;
    private KnobType right;
    private KnobType bottom;
    private KnobType left;

    public PuzzlePiece(KnobType top, KnobType right, KnobType bottom, KnobType left) {
        this.top = top;
        this.right = right;
        this.bottom = bottom;
        this.left = left;
    }

    public void rotate() {
        // TODO
    }

    public void setTop(KnobType top) {
        this.top = top;
    }

    public void setRight(KnobType right) {
        this.right = right;
    }

    public void setBottom(KnobType bottom) {
        this.bottom = bottom;
    }

    public void setLeft(KnobType left) {
        this.left = left;
    }

    public KnobType getTop() {
        return top;
    }

    public KnobType getRight() {
        return right;
    }

    public KnobType getBottom() {
        return bottom;
    }

    public KnobType getLeft() {
        return left;
    }
}
