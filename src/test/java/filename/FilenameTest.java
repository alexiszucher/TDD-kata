package filename;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FilenameTest {
    @Test
    void givenSimpleFile_shouldFindFilename() {
        String file = "afile.png";
        Assertions.assertEquals("afile", Filename.getFilename(file));
    }

    @Test
    void givenFileWithDash_shouldFindFilename() {
        String file = "a-file.png";
        Assertions.assertEquals("a-file", Filename.getFilename(file));
    }

    @Test
    void givenFileWithPoint_shouldFindFilename() {
        String file = "a-file.ofData.png";
        Assertions.assertEquals("a-file.ofData", Filename.getFilename(file));
    }

    @Test
    void givenFileWithTestWord_shouldFindFilenameWithoutTestWord() {
        String file = "a-file.test.png";
        String file2 = "a-file_test.png";
        Assertions.assertEquals("a-file", Filename.getFilename(file));
        Assertions.assertEquals("a-file", Filename.getFilename(file2));
    }

    @Test
    void givenFileWithPath_shouldFindFilename() {
        String file = "path/to/a-file_test.png";
        Assertions.assertEquals("a-file", Filename.getFilename(file));
    }
}