package at.diemenschen.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

abstract public class Level {
    private final static String RESOURCE_DIRECTORY = "resources/";
    private final static String EXAMPLE_IDENTIFIER = "example";
    private final static String INPUT_EXTENSION = ".in";
    private final static String OUTPUT_EXTENSION = ".out";

    private final Set<Path> inputPaths;
    private final Path examplePath;

    public Level(String dirName) throws IOException {
        try (var filePaths = Files.walk(Path.of(RESOURCE_DIRECTORY + dirName))) {
            inputPaths = filePaths
                    .filter(Files::isRegularFile)
                    .filter(path -> path.getFileName().toString().endsWith(INPUT_EXTENSION))
                    .collect(Collectors.toSet());

            examplePath = inputPaths
                    .stream()
                    .filter(path -> path.getFileName().toString().contains(EXAMPLE_IDENTIFIER))
                    .findFirst()
                    .orElse(null);
        }
    }

    public abstract String processFile(Iterator<String> consumer);

    public final void runLevel() throws IOException {
        for (Path inputPath : inputPaths) {
            processAndWriteToOutputFile(inputPath);
        }
    }

    public final void runExample() throws IOException {
        if (examplePath == null) throw new IllegalArgumentException("No example file");
        processAndWriteToOutputFile(examplePath);
    }

    private void processAndWriteToOutputFile(Path inputPath) throws IOException {
        try (Stream<String> lines = Files.lines(inputPath)) {
            String outputContent = processFile(lines.iterator());

            int extensionIndex = inputPath.getFileName().toString().lastIndexOf('.');
            String outputFileName = inputPath.getFileName().toString().substring(0, extensionIndex) + OUTPUT_EXTENSION;

            Path outputPath = Path.of(inputPath.getParent().toString(), outputFileName);
            Files.write(outputPath, outputContent.getBytes());
        }
    }
}
