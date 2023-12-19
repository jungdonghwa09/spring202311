package exam05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Ex07 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("이름2");
        names.add("이름1");
        names.add("이름3");
        names.add("이름4");
        names.add("이름5");

        Collections.sort(names, Comparator.reverseOrder());//기본 오름차순-Comparable
        System.out.println(names);

    }
}
