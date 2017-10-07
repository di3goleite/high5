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
        final String[] ARITHMETIC_OPERATORS = {"\\+", "-", "\\*", "/", "%"};
        final String[] RELATIONAL_OPERATORS = {"!=", "=", "<", "<=", ">", ">="};
        final String[] LOGIC_OPERATORS = {"!", "\\&\\&", "\\|\\|"};
        final String[] DELIMITERS = {";", ",", "\\(", "\\)", "\\[", "\\]", "\\{", "\\}", ":"};

        List<String[]> classes = new ArrayList();

        classes.add(RESERVED_WORDS); // classes[0]
        classes.add(ARITHMETIC_OPERATORS); // classes[1]
        classes.add(RELATIONAL_OPERATORS); // classes[2]
        classes.add(LOGIC_OPERATORS); // classes [3]
        classes.add(DELIMITERS); // classes[4]

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

        // Antes de fazer essa modificação é importante analisar os casos
        // das cadeias de caracteres através de expressões regulares
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
            for(String[] types : classes) {
                for(String type : types) {
                    String[] parts = word.split(type);

                    if(parts.length > 1) {
                        System.out.println(word);
                        System.out.println("----");
                        System.out.println(type);
                        System.out.println("----------------");
                    }
                }
            }
        }

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("hue hue".split(" ").length);

        fileInstance.close();
    }
}
