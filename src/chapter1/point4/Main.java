package chapter1.point4;

public class Main {
    public static void main(String[] args) {
        Professor professor = new Professor();
        Student student = new Student();

        // 여기서 학생과 교수는 1:1 연관관계
        professor.setStudent(student);
        professor.advise();
    }
}
