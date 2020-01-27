package datastructures;

import java.util.ArrayList;
import java.util.List;

public class QueueUsingArrayList<T> {

    private List<T> arrayList;

    public QueueUsingArrayList() {
        arrayList = new ArrayList<>();
    }

    public boolean isEmpty() {
        return arrayList.isEmpty();
    }

    public int size() {
        return arrayList.size();
    }

    public void enqueue(T element) {
        arrayList.add(element);
    }

    public T dequeue() throws RuntimeException {
        if (!isEmpty()) {
            T deletedElement = arrayList.get(0);
            arrayList.remove(0);
            return deletedElement;
        }
        throw new RuntimeException("queue is empty");
    }


}
