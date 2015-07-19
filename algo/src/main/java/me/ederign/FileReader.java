package me.ederign;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileReader {


    public static int[] readToIntArray(String fileName) throws IOException {

        File file = new File(FileReader.class.getClassLoader().getResource(fileName).getFile());
        List<String> lines = Files.readAllLines(Paths.get(file.toURI()));
        int[] intLines = new int[lines.size()];
        for (int i = 0; i < lines.size(); i++) {
            intLines[i] = Integer.parseInt(lines.get(i));

        }
        return intLines;
    }
}
