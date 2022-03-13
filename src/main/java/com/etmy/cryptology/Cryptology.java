package com.etmy.cryptology;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cryptology {

    private static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з',
            'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'ю', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};


    public static List<String> encode(List<String> fileLines, int countCharacters){
        List<String> encodedFileLines = new ArrayList<>();
        for (String raw : fileLines) {
            encodedFileLines.add(moveCharacter(raw, countCharacters));
        }
        return  encodedFileLines;
    }

    public void decode(){

    }

    public void bruteforce(){

    }

    public void staticAnalysis(){

    }

    private static String moveCharacter(String raw, int countCharacters){
        StringBuilder newRaw = new StringBuilder();
        for (char ch : raw.toCharArray()) {
            for (int i = 0; i < ALPHABET.length; i++) {
                if (ch == ALPHABET[i]){
                    int findIndex = i + countCharacters;
                    if(findIndex > ALPHABET.length-1){
                        findIndex = countCharacters - (findIndex - 42);
                    }
                    newRaw.append(ALPHABET[findIndex]);
                }
            }
        }
        return newRaw.toString();
    }
}
