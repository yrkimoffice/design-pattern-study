package chapter1.point7;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Student studentA = new Student("학생A");
        Student studentB = new Student("학생B");

        Course courseA = new Course("과목A");
        Course courseB = new Course("과목B");

        Transcript t1 = new Transcript(studentA, courseA);
        Transcript t2 = new Transcript(studentA, courseB);
        Transcript t3 = new Transcript(studentB, courseB);

        //학생A는 2020년 과목 A에서 B+, 과목 B에서 A+ 취득
        t1.setDate("2020");
        t1.setGrade("B+");
        t2.setDate("2020");
        t2.setGrade("A+");

        //학생B는 2021년 과목 B에서 C 취득
        t3.setDate("2021");
        t3.setGrade("C");

        List<Course> courses = studentA.getCourses();
        for (Course course : courses) {
            System.out.println("course.getName() = " + course.getName());
        }

    }
}
