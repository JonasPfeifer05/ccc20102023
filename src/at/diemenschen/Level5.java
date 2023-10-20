package at.diemenschen;

import at.diemenschen.util.Level;

import java.io.IOException;
import java.util.Iterator;

public class Level5 extends Level {

    public Level5() throws IOException {
        super("level5");
    }

    @Override
    public String processFile(Iterator<String> consumer) {
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) throws IOException {
        new Level5().runExample();
    }
}
