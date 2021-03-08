package su;

import java.util.ArrayList;

/**
 * 数据流中的中位数
 */
public class offer41 {
    ArrayList<Integer> arrayList;
    public offer41() {
        arrayList=new ArrayList();
    }

    public void addNum(int num) {
        arrayList.add(num);
    }

    public double findMedian() {
        arrayList.sort((a,b)->a-b);
        int low=0;
        int high=arrayList.size()-1;
        int median=(low+high)/2;
        if(arrayList.size()%2==0){

            return (float)(arrayList.get(median)+arrayList.get(median+1))/2;
        }
        return arrayList.get(median/2);
    }
}
