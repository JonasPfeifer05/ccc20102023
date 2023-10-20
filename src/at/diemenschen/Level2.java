package at.diemenschen;

import at.diemenschen.util.Level;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Level2 extends Level {
    public Level2() throws IOException {
        super("level2");
    }

    @Override
    public String processFile(Stream<String> consumer) {
        List<String> lines = consumer.skip(1)
                .toList();

        HashMap<String, Integer> puzzleMap = new HashMap<>();
        outer:
        for (String line : lines) {
            line = line.trim();
            for (int i = 0; i < 4; i++) {
                if (puzzleMap.containsKey(line)) {
                    puzzleMap.put(line, puzzleMap.get(line)+1);
                    continue outer;
                }
                line = rotate(line);
            }
            puzzleMap.put(line, 1);
        }

        return puzzleMap.entrySet().stream()
                .map(entry -> entry.getValue().toString() + " " + entry.getKey())
                .collect(Collectors.joining("\n"));
    }

    private String rotate(String puzzle) {
        List<String> split = new ArrayList<>(List.of(puzzle.split(",")));
        String tmp = split.removeLast();
        split.add(0, tmp);
        return String.join(",", split);
    }

    public static void main(String[] args) throws IOException {
        new Level2().runLevel();
    }
}
