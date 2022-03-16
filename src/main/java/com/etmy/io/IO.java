package com.etmy.io;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class IO {

    public static boolean fileExists(String srcFile){
        return Files.isRegularFile(Path.of(srcFile));
    }

    public static boolean canCreateFile(String srcFile){
        if (Path.of(srcFile).getParent() == null) return false;
        return !Files.isRegularFile(Path.of(srcFile));
    }

    public static List<String> readFileAndReturnListOfStrings(String srcFile) throws IOException {
        return Files.readAllLines(Path.of(srcFile));
    }

    public static void writeFile(String srcFile, List<String> fileLines) throws IOException {
        try(FileWriter fileWriter = new FileWriter(srcFile)){
            for (String line : fileLines) {
                fileWriter.write(line+"\n");
            }
        }
    }
}
