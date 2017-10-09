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

    public LinkedList<String> bandAid(LinkedList<String> list) {
        boolean shouldBeFixed = false;

        for(int i = 0; i < list.size(); i++) {
            if(i < list.size() - 1) {
                if(
                    (list.get(i).equals("pr") && list.get(i + 1).equals("int")) ||
                    (list.get(i).equals("=") && list.get(i + 1).equals("=")) ||
                    (list.get(i).equals("!") && list.get(i + 1).equals("=")) ||
                    (list.get(i).equals("<") && list.get(i + 1).equals("=")) ||
                    (list.get(i).equals(">") && list.get(i + 1).equals("="))
                ) {
                    shouldBeFixed = true;
                }
            }

            if(shouldBeFixed) {
                list.add(i, list.get(i) + list.get(i + 1));
                list.remove(i + 1);
                list.remove(i + 1);

                shouldBeFixed = false;
            }
        }

        return list;
    }

}
