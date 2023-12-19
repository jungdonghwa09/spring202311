package exam01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

public class Ex04 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("aa","bb","cc");
        List<String> result = map(words,s->s.toUpperCase());
        //map함수안 내부에서 apply메서드를 반복할 수 있음-map정의할 때 unary인터페이스를 넘겨줌
        //map(Function)은 stream의 기능-인터페이스의 apply추상메서드를 upper의 기능을 갖도록 함
        System.out.println(result);

    }
    public static List<String> map(List<String> words, UnaryOperator<String> oper){
        List<String> converted = new ArrayList<>();
        for(String word: words){
            String word2 = oper.apply(word);
            converted.add(word2);
        }
        return converted;
    }
}
