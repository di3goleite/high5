package com.high5;

import com.high5.model.Categories;
import com.high5.model.LexicalAnalyzer;
import com.high5.util.File;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class High5 {

    public static void main(String[] args) throws IOException {
        File file = new File();
        Scanner fileInstance = file.open("assets/program.h5");
        String output = file.read(fileInstance);

        LexicalAnalyzer lex = new LexicalAnalyzer();
        Categories categories = new Categories();

        StringBuilder rawOutput = lex.removeSpaces(output);

        System.out.println(rawOutput);

        LinkedList<String> list = lex.parser(rawOutput, categories.DELIMITERS);
        list = lex.depthParser(list, categories.ARITHMETIC_OPERATORS);

        for(String word : list) {
            System.out.println(word);
            System.out.println("--------");
        }

//        boolean delimiterFound = false;
//        String currentDelimiter = "";
//
//        ArrayList<String> splittedWords = new ArrayList<String>();
//
//        // Antes de fazer essa modificação é importante analisar os casos
//        // das cadeias de caracteres através de expressões regulares
//        for(char character : rawOutput.toString().toCharArray()) {
//            for(String delimiter : DELIMITERS) {
//                if(delimiter.charAt(0) == character) {
//                    delimiterFound = true;
//                    currentDelimiter = delimiter;
//                    break;
//                }
//            }
//
//            if(!delimiterFound) {
//                lexeme.append(character);
//            } else {
//                if(lexeme.length() > 0) {
//                    splittedWords.add(lexeme.toString());
//                }
//
//                splittedWords.add(currentDelimiter);
//                lexeme.setLength(0);
//
//                delimiterFound = false;
//                currentDelimiter = "";
//            }
//        }
//
//        for(String word : splittedWords) {
//            for(String[] types : classes) {
//                for(String type : types) {
//                    String[] parts = word.split(type);
//
//                    if(parts.length > 1) {
//                        System.out.println(word);
//                        System.out.println("----");
//                        System.out.println(type);
//                        System.out.println("----------------");
//                    }
//                }
//            }
//        }
//
//        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
//        for(String s : "hue\\(hue".split("[(]")) {
//            System.out.println(s);
//        }

        fileInstance.close();
    }
}
