package exam01;
@FunctionalInterface//람다식을 의도한 것
public interface Calculator {
    int square(int num);//추상메서드
    //함수형 인터페이스는 하나밖에 정의할 수 있다는 애노테이션
    //int root(int num);
}
