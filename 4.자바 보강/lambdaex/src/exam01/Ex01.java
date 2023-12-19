package exam01;

import java.util.Arrays;

public class Ex01 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        int[] nums2 = calc(nums, x -> x*x);
        //square함수이름도 필요없음, 가공할 square함수의 내용만 람다형태로
        //calc함수호출 시, 써주기만 하면 됨-어짜피 square 내용은
        // calc내부에서만 쓰일 거니까

        /* 1번째를 간단히 한 2번째 --함수 안에 익명 내부 클래스처럼
        int[] nums2 = calc(nums, new Calculator() {
            @Override
            public int square(int num) {
                return num * num;
            }
        });
        */

        /*  1번째 방식
        Calculator cal = new Calculator() {
            @Override
            public int square(int num) {
                return num * num;
            }//사용자 정의로 필요한식으로 정의하면 됨-추상메서드 정의
            //cal은 함수의 주소값을 갖고있음
        };
        int[] nums2 = calc(nums,cal);//cal을 변수처럼 안하고, 바로 넣기
        */
        System.out.println(Arrays.toString(nums2));
    }
    public static int[] calc(int[] nums, Calculator cal){
        int[] nums2 = new int[nums.length];
        //calc의 매개변수로 cal을 넣는이유는 cal의 square를 이용하려고,
        //매개변수 nums는 calc의 기능 수행 시 필요한 재료, 앞에서 1부터 10까지 정의

        for(int i=0; i< nums.length; i++){
            nums2[i] = cal.square(nums[i]);
        }//함수 calc내부에서 밖에 안쓰이는 square가 쓰임
        //square(int num)이 nums[i]가 됨
        return nums2;
    }//calc함수는 nums2를 반환하는 정수 배열 반환타입
}
