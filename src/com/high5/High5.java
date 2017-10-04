package com.high5;

import com.high5.util.File;

import java.io.IOException;
import java.util.Scanner;

public class High5 {

    public static void main(String[] args) throws IOException {
        File file = new File();
        Scanner fileInstance = file.open("assets/while.h5");
        String output = file.read(fileInstance);

        for(String lexeme : output.split("\\s+")) {
            System.out.println(lexeme);
        }

        fileInstance.close();
    }
}
