package exam03;

import exam02.Fruit;

public class Juicier {
    public static void make(FruitBox<? extends Fruit> fruitBox){
        System.out.println(fruitBox.getItems());

    }
    public  static  <T> void make2(FruitBox<T> fruitBox){
        System.out.println(fruitBox.getItems());
    }
    //메서드 매개변수가 FruitBox appleBox, pearBox로 동일-메서드중복
    //public static void make(FruitBox<Pear> pearBox){

    //}
}
