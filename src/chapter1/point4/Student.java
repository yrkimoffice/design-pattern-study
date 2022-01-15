package chapter1.point4;

public class Student {

    private Professor advisor;

    public void setAdvisor(Professor advisor) {
        this.advisor = advisor;
    }

    public void advise(String msg) {
        System.out.println("msg = " + msg);
    }
}
