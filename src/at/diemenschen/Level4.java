package at.diemenschen;

import at.diemenschen.util.Level;

import java.io.IOException;
import java.util.Iterator;

public class Level4 extends Level {
    public Level4() throws IOException {
        super("level4");
    }

    @Override
    public String processFile(Iterator<String> consumer) {
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) throws IOException {
        new Level4().runExample();
    }
}
