package exam04;

public class Ex02 {
    public static void main(String[] args) {
        Calculator cal = new Calculator(){

            @Override
            public int add(int num1, int num2) {
                return num1+num2;
            }
        };
        //생성과 동시에 재정의 할때 매개변수 달라도됨?
        int result = cal.add(10, 20);
        System.out.println(result);
    }
}
