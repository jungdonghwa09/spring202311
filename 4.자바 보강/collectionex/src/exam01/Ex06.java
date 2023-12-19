package exam01;

import java.util.*;

public class Ex06 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("이름1");
        names.add("이름2");
        names.add("이름3");
        names.add("이름4");
        names.add("이름5");

        ListIterator<String> iter = names.listIterator();
    //순방향
        while(iter.hasNext()){
        String name = iter.next();
        System.out.println(name);
    }

    //역방향
    while(iter.hasPrevious()){
        String name = iter.previous();
        System.out.println(name);
    }
    }
}
