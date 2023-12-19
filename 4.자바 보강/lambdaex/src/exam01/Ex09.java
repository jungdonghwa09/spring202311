package exam01;

import java.util.function.IntPredicate;

public class Ex09 {
    public static void main(String[] args) {
        IntPredicate cond1 = x -> x>=10;
        IntPredicate cond2 = x -> x<=100;

        IntPredicate cond3 = cond1.and(cond2);//2개를 결함 10<=x<=100
        IntPredicate cond4 = cond2.negate();//x가 100초과 이거 1개가 끝

        System.out.println("cond3 : " +cond3.test(150));
        System.out.println("cond4 : " +cond4.test(150));

    }
}
