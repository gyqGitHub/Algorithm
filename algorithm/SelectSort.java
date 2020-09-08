
import java.util.Comparator;

/**
 * javac -cp .:stdlib.jar SelectSort.java
 */
public class SelectSort{

    /**
     * 从执行流程看，执行时间为O(N^2)，与具体输入无关(稳定)
     * @param array
     */
    private static void sort(Comparable[] array){
        int length = array.length;
        for (int i = 0; i < length; i++) {
            int minIndex = i;
            for (int j = i; j < length; j++) {
                if(less(array[j],array[minIndex])){
                    exchange(array,j,minIndex);
                }
            }
        }
    }

    private static void exchange(Comparable[] list,int index1,int index2){
        int length = list.length;
        if(index1<0 || index2<0 || index1>=length || index2>=length){
            throw new IndexOutOfBoundsException();
        }
        Comparable temp = list[index1];
        list[index1] = list[index2];
        list[index2] = temp;
    }

    private static boolean less(Comparable a,Comparable b){
       return a.compareTo(b) <0;
    }

    private static void printArray(String[] test){
        for (int i = 0; i < test.length; i++) {
            System.out.print(test[i]);
        }
        System.out.println("\n");
    }

    public static void main(String[] args){
        String[] test = {"b","a","d","c","e","f"};
        SelectSort.sort(test);
        printArray(test);
    }
}