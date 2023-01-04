import java.io.*;
import java.util.*;

public class BOJ11000 {
    public static void main(String[] args) throws IOException {
        // 입력
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final var n = Integer.parseInt(br.readLine());
        List<Course> courses = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Course course = new Course(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            courses.add(course);
        }

        Collections.sort(courses);
        // 반례
         // 3
        // 1 1
        // 1 1
        // 1 1  
        //  1이 나와야함 
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(courses.get(0).end);
        for (int i = 1; i < n; i++) {
            Course course = courses.get(i);
            if (pq.peek() <= course.start) {
                pq.poll();
            }

            pq.offer(course.end);
        }
       
        System.out.println(pq.size());
    }

    static class Course implements Comparable<Course> {
        private int start;
        private int end;

        public Course(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Course o) {
            return this.start == o.end ? this.end - o.end  
                : this.start - o.start;
        }

        @Override
        public String toString() {
            return "Course [start=" + start + ", end=" + end + "]";
        }
    }

}