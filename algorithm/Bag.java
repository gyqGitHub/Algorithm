
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * 只进不出的背包
 * @param <T>
 */
//java -cp .:stdlib.jar BinarySearch ../*/tinyW.txt< ../*/tinyT.txt */
//javac -cp .:stdlib.jar BinarySearch.java
//   javac -cp .:stdlib.jar Bag.java
//   java -cp .:stdlib.jar Bag
public class Bag<T> implements Iterable<T>{
    private int size = 0;
    private Node<T> mFirst;

    public Bag() {
    }

    public void add(T data) {
        size++;//应该移至最后执行

        //region 可以合并成一句 Node<T> temp = mFirst
        Node<T> temp = null;
        if (mFirst != null) {
            temp = mFirst;
        }
        //endregion
        mFirst = new Node<T>();
        mFirst.data = data;
        mFirst.next = temp;
    }

    public boolean isEmpty() {
        return mFirst == null;
    }

    public int size() {
        return size;
    }

    public static class Node<T> {
        public T data;
        public Node<T> next;
    }

    public Iterator<T> iterator(){
        return new BagIterator<T>(mFirst);
    }

    /**
     * 可以参考/Users/guyuqiang/android/gyqproject/Algorithm/app/libs/algs4.jar!/edu/princeton/cs/algs4/Bag.java的实现
     * 参数命名很重要，会影响思考🤔
     * @param <T>
     */
    public static class BagIterator<T> implements Iterator<T>{
        private Node<T> first = new Node<>();

        public BagIterator(Node<T> head){
            first.next = head;
        }

        @Override
        public boolean hasNext(){
            return first.next != null;
        }

        @Override
        public T next(){
            //这一步忘了抛出异常的处理，如果不处理会抛出空指针异常，空指针异常会令人不解
//            if(!hasNext()) throw new NoSuchElementException();
            Node<T> next = first.next;
            first = next;
            return next.data;
        }
    }

    public static void main(String[] args) {
        Bag<String> bag = new Bag<>();
        System.out.println("是否为空：" + bag.isEmpty());
        System.out.println("大小为：" + bag.size());
        for (String name:bag) {
            System.out.println(name);
        }
        for (String name:bag) {
            System.out.println(name);
        }
        bag.add("gyq");
        System.out.println("是否为空：" + bag.isEmpty());
        System.out.println("大小为：" + bag.size());
        bag.add("lmq");
        for (String name:bag) {
            System.out.println(name);
        }

    }
}