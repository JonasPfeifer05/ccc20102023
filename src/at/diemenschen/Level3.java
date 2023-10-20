package at.diemenschen;

import at.diemenschen.util.Level;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class Level3 extends Level {
    public Level3() throws IOException {
        super("level3");
    }

    @Override
    public String processFile(Stream<String> consumer) {
        List<String> lines = consumer
                .skip(1)
                .toList();


    }

    public static void main(String[] args) throws IOException {
        new Level3().runExample();
    }
}
