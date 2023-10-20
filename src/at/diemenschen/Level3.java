package at.diemenschen;

import at.diemenschen.util.Level;

import java.io.IOException;
import java.util.Iterator;

public class Level3 extends Level {
    public Level3() throws IOException {
        super("level3");
    }

    @Override
    public String processFile(Iterator<String> consumer) {
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) throws IOException {
        new Level3().runExample();
    }
}
