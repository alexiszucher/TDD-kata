package filename;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Filename {
    public static String getFilename(String file) {
        file = deletePath(file);
        String name = deleteExtension(file);
        name = deleteTestWord(name);
        return name;
    }

    private static String deleteTestWord(String name) {
        name = name.replaceAll(".?test", "");
        return name;
    }

    private static String deleteExtension(String file) {
        List<String> parts = Arrays.asList(file.split("\\."));
        parts = new ArrayList<>(parts.subList(0, parts.size() - 1));
        String name = String.join(".", parts);
        return name;
    }

    private static String deletePath(String file) {
        String[] path = file.split("/");
        file = path[path.length - 1];
        return file;
    }
}