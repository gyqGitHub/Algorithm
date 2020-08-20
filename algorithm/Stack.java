import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @param <T>
 */
//javac -cp .:stdlib.jar Stack.java
    //java -cp .:stdlib.jar Stack
public class Stack<T> implements Iterable<T>{

    private Node<T> first;
    private int size = 0;

    public void push(T item){
        Node<T> newFirst = new Node<>();
        newFirst.data = item;
        newFirst.next = first;
        first = newFirst;
        size++;
    }

    public T pop(){
        if(isEmpty()) throw new NoSuchElementException("Stack underflow");
        T pop = first.data;
        first = first.next;
        size--;
        return pop;
    }

    /**
     * 跟pop类似返回最近一次添加的元素，但不会从链表中删除
     * @return
     */
    public T peek(){
        if(isEmpty()) throw new NoSuchElementException("Stack underflow");
        return first.data;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public Iterator<T> iterator(){
        return new StackIterator<T>(first);
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (T t :this) {
            builder.append(t);
            builder.append("  ");
        }
        builder.append("]");
        return builder.toString();
    }

    //region 需要设置为静态内部类
    private static class Node<T>{
        Node<T> next;
        T data;
    }

    private static class StackIterator<T> implements Iterator<T>{
        private Node<T> current;

        public StackIterator(Node<T> node){
            current = node;
        }

        public boolean hasNext(){
            return current != null;
        }

        public T next(){
            if(!hasNext()) throw new NoSuchElementException();
            T item = current.data;
            current = current.next;
            return item;
        }
    }
    //endregion

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        System.out.println("size = " + stack.size());
        System.out.println("isEmpty = " + stack.isEmpty());
        stack.push("gyq");
        stack.push("lmq");
        System.out.println("size = " + stack.size());
        System.out.println("isEmpty = " + stack.isEmpty());
        for (String name : stack) {
            System.out.println("循环：" + name);
        }
        System.out.println(stack);
        stack.pop();
        System.out.println("size = " + stack.size());
        System.out.println("isEmpty = " + stack.isEmpty());
        for (String name : stack) {
            System.out.println("循环：" + name);
        }

    }
}