package exam01;

public class Ex01 {
    public static void main(String[] args) {
        //Integer num1 = new Integer(10);
        //Integer num2 = new Integer(10);
        //false hash도 다름

        //Integer num1 = Integer.valueOf(10);
        //Integer num2 = Integer.valueOf(10);
        //이는 byte범위에서는 true, 그 이상의 숫자는 false가 나옴

        Integer num1 = Integer.valueOf(100000000);
        Integer num2 = Integer.valueOf(100000000);
        System.out.println(num1==num2);
        System.out.println("num1=" + System.identityHashCode(num1));
        System.out.println("num2=" + System.identityHashCode(num2));
        //long num2 = num1.longValue();

    }
}
