package at.diemenschen;

import at.diemenschen.util.Level;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Level1 extends Level {

    public Level1() throws IOException {
        super("level1");
    }

    @Override
    public String processFile(Stream<String> consumer) {
        return consumer
                .skip(1)
                .collect(Collectors.groupingBy(o -> o, HashMap::new, Collectors.counting()))
                .entrySet().stream()
                .map(entry -> entry.getValue().toString() + " " + entry.getKey())
                .collect(Collectors.joining("\n"));
    }

    public static void main(String[] args) throws IOException {
        new Level1().runLevel();
    }
}
