package audit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AuditTest {
    @TempDir
    Path tempDirectory;

    AddAuthenticationToAuditFileUseCase useCase = new AddAuthenticationToAuditFileUseCase();

    @AfterEach
    public void tearDown() {
        AuditClock.reset();
    }

    @Test
    void givenNoAuditFileExist_shouldCreateNewAuditFile() throws IOException {
        Path directory = tempDirectory.resolve("audit");
        Files.createDirectory(directory);

        useCase.add("azucher", AuditDirectory.of(directory));

        Assertions.assertTrue(directory.resolve("auditFile_1.txt").toFile().exists());
    }

    @Test
    void givenOneAuditFileWith3Lines_shouldCreateNewAuditFile() throws IOException {
        Path directory = tempDirectory.resolve("audit");
        Files.createDirectory(directory);
        Path auditFile1 = directory.resolve("auditFile_1.txt");
        Files.createFile(auditFile1);
        makeFileFullOfLines(auditFile1);

        useCase.add("azucher", AuditDirectory.of(directory));

        Assertions.assertTrue(directory.resolve("auditFile_2.txt").toFile().exists());
    }

    @Test
    void shouldAddUserNameAndDateOnAuditFile() throws IOException {
        LocalDateTime january1stAt3PM45 = LocalDateTime.of(2025, 1, 1, 15, 43);
        AuditClock.change(january1stAt3PM45);
        Path directory = tempDirectory.resolve("audit");
        Files.createDirectory(directory);

        useCase.add("azucher", AuditDirectory.of(directory));

        Path auditFile = directory.resolve("auditFile_1.txt");
        Assertions.assertTrue(Files.exists(auditFile));
        String content = Files.readString(auditFile);
        Assertions.assertEquals("azucher "+ january1stAt3PM45.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME), content);
    }

    private static void makeFileFullOfLines(Path auditFile1) throws IOException {
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(auditFile1)) {
            for (int i = 0; i < 3; i++) {
                bufferedWriter.write("Line " + i + "\n");
            }
            bufferedWriter.flush();
        }
    }
}
