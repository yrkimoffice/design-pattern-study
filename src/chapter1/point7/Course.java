package chapter1.point7;

import java.util.ArrayList;
import java.util.List;

public class Course {

    private String name;
    private List<Transcript> transcripts = new ArrayList<>();

    public Course(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addTranscript(Transcript transcript) {
        transcripts.add(transcript);
    }
}
