package 입출력과사칙연산;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Prob10718 {
    public static void main(String[] args) throws IOException{
        
        // OPTION 1 : 108ms 13872KB
        System.out.println("강한친구 대한육군\n강한친구 대한육군");

        // OPTION 2 : 120ms 13948KB
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter (System.out));

        bw.write("강한친구 대한육군\n강한친구 대한육군");
        bw.flush();
        bw.close();
    }
}
