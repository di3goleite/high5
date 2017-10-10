package com.high5.model;

import java.util.LinkedList;

public class LexicalAnalyzer {

    public String removeSpaces(String output) {
        StringBuilder rawOutput = new StringBuilder();

        if(
            (output.length() >= 2 && (output.charAt(0) == '/' && output.charAt(1) == '/')) ||
            (output.length() >= 4 &&
                (output.charAt(0) == '/' && output.charAt(1) == '*') &&
                (output.charAt(output.length() - 2) == '*' && output.charAt(output.length() - 1) == '/')
            ) ||
            (output.length() >= 2 && (output.charAt(0) == '\"') && (output.charAt(output.length() - 1) == '\"'))
        ) {
            return output;
        } else {
            for(String word : output.split("\\s+")) {
                rawOutput.append(word);
            }

            return rawOutput.toString();
        }
    }

    public LinkedList<String> filter(String output) {
        LinkedList<String> list = new LinkedList();
        LinkedList<String> filteredList = new LinkedList();
        StringBuilder str = new StringBuilder();

        for(int i = 0; i < output.length(); i++) {

            // Comment
            if(output.charAt(i) == '/' && i + 1 < output.length()) {

                // Line comment
                if(output.charAt(i + 1) == '/') {
                    list.add(str.toString());
                    str.setLength(0);

                    for(int j = i; j < output.length(); j++) {

                        if(output.charAt(j) == '\n') {
                            list.add(str.toString());

                            str.setLength(0);
                            i = j;

                            break;
                        } else {
                            str.append(output.charAt(j));
                        }

                    }

                // Block comment
                } else if(output.charAt(i + 1) == '*') {
                    list.add(str.toString());
                    str.setLength(0);

                    str.append(output.charAt(i));
                    str.append(output.charAt(i + 1));

                    for(int j = i + 2; j < output.length(); j++) {

                        if(j + 1 < output.length() && output.charAt(j) == '*' && output.charAt(j + 1) == '/') {
                            str.append(output.charAt(j));
                            str.append(output.charAt(j + 1));

                            list.add(str.toString());
                            str.setLength(0);
                            i = j + 2;

                            break;
                        } else {
                            str.append(output.charAt(j));
                        }

                    }

                }

            // Characters chain
            } else if(output.charAt(i) == '\"') {
                list.add(str.toString());
                str.setLength(0);

                str.append(output.charAt(i));

                for(int j = i + 1; j < output.length(); j++) {

                    if(output.charAt(j) == '\"') {
                        str.append(output.charAt(j));

                        list.add(str.toString());
                        str.setLength(0);

                        i = j + 1;
                        break;
                    } else {
                        str.append(output.charAt(j));
                    }

                }

            }

            str.append(output.charAt(i));
        }

        list.add(str.toString());
        str.setLength(0);

        for(String rawStr : list) {
            rawStr = this.removeSpaces(rawStr);

            if(rawStr.length() > 0) {
                filteredList.add(rawStr);
            }
        }

        return filteredList;
    }

    public LinkedList<String> parser(LinkedList<String> list, String[] category) {
        String[] parts;
        String pattern;

        int listSize = list.size();

        for(int i = 0; i < category.length; i++) {

            for(int j = 0; j < listSize; j++) {

                if(!(
                    (list.get(j).length() >= 2 && (list.get(j).charAt(0) == '/' && list.get(j).charAt(1) == '/')) ||
                    (list.get(j).length() >= 4 &&
                        (list.get(j).charAt(0) == '/' && list.get(j).charAt(1) == '*') &&
                        (list.get(j).charAt(list.get(j).length() - 2) == '*' && list.get(j).charAt(list.get(j).length() - 1) == '/')
                    ) ||
                    (list.get(j).length() >= 2 && (list.get(j).charAt(0) == '\"') && (list.get(j).charAt(list.get(j).length() - 1) == '\"'))
                )) {
                    pattern = "((?<=" + category[i] + ")|(?=" + category[i] + "))";
                    parts = list.get(j).split(pattern);

                    if(parts.length > 1) {
                        list.remove(j);

                        for(int k = 0; k < parts.length; k++) {
                            list.add(j + k, parts[k]);
                        }

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
            if(i + 1 < list.size()) {
                if(
                    (list.get(i).equals("pr") && list.get(i + 1).equals("int")) ||
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
