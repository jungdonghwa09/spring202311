package exam02;



public class Ex01 {
    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>();
        //new Box뒤에 <Apple>생략하고, <>해도 됨
        appleBox.setItem(new Apple());

        //Apple apple = appleBox.getItem();

        //<>안에 Apple타입 밖에 못들어오게 정해줌
        //T는 타입을 뜻하는 뜻 이게 지네릭 클래스

        Box<Pear> pearBox = new Box<>();
    }
}
