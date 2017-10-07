package com.high5;

import com.high5.util.File;
import com.high5.util.Token;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class High5 {

    public static void main(String[] args) throws IOException {

        final String[] RESERVED_WORDS = {"class", "final", "if", "else", "for", "scan", "print", "int", "float", "bool", "true", "false", "string"};
        final String[] ARITHMETIC_OPERATORS = {"+", "-", "*", "/", "%"};
        final String[] RELATIONAL_OPERATORS = {"!=", "=", "<", "<=", ">", ">="};
        final String[] LOGIC_OPERATORS = {"!", "&&", "||"};
        final String[] DELIMITERS = {";", ",", "(", ")", "[", "]", "{", "}", ":"};

        List classes = new ArrayList();

        classes.add(RESERVED_WORDS);
        classes.add(ARITHMETIC_OPERATORS);
        classes.add(RELATIONAL_OPERATORS);
        classes.add(LOGIC_OPERATORS);
        classes.add(DELIMITERS);

        File file = new File();
        Scanner fileInstance = file.open("assets/program.h5");
        String output = file.read(fileInstance);

        StringBuilder rawOutput = new StringBuilder();
        StringBuilder lexeme = new StringBuilder();

        for(String word : output.split("\\s+")) {
            rawOutput.append(word);
        }

        System.out.println(rawOutput);
        System.out.println("==============");
        boolean delimiterFound = false;
        String currentDelimiter = "";

        ArrayList<String> splittedWords = new ArrayList<String>();

        for(char character : rawOutput.toString().toCharArray()) {
            for(String delimiter : DELIMITERS) {
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

        for(String word : splittedWords) {
            System.out.println(word);
            System.out.println("----------------");
        }

        fileInstance.close();
    }
}
