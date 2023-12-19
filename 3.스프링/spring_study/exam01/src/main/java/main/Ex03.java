package main;

import java.util.Arrays;

public class Ex03 {
    public static void main(String[] args) {
        int result = add(10,20,30,40);
        System.out.println(result);
    }
    public static int add(int num1, int num2){
        return num1+num2;
    }
    public static int add(int ...nums){
        /*System.out.println(Arrays.toString(nums));
        int total=0;
        for(int num : nums){
            total += total;
        }*/
        int total = Arrays.stream(nums).sum();
        return total;
    }
}
