package chapter1.point2;

import chapter1.point3.Phone;

public class Person {

    private Phone[] phones;
    public Person() {
        phones = new Phone[2];
    }

    public Phone getPhone(int i) {
        if (i == 0 || i == 1) return phones[i];
        return null;
    }
}
