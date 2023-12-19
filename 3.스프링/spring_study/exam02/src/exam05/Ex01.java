package exam05;

public class Ex01 {
    public static void main(String[] args) {
        Calculator cal = new SimpleCalculator();
        int result = cal.add(10,20);
        System.out.println(result);
        //Calculator.num=20;
        //인터페이스의 num은 상수이고, 이는 인터페이스명으로 접근
        System.out.println(Calculator.num);
        int result2 = cal.minus(20,10);
        System.out.println(result2);
    }
}
