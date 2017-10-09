package com.high5.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.regex.Pattern;

public class LexicalAnalyzer {

    public StringBuilder removeSpaces(String output) {
        StringBuilder rawOutput = new StringBuilder();

        for(String word : output.split("\\s+")) {
            rawOutput.append(word);
        }

        return rawOutput;
    }

    public LinkedList<String> parser(LinkedList<String> list, String[] category) {
        String[] parts;
        String pattern;

        int listSize = list.size();

        for(int i = 0; i < category.length; i++) {

            for(int j = 0; j < listSize; j++) {

                pattern = "((?<=" + category[i] + ")|(?=" + category[i] + "))";
                parts = list.get(j).split(pattern);

                if(parts.length > 1) {
                    list.remove(j);

                    for(int k = 0; k < parts.length; k++) {
                        list.add(j + k, parts[k]);
                    }

                }

            }

            listSize = list.size();
        }

        return list;
    }

}
