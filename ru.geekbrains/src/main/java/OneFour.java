import java.util.Arrays;

public class OneFour {
    int[] oneFour;
    static int cell;
    static int length;

    public boolean OneFour(int[] arr){
        if((cell = Arrays.binarySearch(arr, 4))==-1 ||(cell = Arrays.binarySearch(arr, 1))==-1){
            return false;
        }return true;
    }

}
