package exam02;

public class Ex01 {
    public static void main(String[] args) {
        Outer out = new Outer();
        //Outer의 메서드 반환값을 Calculator로 하면 외부에서도 접근가능,
        Calculator cal = out.method(30);
        int result = cal.add(10,20);
        System.out.println(result);


    }
}
