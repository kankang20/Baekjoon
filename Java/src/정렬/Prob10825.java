package 정렬;

import java.io.*;
import java.util.*;

public class Prob10825 {

    static class Student implements Comparable{

        String name;
        int grade1;
        int grade2;
        int grade3;

        public Student(String name, int grade1, int grade2, int grade3) {
            this.name = name;
            this.grade1 = grade1;
            this.grade2 = grade2;
            this.grade3 = grade3;
        }

        @Override
        public int compareTo(Object o) {
            return grade1;
        }
    }
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Student[] name = new Student[N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            
        }

    }
}
