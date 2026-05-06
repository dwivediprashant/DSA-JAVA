
package PriorityQ;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PQ {

    public static class Student implements Comparable<Student> {
        String name;
        int marks;

        Student(String name, int marks) {
            this.name = name;
            this.marks = marks;
        }

        @Override
        public int compareTo(Student s) {
            return this.marks - s.marks;
        }
    }

    public static void main(String[] args) {
        // lowest has highest priority by default
        // we can change or reverse this by using comparator
        PriorityQueue<String> pq = new PriorityQueue<>();
        pq.add("10");
        pq.add("5");
        pq.add("17");
        pq.add("20");
        pq.add("-2");

        System.out.println("String :-");
        // lexicographical order print in String
        while (!pq.isEmpty()) {
            System.out.println(pq.remove());
        }

        System.out.println("Integers :- ");
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();

        pq2.add(1);
        pq2.add(10);
        pq2.add(4);
        pq2.add(-3);

        // lexicographical order print in String
        while (!pq2.isEmpty()) {
            System.out.println(pq2.remove());
        }

        // objects

        Student s1 = new Student("prashant", 97);
        Student s2 = new Student("amit", 99);
        Student s3 = new Student("ram", 100);
        Student s4 = new Student("sumit", 94);
        Student s5 = new Student("suman", 98);

        // sort students based on their marks
        PriorityQueue<Student> p = new PriorityQueue<>();

        p.add(s1);
        p.add(s2);
        p.add(s3);
        p.add(s4);
        p.add(s5);
        System.out.println("Objects : -");
        while (!p.isEmpty()) {
            System.out.println(p.remove().marks);
        }

    }

}