package com.high5.model;

import java.util.ArrayList;

public class LexicalAnalyzer {

    public StringBuilder removeSpaces(String output) {
        StringBuilder rawOutput = new StringBuilder();

        for(String word : output.split("\\s+")) {
            rawOutput.append(word);
        }

        return rawOutput;
    }

    public ArrayList<String> parse(StringBuilder rawOutput, String[] pattern) {
        ArrayList<String> splittedWords = new ArrayList<String>();
        StringBuilder lexeme = new StringBuilder();
        String currentDelimiter = "";
        boolean delimiterFound = false;

        for(char character : rawOutput.toString().toCharArray()) {
            for(String delimiter : pattern) {
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
                    splittedWords.add(lexeme.toString());
                }

                splittedWords.add(currentDelimiter);
                lexeme.setLength(0);

                delimiterFound = false;
                currentDelimiter = "";
            }
        }

        return splittedWords;
    }
}
