package com.high5.util;

import java.io.*;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class File {

    public Scanner open(String path, String name) throws FileNotFoundException {
        return (new Scanner(new FileReader(path + '/' + name))).useDelimiter("//z");
    }

    public String read(Scanner file) {
        StringBuilder output = new StringBuilder();

        try {
            while(file.hasNext()) {
                output.append(file.next());
            }
        } catch(NoSuchElementException e) {
            this.close(file);

            System.err.println("Input different of the expected");
            System.exit(1);
        }

        this.close(file);

        return output.toString();
    }

    public void write(String path, String name, LinkedList<String> output) throws IOException {
        Writer wr = new FileWriter(path + '/' + name);

        try {

            for(String token : output) {
                wr.write(token + '\n');
            }

        } catch(IOException e) {
            wr.flush();
            wr.close();

            e.printStackTrace();
            System.exit(1);
        }

        wr.flush();
        wr.close();
    }

    public void close(Scanner file) {
        file.close();
    }

}
