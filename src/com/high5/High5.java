package com.high5;

import com.high5.util.File;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class High5 {

    public static void main(String[] args) throws IOException {
        File file = new File();

        Scanner fileInstance = file.open("assets/while.txt");

        ArrayList<String> output = file.read(fileInstance);
        System.out.println(output);

        fileInstance.close();
    }
}
