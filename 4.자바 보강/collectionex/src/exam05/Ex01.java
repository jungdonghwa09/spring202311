package exam05;

import java.util.Arrays;
import java.util.List;

public class Ex01 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("이름1", "이름2","이름3");
        //names.add("이름4");
        //<>안에 String을 쓴게 아니라 List클래스에는 이미 toString이 재정의됨
        System.out.println(names);
        System.out.println(names.toString());
        //System.out.println(Arrays.toString(names));//이거는 오류남

        int[] nums = new int[10];
        Arrays.fill(nums,1);

        String[] strs = new String[2];
        Arrays.fill(strs,"이이");

        System.out.println(nums);
        System.out.println(Arrays.toString(nums));

        //기본형의 객체인 strs라서.. strs.toString()은 그냥 strs만 한거나 똑가틍ㅁ
        //String클래스여도 배열객체라 배열객체만 출력하면 주소가 나와서, Arrays의 도움을 받아야 됨
        System.out.println(strs);
        System.out.println(Arrays.toString(strs));
        System.out.println(strs.toString());
    }
}
