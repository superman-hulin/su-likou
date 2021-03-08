package su;

/**
 * 1-n整数中1出现的次数
 */
public class offer43 {
    //该方法超时
    public int countDigitOne(int n) {
        int count=0;
        for(int i=1;i<=n;i++){
            int k=i;
            while (k>0){
                if(k%10==1) count++;
                k/=10;
            }
        }
        return count;
    }

}
