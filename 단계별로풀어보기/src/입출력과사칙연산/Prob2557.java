package 입출력과사칙연산;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Prob2557 {
    public static void main(String[] args) throws IOException{
        
        // OPTION 1 : 120ms 13960KB
        System.out.println("Hello World!");     

        // OPTION 2 : 116ms 13852KB
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter (System.out));

        bw.write("Hello World!");
        bw.flush();
        bw.close();
    }
}