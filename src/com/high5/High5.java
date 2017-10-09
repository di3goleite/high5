package com.high5;

import com.high5.model.Categories;
import com.high5.model.LexicalAnalyzer;
import com.high5.util.File;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class High5 {

    public static void main(String[] args) throws IOException {
        File file = new File();
        Scanner fileInstance = file.open("assets/program.h5");
        String output = file.read(fileInstance);

        LexicalAnalyzer lex = new LexicalAnalyzer();
        Categories categories = new Categories();

        StringBuilder rawOutput = lex.removeSpaces(output);

        LinkedList<String> list = new LinkedList();
        list.add(rawOutput.toString());

        list = lex.parser(list, categories.DELIMITERS);
        list = lex.parser(list, categories.ARITHMETIC_OPERATORS);
        list = lex.parser(list, categories.RELATIONAL_OPERATORS);
        list = lex.parser(list, categories.LOGICAL_OPERATORS);
        list = lex.parser(list, categories.RESERVED_WORDS);

        list = lex.bandAid(list);

        System.out.println(rawOutput);
        System.out.println("=================");

        for(String word : list) {
            System.out.println(word);
            System.out.println("--------");
        }

        fileInstance.close();
    }
}
