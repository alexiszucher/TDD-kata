package audit;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AddAuthenticationToAuditFileUseCase {
    public static final String SPACE = " ";

    public void add(String azucher, AuditDirectory auditDirectory) throws IOException {
        Path auditFile;
        if (auditDirectory.isEmpty() || auditDirectory.isLastFileFull()) {
            auditFile = auditDirectory.createFile();
        } else {
            auditFile = auditDirectory.lastFile().orElseThrow();
        }

        try (BufferedWriter writer = Files.newBufferedWriter(auditFile)) {
            writer.write(azucher);
            writer.write(SPACE + LocalDateTime.now(AuditClock.CLOCK).format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        }
    }
}
