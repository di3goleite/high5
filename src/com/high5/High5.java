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
        // Input dot h5 file program
        final String PATH = "./entrada";
        final String INPUT_FILE = "program.h5";
        final String OUTPUT_FILE = "program.out";

        // Read the dot h5 program
        File file = new File();
        Scanner fileInstance = file.open(PATH, INPUT_FILE);
        String output = file.read(fileInstance);

        // Create important object references
        LexicalAnalyzer lex = new LexicalAnalyzer();
        Categories categories = new Categories();
        Token token = new Token();

        // Read the program and preprocess it removing spaces
        // and splitting the raw string by raw comments
        // block comments and characters chain
        LinkedList<String> list = lex.filter(output);
        LinkedList<String> errorsList = new LinkedList();

        // Parser the splitted program by delimiters
        list = lex.parser(list, categories.DELIMITERS);
        list = lex.parser(list, categories.ARITHMETIC_OPERATORS);
        list = lex.parser(list, categories.RELATIONAL_OPERATORS);
        list = lex.parser(list, categories.LOGICAL_OPERATORS);
        list = lex.parser(list, categories.RESERVED_WORDS);

        // Check language rules
        list = lex.applyRules(list);

        // Classify each token
        list = token.classification(list);

        // Show the tokenized output
        for(String word : list) {
            System.out.println(word);
        }

        // Write output and errors files
        file.write(PATH, OUTPUT_FILE, list);

    }

}
