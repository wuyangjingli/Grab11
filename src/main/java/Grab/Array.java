package Grab;

import java.util.*;

public class Array {
    public static void main(String[] args) {

        int[] num = {1,2,3,5,7,8,9,9};
        List arr = Sum(num, 10);
        System.out.println(arr);
    }


    public static List Sum(int[] nums, int n) {
        int len = nums.length;
        List<List<Integer>> list = new ArrayList<List<Integer>>();

        for(int i = 0; i < len; i++){
            /*
            T是对象是，也就是说如果是引类型时，在循环外边已经new了一个对象，相当于这个对象的地址在内存空间已经开辟出来了，
                     保存到了固定的位置，这时候我们使用add方法时，会增加值的个数，但引用地址不变，所以后面的值会覆盖掉前面的值
             */
            Integer[] result = new Integer[2];//
            for(int j = i+1; j < len; j++){
                if(nums[i] + nums[j] == n){
                    result[0] = nums[i];
                    result[1] = nums[j];
                    list.add((List<Integer>)Arrays.asList(result));
                }
            }

        }

        //  System.out.println(list);
        return list;


    }

}
