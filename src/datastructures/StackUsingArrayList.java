package datastructures;

import java.util.ArrayList;
import java.util.List;

public class StackUsingArrayList<T> {

    private List<T> list;
    // List<T> list = new ArrayList<T>(); can't instantiate

    public StackUsingArrayList() {
        list = new ArrayList<>();
    }

    public int size() {
        return list.size();
    }

    public void push(T element) {
        list.add(element);
    }

    public boolean isEmpty() {
        return list.isEmpty();

    }

    public T pop() throws RuntimeException {
        if (!isEmpty()) {                                //return list.lastIndexOf(list);
            T popped = list.remove(list.size() - 1);
            return popped;
        }
        throw new RuntimeException("stack is empty");
    }

    public T peek() {
        return list.get(list.size() - 1);
    }

}
