package exam03;

public class Human extends Animal{
    @Override
    public void move(){
        System.out.println("사람이 걸음");
    }
    public void readBook(){
        System.out.println("사람이니까 독서를 함");
    }
}
