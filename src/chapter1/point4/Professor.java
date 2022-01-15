package chapter1.point4;

public class Professor {

    private Student student;

    public void setStudent(Student student) {
        this.student = student;
        student.setAdvisor(this);
    }

    public void advise() {
        student.advise("상담 내용");
    }
}
