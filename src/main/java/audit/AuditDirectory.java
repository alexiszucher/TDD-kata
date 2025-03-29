package audit;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class AuditDirectory {
    private static final String FIRST_AUDIT_FILE = "auditFile_1.txt";

    private final Path directory;

    public AuditDirectory(Path directory) {
        this.directory = directory;
    }

    public static AuditDirectory of(Path directory) {
        return new AuditDirectory(directory);
    }

    public Path resolve(String filename) {
        return directory.resolve(filename);
    }

    public boolean isEmpty() throws IOException {
        return allFiles().isEmpty();
    }

    public Set<Path> allFiles() throws IOException {
        return Files.list(directory).filter(Files::isRegularFile).collect(Collectors.toSet());
    }

    public Optional<Path> lastFile() throws IOException {
        return Files.list(directory).filter(Files::isRegularFile).max(Comparator.comparing(file -> file.toFile().getName()));
    }

    public boolean isLastFileFull() throws IOException {
        return Files.readAllLines(lastFile().orElseThrow()).size() >= 3;
    }

    public Path createFile() throws IOException {
        if (allFiles().isEmpty()) {
            return resolve(FIRST_AUDIT_FILE);
        } else {
            int number = allFiles().size()+1;
            return resolve("auditFile_"+ number +".txt");
        }
    }
}
