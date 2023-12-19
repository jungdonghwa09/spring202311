package exam02;

import java.util.Arrays;
//Class cls = 클래스명.class, cls.으로 애노테이션명.class로
//get해올 수 있음 
@MyAnno2(nums={10,20,30,40})
public class Ex01 {
    public static void main(String[] args) {
        Class cls = Ex01.class;
        MyAnno2 anno = (MyAnno2) cls.getAnnotation(MyAnno2.class);
        String value = anno.value();
        System.out.printf("value=%s%n", value);

        int[] nums = anno.nums();
        System.out.println(Arrays.toString(nums));

    }
}
