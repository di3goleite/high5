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
        LinkedList<String> list = lex.parser(rawOutput, categories.DELIMITERS);

        list = lex.depthParser(list, categories.ARITHMETIC_OPERATORS);
//        list = lex.depthParser(list, categories.RELATIONAL_OPERATORS);
//        list = lex.depthParser(list, categories.LOGICAL_OPERATORS);
//        list = lex.depthParser(list, categories.RESERVED_WORDS);

        System.out.println(rawOutput);

        for(String word : list) {
            System.out.println(word);
            System.out.println("--------");
        }

        fileInstance.close();
    }
}
