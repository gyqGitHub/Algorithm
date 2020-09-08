
/**
 * javac -cp .:stdlib.jar InsertSort.java
 * java -cp .:stdlib.jar InsertSort
 */
public class InsertSort{


    private static void sort(Comparable[] array){
        int length = array.length;
        for (int i = 1; i < length; i++) {
            //一个内循环可能交换多次
            for (int j = i; j >0 && less(array[j],array[j-1]); j--) {
                exchange(array,j,j-1);
            }
        }
    }

    private static boolean less(Comparable a,Comparable b){
        return a.compareTo(b)<0;
    }

    private static void exchange(Comparable[] array,int index1,int index2){
        int length = array.length;
        if(index1<0 || index2<0 || index1>=length || index2>=length){
            throw new IndexOutOfBoundsException();
        }
        Comparable temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    private static void printArray(String[] test){
        for (int i = 0; i < test.length; i++) {
            System.out.print(test[i]);
        }
        System.out.println("\n");
    }

    public static void main(String[] args){
        String[] test = {"b","d","a","c","e","f"};
        sort(test);
        printArray(test);
        String[] test1 = {};
        sort(test1);
        printArray(test1);
        String[] test2 = {"d","1","c","3","a","2"};
        sort(test2);
        printArray(test2);
    }
}