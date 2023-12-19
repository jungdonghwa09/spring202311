package exam03;

public class Ex02 {
    public static void main(String[] args) {
        Animal[] animals = new Animal[3];
        animals[0] = new Human();
        animals[1] = new Dog();
        animals[2] = new Bird();
        //부모타입의 배열을 만들면 다형성으로 다른 타입의 객체를 저장할 수 있음
        for(Animal animal : animals){
            animal.move();
            //배열 개수 만큼 move가 출력됨
            if(animal instanceof Human) {
                Human hh = (Human) animal;
                hh.readBook();
            }
        }
    }
}
