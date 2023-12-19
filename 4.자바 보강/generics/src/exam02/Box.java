package exam02;

public class Box<T extends Fruit> {
    private T item;
    //private static T item2; static엔 T안됨
    //private T[] item3 = new T[];
    //형변환 필요없음
    public T getItem(){
        return item;
    }
    public void setItem(T item){
        this.item = item;
    }
    //T가 타입 매개변수
    public void printItem(){
        item.print();
        //T가 Fruit으로 바뀜
    }
    //자료형이 명확해야 컴파일된다
    //컴파일시에는 입력한 T는 명확하지 않아 T가 Object로 바뀐다
    //T는 객체를 만드는 시점에 투입된 타입으로 형변환된다
    //printItem안에서 item.하면 print가 안나옴(사과, 배의 print),그냥 object로 바뀜

    public <T> void testMethod(T t){
        //제네릭메서드의 T-앞, 메서드가 호출될때타입결정


    }
}
