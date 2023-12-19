package exam01;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;

public class Ex05 {
    public static void main(String[] args) {
        //BiFunction<Integer,Integer,Integer> func = (a,b) -> a+b;
        //BinaryOperator<Integer> func = (a,b) -> a+b;
        IntBinaryOperator func = (a,b) -> a+b;
        int result = func.applyAsInt(10,20);
        //Integer인데, 이미int형인 10,20을 넣어서 굳이 (int)안해도 됨?
        System.out.println(result);

    }
}
