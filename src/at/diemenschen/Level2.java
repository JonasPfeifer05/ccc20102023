package at.diemenschen;

import at.diemenschen.util.Level;

import java.io.IOException;
import java.util.Iterator;

public class Level2 extends Level {
    public Level2() throws IOException {
        super("level2");
    }

    @Override
    public String processFile(Iterator<String> consumer) {
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) throws IOException {
        new Level2().runExample();
    }
}
