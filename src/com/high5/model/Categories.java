package com.high5.model;

import java.util.ArrayList;
import java.util.List;

public class Categories {

    final String[] RESERVED_WORDS = {"class", "final", "if", "else", "for", "scan", "print", "int", "float", "bool", "true", "false", "string"};

    final String[] ARITHMETIC_OPERATORS = {"+", "-", "*", "/", "%"};

    final String[] RELATIONAL_OPERATORS = {"!=", "=", "<", "<=", ">", ">="};

    final String[] LOGIC_OPERATORS = {"!", "&&", "||"};

    final String[] DELIMITERS = {";", ",", "(", ")", "[", "]", "{", "}", ":"};

    public String[] getReservedWords() {
        return this.RESERVED_WORDS;
    }

    public String[] getArithmeticOperators() {
        return this.ARITHMETIC_OPERATORS;
    }

    public String[] getRelationalOperators() {
        return this.RELATIONAL_OPERATORS;
    }

    public String[] getLogicOperators() {
        return this.LOGIC_OPERATORS;
    }

    public String[] getDelimiters() {
        return this.DELIMITERS;
    }

    public List<String[]> getAllCategories() {
        List<String[]> categories = new ArrayList();

        categories.add(this.RESERVED_WORDS);
        categories.add(this.ARITHMETIC_OPERATORS);
        categories.add(this.RELATIONAL_OPERATORS);
        categories.add(this.LOGIC_OPERATORS);
        categories.add(this.DELIMITERS);

        return categories;
    }
}
