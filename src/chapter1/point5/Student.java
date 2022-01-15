package chapter1.point5;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private String name;
    private List<Course> courses = new ArrayList<>();

    public Student(String name) {
        this.name = name;
    }

    public void registerCourse(Course course) {
        courses.add(course);
    }

    public void dropCourse(Course course) {
        if (courses.contains(course)) {
            courses.remove(course);
        }
    }

    public List<Course> getCourses() {
        return courses;
    }
}
