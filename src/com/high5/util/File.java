package com.high5.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class File {

    public Scanner open(String path) throws FileNotFoundException {
        return (new Scanner(new FileReader(path))).useDelimiter("//z");
    }

    public String read(Scanner file) {
        StringBuilder output = new StringBuilder();

        try {
            while(file.hasNext()) {
                output.append(file.next());
            }
        }
        catch(NoSuchElementException e) {
            System.err.println("Input different of the expected");
            this.close(file);
            System.exit(1);
        }

        return output.toString();
    }

    public void close(Scanner file) {
        file.close();
    }

}
