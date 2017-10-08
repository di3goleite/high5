package com.high5.model;

import java.util.ArrayList;
import java.util.LinkedList;

public class LexicalAnalyzer {

    public StringBuilder removeSpaces(String output) {
        StringBuilder rawOutput = new StringBuilder();

        for(String word : output.split("\\s+")) {
            rawOutput.append(word);
        }

        return rawOutput;
    }

    public LinkedList<String> parser(StringBuilder rawOutput, String[] category) {
        LinkedList<String> list = new LinkedList();

        StringBuilder lexeme = new StringBuilder();
        String currentDelimiter = "";

        boolean delimiterFound = false;

        for(char character : rawOutput.toString().toCharArray()) {
            for(String delimiter : category) {
                if(delimiter.charAt(0) == character) {
                    delimiterFound = true;
                    currentDelimiter = delimiter;
                    break;
                }
            }

            if(!delimiterFound) {
                lexeme.append(character);
            } else {
                if(lexeme.length() > 0) {
                    list.add(lexeme.toString());
                }

                list.add(currentDelimiter);
                lexeme.setLength(0);

                delimiterFound = false;
                currentDelimiter = "";
            }
        }

        if(lexeme.length() > 0) {
            list.add(lexeme.toString());
            lexeme.setLength(0);
        }

        return list;
    }

}
