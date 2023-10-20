package at.diemenschen.util;

public enum KnobType {
    Empty,
    Knob,
    Hole,
    ;

    @Override
    public String toString() {
        switch (this) {
            case Empty -> {
                return "E";
            }
            case Knob -> {
                return "K";
            }
            case Hole -> {
                return "H";
            }
            default -> {
                return "NA";
            }
        }
    }
}
