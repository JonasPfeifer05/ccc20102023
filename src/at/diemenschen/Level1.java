package at.diemenschen;

import at.diemenschen.util.Level;

import java.io.IOException;
import java.util.Iterator;

public class Level1 extends Level {

    public Level1() throws IOException {
        super("level1");
    }

    @Override
    public String processFile(Iterator<String> consumer) {
        return "Test";
    }

    public static void main(String[] args) throws IOException {
        new Level1().runLevel();
    }
}
