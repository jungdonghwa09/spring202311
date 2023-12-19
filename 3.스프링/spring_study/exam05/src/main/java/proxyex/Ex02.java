package proxyex;

public class Ex02 {
    public static void main(String[] args) {
        ProxyCalculator cal1 = new ProxyCalculator(new ImplCalculator());
        long result1 = cal1.factorial(10L);
        System.out.printf("cal1 : %d%n", result1);

        ProxyCalculator cal2 = new ProxyCalculator(new RecCalculator());
        //rec의 cal2로 rec의 factorial기능 수행
        long result2 = cal2.factorial(10L);
        System.out.printf("cal2 : %d%n", result2);

    }
}
