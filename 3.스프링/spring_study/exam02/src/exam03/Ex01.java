package exam03;

public class Ex01 {
    public static void main(String[] args) {
        Animal h = new Human();
        h.move();

        Animal d = new Dog();
        d.move();

        Animal b = new Bird();
        b.move();
    }
}
