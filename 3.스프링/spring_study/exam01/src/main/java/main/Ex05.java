package main;

public class Ex05 {
    public static void main(String[] args) {
        try {
            int num1 = 10;
            int num2 = 0;
            int result = num1 / num2;
        }catch(ArithmeticException e){
            e.printStackTrace();
            System.out.println("예외처리");
        }
        System.out.println("매우 중요한 코드");
//runtimeException임  실행은 되지만 중단될 수 있어 예외처리할 것

    }
}
