package com.etmy.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class io {

    public String readFilePathFromConsole(){
        String srcFile = "";
        try(Scanner scanner = new Scanner(System.in)){
            srcFile =  scanner.nextLine();
        };
        return srcFile;
    }
    private List<String> readFileAndReturnListOfStrings(String srcFile) throws IOException {
        return Files.readAllLines(Path.of(srcFile));
    }

    private void writeFile(String srcFile) {

    }
}
