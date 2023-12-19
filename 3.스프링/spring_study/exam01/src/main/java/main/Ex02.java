package main;
import models.Greeter;

import java.lang.reflect.Method;

public class Ex02 {
    public static void main(String[] args) {
        Class cls = Greeter.class;

        Method[] methods = cls.getMethods();
        for(Method method : methods){
            System.out.println(method);
        }

    }
}
