package com.high5.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class File {

    public Scanner open(String path) throws FileNotFoundException {
        return (new Scanner(new FileReader(path))).useDelimiter("//z");
    }

    public ArrayList<String> read(Scanner file) {
        ArrayList<String> output = new ArrayList<>();

        try {
            while(file.hasNext()) {
                output.add(file.next());
            }
        }
        catch(NoSuchElementException e) {
            System.err.println("Input different of the expected");
            this.close(file);
            System.exit(1);
        }

        return output;
    }

    public void close(Scanner file) {
        file.close();
    }

}
