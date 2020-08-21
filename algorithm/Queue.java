
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * javac -cp .:stdlib.jar Queue.java
 * java -cp .:stdlib.jar Queue
 * @param <T>
 */
public class Queue<T> implements Iterable<T>{

    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void enqueue(T data){
        Node<T> newTail = new Node<>();
        newTail.data = data;
        newTail.next = null;

        if(tail == null){//用isEmpty()作为判断条件，语意性更好一点
            tail = newTail;
            head = newTail;
        }else {
            tail.next = newTail;
            tail = newTail;
        }
        size++;
    }

    public T dequeue(){
        if(isEmpty()) throw new NoSuchElementException("queue underflow");
        T data = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return data;
    }

    public T peek(){
        if(isEmpty()) throw new NoSuchElementException("queue underflow");
        return head.data;
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();
        for (T item : this) {
            builder.append(item);
            builder.append("  ");
        }
        return builder.toString();
    }

    public Iterator<T> iterator(){
        return new QueueIterator<T>(head);
    }

    private static class Node<T>{
        Node<T> next;
        T data;
    }

    private static class QueueIterator<T> implements Iterator<T>{
        private Node<T> current;

        public QueueIterator(Node<T> head){
            current = head;
        }

        public boolean hasNext(){
            return current != null;
        }

        public T next(){
            if(!hasNext()) throw new NoSuchElementException();
            T data = current.data;
            current = current.next;
            return data;
        }

        public void remove(){
            throw new NoSuchElementException();
        }
    }

    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();
        System.out.println("size = " + queue.size());
        System.out.println("isEmpty = " + queue.isEmpty());
        queue.enqueue("gyq");
        System.out.println("size = " + queue.size());
        System.out.println("isEmpty = " + queue.isEmpty());
        queue.enqueue("lmq");
        for (String item:queue){
            System.out.println("item = " + item);
        }
        queue.dequeue();
        System.out.println("size = " + queue.size());
        System.out.println("isEmpty = " + queue.isEmpty());
        queue.dequeue();
        System.out.println("size = " + queue.size());
        System.out.println("isEmpty = " + queue.isEmpty());
        queue.enqueue("gl");
        for (String item:queue){
            System.out.println("item = " + item);
        }
        System.out.println("size = " + queue.size());
        System.out.println("isEmpty = " + queue.isEmpty());
    }
}