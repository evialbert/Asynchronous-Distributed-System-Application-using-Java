package service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TxtService {
    public void write(String message) throws IOException {
        FileWriter fstream = new FileWriter("log.txt",true);
        BufferedWriter out = new BufferedWriter(fstream);
        out.write(message);
        out.close();
    }
}
