package at.diemenschen;

import at.diemenschen.util.KnobType;
import at.diemenschen.util.Level;
import at.diemenschen.util.PuzzlePiece;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
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

        List<List<PuzzlePiece>> puzzle = new ArrayList<>();
        for (String line : lines) {
            puzzle.add(parseLine(line));
        }

        for (int y = 0; y < puzzle.size(); y++) {
            for (int x = 0; x < puzzle.get(0).size(); x++) {
                correctPiece(puzzle.get(y).get(x), x, y, puzzle);
            }
        }

        return puzzle.stream()
                .map(row -> {
                    return row.stream()
                            .map(PuzzlePiece::toString)
                            .collect(Collectors.joining(" "));
                })
                .collect(Collectors.joining("\n"));
    }

    private void correctPiece(PuzzlePiece toEdit, int x, int y, List<List<PuzzlePiece>> puzzle) {
        if (x != puzzle.get(0).size()-1) {
            List<PuzzlePiece> currentLine = puzzle.get(y);
            toEdit.setRight(currentLine.get(x + 1).getLeft().getMatching());
        }

        if (y != puzzle.size()-1) {
            List<PuzzlePiece> topLine = puzzle.get(y+1);
            toEdit.setBottom(topLine.get(x).getTop().getMatching());
        }
    }

    private List<PuzzlePiece> parseLine(String line) {
        List<PuzzlePiece> pieces = new ArrayList<>();
        var piecesString = line.split(" ");
        for (String pieceString : piecesString) {
            pieces.add(new PuzzlePiece(pieceString));
        }
        return pieces;
    }

    public static void main(String[] args) throws IOException {
        new Level3().runLevel();
    }
}
