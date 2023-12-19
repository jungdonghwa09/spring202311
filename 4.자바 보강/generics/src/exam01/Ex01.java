package exam01;

public class Ex01 {
    public static void main(String[] args) {
        Box box = new Box();
        box.setItem(new Apple());//형변환의 번거로움
        //new Apple이라 if문 조건이 틀려서 실행 안됨
        Object obj = box.getItem();
        if(obj instanceof Pear){
            Pear pear = (Pear)box.getItem();
        }
        //Apple apple = (Apple)box.getItem();
        //box.setItem(new Apple());일 경우 아래와 같이 형변환 안정성 떨어짐
        //Pear pear = (Pear)box.getItem();
    }
}
