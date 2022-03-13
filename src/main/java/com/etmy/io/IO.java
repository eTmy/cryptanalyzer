package com.etmy.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class IO {

//    public static String readFilePathFromConsole(){
//        String srcFile = "";
//        try(Scanner scanner = new Scanner(System.in)){
//            srcFile =  scanner.nextLine();
//        };
//        return srcFile;
//    }

    public static boolean fileExists(String srcFile){
        return Files.isRegularFile(Path.of(srcFile));
    }

    public static List<String> readFileAndReturnListOfStrings(String srcFile) throws IOException {
        return Files.readAllLines(Path.of(srcFile));
    }

    private void writeFile(String srcFile) {

    }
}
