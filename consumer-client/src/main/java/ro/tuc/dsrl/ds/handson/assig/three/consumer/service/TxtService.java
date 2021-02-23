package ro.tuc.dsrl.ds.handson.assig.three.consumer.service;

import java.io.*;

public class TxtService {

    public void write(String message) throws IOException {
        FileWriter fstream = new FileWriter("log.txt",true);
        BufferedWriter out = new BufferedWriter(fstream);
        out.write(message);
        out.close();;
    }

}
