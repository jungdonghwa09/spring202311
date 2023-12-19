package exam05;

import java.util.Arrays;
import java.util.Comparator;

public class Ex05 {
    public static void main(String[] args) {
        Integer[] nums = {10,3,4,54,19,25};
        //Arrays.sort(nums);
        Arrays.sort(nums, Comparator.reverseOrder());
        System.out.println(Arrays.toString(nums));
        //Comparable의 오름으로 기본

    }
}
