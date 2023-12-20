package exam04;

import java.util.Arrays;
import java.util.OptionalInt;

public class Ex03 {
    public static void main(String[] args) {
        int[] nums = {22,10,5,99,17};
        int min= Arrays.stream(nums).reduce(Integer.MAX_VALUE,
                (a,b) -> a > b ? b :a);
        System.out.println(min);

        OptionalInt opt = Arrays.stream(nums).reduce((acc,num)
                ->{
            System.out.printf("acc=%d, num=%d%n",acc,num);
           acc+=num;
           return acc;
        });
        int total = opt.getAsInt();
        System.out.println(total);
    }
}
