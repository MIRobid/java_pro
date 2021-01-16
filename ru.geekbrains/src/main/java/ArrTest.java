import java.sql.SQLOutput;
import java.util.Arrays;

public class ArrTest {
    int[] arrTest;
    static int[] arrTestShort;
    static int cell;
    static int length;
    private Object RuntimeException;

    public int[] arrTest(int[] arr){
        length=arr.length;
        if((cell = Arrays.binarySearch(arr, 4))==-1){
            System.out.println(RuntimeException);
        }
        cell = Arrays.binarySearch(arr, 4);
        arrTestShort = Arrays.copyOfRange(arr, cell, length);
        System.out.println(Arrays.asList(arrTestShort));
        return arrTestShort;
    }

    public static void main(String[] args) {
        int[] arr= {0,1,2,3,4,5,6,7,8,9};
        ArrTest arrTest=new ArrTest();
        arrTest.arrTest(arr);
    }

}
