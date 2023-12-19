package exam02;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Ex05 {
    public static void main(String[] args) {
        int[] nums = IntStream.iterate(10,x->x+2).limit(10).toArray();
        System.out.println(Arrays.toString(nums));

        //generate는 매개변수없어서()->
        int[] nums2 = IntStream.generate(()->1).limit(10).toArray();
        System.out.println(Arrays.toString(nums2));

        IntStream stm1 = IntStream.rangeClosed(1,50);
        IntStream stm2 = IntStream.rangeClosed(51,100);

        IntStream stm3 = IntStream.concat(stm1,stm2);
        int total = stm3.sum();
        System.out.println(total);
    }
}
