package com.etmy.crypt.cryptology;

import java.util.ArrayList;
import java.util.List;

public class Cryptology {

    public static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з',
            'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'ю', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};


    public static List<String> encode(List<String> fileLines, int countCharacters){
        List<String> encodedFileLines = new ArrayList<>();
        for (String raw : fileLines) {
            encodedFileLines.add(moveCharacter(raw, countCharacters));
        }
        return  encodedFileLines;
    }

    public static List<String> decode(List<String> fileLines, int countCharacters){
        List<String> decodedFileLines = new ArrayList<>();
        for (String raw : fileLines){
            decodedFileLines.add(moveCharacter(raw, countCharacters * -1));
        }

        return decodedFileLines;
    }

    private static String moveCharacter(String line, int countCharacters){
        StringBuilder newLine = new StringBuilder();

            for (char ch : line.toCharArray()) {


                    for (int i = 0; i < ALPHABET.length; i++) {
                        if (ch == ALPHABET[i]) {
                            int findIndex = i + countCharacters;
                            if (findIndex < 0) {
                                findIndex = (ALPHABET.length) - findIndex * -1;

                            } else if (findIndex > ALPHABET.length - 1) {
                                findIndex = findIndex - 43;
                            }

                            newLine.append(ALPHABET[findIndex]);
                        }
                    }
                }
        return newLine.toString();
    }
}
