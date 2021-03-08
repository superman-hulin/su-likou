package su;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 最小的k个数
 */
public class offer40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] rs=new int[k];
        for(int i=0;i<k;i++){
            rs[i]=arr[i];
        }
        return rs;
    }
}
