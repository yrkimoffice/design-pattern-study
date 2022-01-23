package chapter2.point2;

import java.util.Vector;

public class VectorStack {

    private Vector<String> vector = new Vector<String>();

    public void push(String element) {
        vector.add(element);
    }

    public String pop() {
        return vector.remove(vector.size() - 1);
    }

    public boolean isEmpty() {
        return vector.isEmpty();
    }

    public int size() {
        return vector.size();
    }
}
