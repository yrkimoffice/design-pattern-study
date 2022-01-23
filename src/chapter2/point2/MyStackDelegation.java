package chapter2.point2;

import java.util.ArrayList;

public class MyStackDelegation {

    private ArrayList<String> arrayList = new ArrayList<String>();

    public void push(String element) {
        arrayList.add(element);
    }

    public String pop() {
        return arrayList.remove(arrayList.size() -1);
    }

    public boolean isEmpty() {
        return arrayList.isEmpty();
    }

    public int size() {
        return arrayList.size();
    }
}
