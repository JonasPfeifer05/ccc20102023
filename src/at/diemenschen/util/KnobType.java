package at.diemenschen.util;

public enum KnobType {
    Empty,
    Knob,
    Hole,
    ;

    public static KnobType of(char knobType) {
        switch (knobType) {
            case 'E' -> {
                return Empty;
            }
            case 'K' -> {
                return Knob;
            }
            case 'H' -> {
                return Hole;
            }
            default -> throw new IllegalArgumentException();
        }
    }

    public KnobType getMatching() {
        switch (this) {
            case Empty -> {
                return Empty;
            }
            case Knob -> {
                return Hole;
            }
            case Hole -> {
                return Knob;
            }
            default -> {
                throw new IllegalArgumentException();
            }
        }
    }

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
                throw new IllegalArgumentException();
            }
        }
    }
}
