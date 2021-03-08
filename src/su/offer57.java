package su;

/**
 * 和为s的两个数字
 */
public class offer57 {
    //暴力会超时
    public int[] twoSum(int[] nums, int target) {
        int[] rs=new int[2];
        for(int i=0;i<nums.length-1;i++){
            for (int j=i+1;j<nums.length;j++){
                int k=nums[i]+nums[j];
                if(k<target) continue;
                else if(k==target) {
                    rs[0]=nums[i];
                    rs[1]=nums[j];
                };
            }
        }
        return rs;
    }

    /**
     * 由于排好序的 则头尾双指针遍历一次即可
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
       int l=0;
        int[] rs=new int[2];
       int h=nums.length-1;
       while (l<h){
           int k=nums[l]+nums[h];
           if(target<k) h--;
           else if(target>k) l++;
           else{
               rs[0]=nums[l];
               rs[1]=nums[h];
               break;
           }
       }
       return rs;
    }

}
