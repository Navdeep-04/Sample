import java.lang.reflect.Array;
import java.util.Arrays;

public class MoveZeros {
    public static void main(String[] args) {
        int[] arr = {0,1,0,3,12};
        int z = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != 0){
                int temp = arr[i];
                arr[i] = arr[z];
                arr[z] = temp;
                z++;
            }
        }
        System.out.print(Arrays.toString(arr));
    }
}
