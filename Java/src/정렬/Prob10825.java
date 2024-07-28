package 정렬;

import java.io.*;
import java.util.*;

public class Prob10825 {

    static class Student implements Comparable<Student> {

        String name;
        int kor;
        int eng;
        int mat;

        public Student(String name, int kor, int eng, int mat) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.mat = mat;
        }

        @Override
        public int compareTo(Student o) {
            if (this.kor == o.kor) {
                if (this.eng == o.eng) {
                    if (this.mat == o.mat) {
                        return this.name.compareTo(o.name);
                    }
                    return o.mat - this.mat;
                }
                return this.eng - o.eng;
            }
            return o.kor - this.kor;
        }
    }
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Student[] students = new Student[N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            students[i] = new Student(st.nextToken(), 
                            Integer.parseInt(st.nextToken()), 
                            Integer.parseInt(st.nextToken()), 
                            Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(students);

        for (int i = 0; i < N; i++) {
            sb.append(students[i].name).append("\n");
        }

        System.out.println(sb);
    }
}
