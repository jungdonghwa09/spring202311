package exam05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ex06 {
    public static void main(String[] args) {
        List<String> strs = new ArrayList<>();

        Collections.addAll(strs, "a", "b", "c","d");
        Collections.shuffle(strs);

        System.out.println(strs);

        System.out.println(Collections.max(strs));//정렬 후 가장 끝 요소가 max

        //여기서는 왜 그냥 배열내용이 나왔지?
    }
}
