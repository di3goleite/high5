package com.high5;

import com.high5.util.File;
import com.high5.util.Token;

import java.io.IOException;
import java.util.Scanner;

public class High5 {

    public static void main(String[] args) throws IOException {

        final String[] RESERVED_WORDS = {"class", "final", "if", "else", "for", "scan", "print", "int", "float", "bool", "true", "false", "string"};

        final String[] ARITHMETIC_OPERATORS = {"+", "-", "*", "/", "%"};
        final String[] RELATIONAL_OPERATORS = {"!=", "=", "<", "<=", ">", ">="};
        final String[] LOGIC_OPERATORS = {"!", "&&", "||"};
        final String[] DELIMITERS = {";", ",", "(", ")", "[", "]", "{", "}", ":"};
        final String[] SPACES = {" ", "\n", "\t"};

        File file = new File();
        Scanner fileInstance = file.open("assets/program.h5");
        String output = file.read(fileInstance);

        StringBuilder sb = new StringBuilder();

        for(char ch : output.toCharArray()) {
            if (ch != ' ' && ch != '\n' && ch != '\t') {
                sb.append(ch);
            } else {
                boolean tokenFound = false;

                for(String str : RESERVED_WORDS) {
                    if(str.equals(sb.toString())) {
                        tokenFound = true;
                        Token token = new Token(sb.toString(), "Palavra reservada");
                        System.out.println(token.getToken());
                    }
                }

                if(!tokenFound) {
                    for(String str : ARITHMETIC_OPERATORS) {
                        if(str.equals(sb.toString())) {
                            tokenFound = true;
                            Token token = new Token(sb.toString(), "Operador Aritmético");
                            System.out.println(token.getToken());
                        }
                    }
                }

                if(!tokenFound) {
                    for(String str : RELATIONAL_OPERATORS) {
                        if(str.equals(sb.toString())) {
                            tokenFound = true;
                            Token token = new Token(sb.toString(), "Operador Relacional");
                            System.out.println(token.getToken());
                        }
                    }
                }

                if(!tokenFound) {
                    for(String str : LOGIC_OPERATORS) {
                        if(str.equals(sb.toString())) {
                            tokenFound = true;
                            Token token = new Token(sb.toString(), "Operador Lógico");
                            System.out.println(token.getToken());
                        }
                    }
                }

                if(!tokenFound) {
                    for(String str : DELIMITERS) {
                        if(str.equals(sb.toString())) {
                            tokenFound = true;
                            Token token = new Token(sb.toString(), "Delimitador");
                            System.out.println(token.getToken());
                        }
                    }
                }

                if(!tokenFound) {
                    Token token = new Token(sb.toString(), "Identificador");
                    System.out.println(token.getToken());
                }

                sb.setLength(0);
            }
        }

        fileInstance.close();
    }
}
