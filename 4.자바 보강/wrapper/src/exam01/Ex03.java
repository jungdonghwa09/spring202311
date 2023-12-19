package exam01;

public class Ex03 {
    public static void main(String[] args) {
        int num1=100;
        Integer num2 = new Integer(200);

        int num3= num1+num2;//num2.intValue()라고
        // 컴파일러에서 자동으로 추가-auto unboxing
        System.out.println(num3);
        Integer num4 = num3;  //Integer.valueof(num3)이 자동 추가
        //autoboxing
        //autoboxing, 언박싱-wrapper클래스
    }
}
