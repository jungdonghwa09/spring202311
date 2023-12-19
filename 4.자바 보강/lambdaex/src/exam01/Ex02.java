package exam01;

import java.util.Arrays;

public class Ex02 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        int[] nums2 = Arrays.stream(nums).map(x -> x*x).toArray();
        System.out.println(Arrays.toString(nums2));
        //map이라는 함수 내부에서 밖에 안쓰이는 함수내용-제곱하기
        //함수내용으로 인터페이스의 추상메서드를 구분한다
        //근데 이건 스트림이라...
    }
}
