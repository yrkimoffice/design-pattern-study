package chapter1.point7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Student {

    private String name;
    private List<Transcript> transcripts = new ArrayList<>();

    public Student(String name) {
        this.name = name;
    }

    public void addTranscript(Transcript transcript) {
        transcripts.add(transcript);
    }

    public List<Course> getCourses() {
        List<Course> courses = new ArrayList<>();
        Iterator<Transcript> iterator = transcripts.iterator();

        while (iterator.hasNext()) {
            Transcript tr = iterator.next();
            courses.add(tr.getCourse());
        }
        return courses;
    }

}
