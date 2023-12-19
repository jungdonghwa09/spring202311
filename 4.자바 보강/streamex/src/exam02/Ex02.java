package exam02;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class Ex02 {
    public static void main(String[] args) {
        int[] nums = {11,5,3,22,15,88,75};

        //Int형 스트림에서 일반스트림으로,,boxed
        //mapToInt는 일반에서 기본형스트림으로 다시,,int[] nums2가 기본형IntStream이어서

        //Stream<Integer> nums였으면 이건 일반스트림이다

        int[] nums2 = Arrays.stream(nums).boxed().sorted(Comparator.reverseOrder())
                .mapToInt(x -> x).toArray();
        //reverseOrder내림차순
        System.out.println(Arrays.toString(nums2));
    }
}
