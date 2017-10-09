package com.high5.model;

import java.util.LinkedList;

public class Token {

    private String generate(String key, String value) {
        return "<" + key + ", " + value + ">";
    }

    public LinkedList<String> classify(LinkedList<String> list) {
        String token = new String();
        boolean categoryFound = false;
        int counter;

        Categories categories = new Categories();
        LinkedList<String> classifiedList = new LinkedList();
        LinkedList<String[]> categoriesList = new LinkedList();

        categoriesList.add(categories.DELIMITERS); // categories[0]
        categoriesList.add(categories.ARITHMETIC_OPERATORS); // categories[1]
        categoriesList.add(categories.RELATIONAL_OPERATORS); // categories[2]
        categoriesList.add(categories.LOGICAL_OPERATORS); // categories[3]
        categoriesList.add(categories.RESERVED_WORDS); // categories[4]

        for(int i = 0; i < list.size(); i++) {
            for(counter = 0; counter < categoriesList.size(); counter++) {
                for(String category : categoriesList.get(counter)) {
                    if(list.get(i).matches(category)) {
                        categoryFound = true;
                        break;
                    }
                }

                if(categoryFound) {
                    break;
                }
            }

            if(categoryFound) {
                // Select the category
                if(counter == 0) {
                    token = this.generate(list.get(i), "Delimiter");
                } else if(counter == 1) {
                    token = this.generate(list.get(i), "Arithmetic Operator");
                } else if(counter == 2) {
                    token = this.generate(list.get(i), "Relational Operator");
                } else if(counter == 3) {
                    token = this.generate(list.get(i), "Logic Operator");
                } else if(counter == 4) {
                    token = this.generate(list.get(i), "Reserved Word");
                }

                categoryFound = false;
                classifiedList.add(token);
            } else {
                // If not category should be an identifier
                token = this.generate(list.get(i), "Identifier");
                classifiedList.add(token);
            }
        }

        return classifiedList;
    }

}
