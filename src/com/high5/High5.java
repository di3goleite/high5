package com.high5;

import com.high5.model.Categories;
import com.high5.model.LexicalAnalyzer;
import com.high5.model.Token;
import com.high5.util.File;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class High5 {

    public static void main(String[] args) throws IOException {
        // Read the dot h5 program
        File file = new File();
        Scanner fileInstance = file.open("entrada.txt");
        String output = file.read(fileInstance);

        // Create important object references
        LexicalAnalyzer lex = new LexicalAnalyzer();
        Categories categories = new Categories();
        Token token = new Token();

        // Read the program and preprocess it removing spaces
        // and splitting the raw string by raw comments
        // block comments and characters chain
        LinkedList<String> list = lex.filter(output);

        // Parser the splitted program by delimiters
        list = lex.parser(list, categories.DELIMITERS);
        list = lex.parser(list, categories.ARITHMETIC_OPERATORS);
        list = lex.parser(list, categories.RELATIONAL_OPERATORS);
        list = lex.parser(list, categories.LOGICAL_OPERATORS);
        list = lex.parser(list, categories.RESERVED_WORDS);

        // Check language rules
        list = lex.bandAid(list);

        // Classify each token
        list = token.classify(list);

        // Show the tokenized output
        for(String word : list) {
            System.out.println(word);
        }

        fileInstance.close();
    }

}
