package 단계별.입출력과사칙연산;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Prob10171 {
    
    public static void main(String[] args) throws IOException{
        
        // OPTION 1 : 124ms 14048KB
        System.out.println("\\    /\\");
        System.out.println(" )  ( ')");
        System.out.println("(  /  )");
        System.out.println(" \\(__)|");

        // OPTION 2 : 120ms 13984KB 13908KB
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter (System.out));

        bw.write("\\    /\\\n" 
                    + " )  ( ')\n"
                    + "(  /  )\n"
                    + " \\(__)|\n");

        bw.write("\\    /\\");
        bw.newLine();
        bw.write(" )  ( ')");
        bw.newLine();
        bw.write("(  /  )");
        bw.newLine();
        bw.write(" \\(__)|");

        bw.flush();
        bw.close();
    }
}
