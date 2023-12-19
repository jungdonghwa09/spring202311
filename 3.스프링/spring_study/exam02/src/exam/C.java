package exam;

public class C extends B{
    int numC=30;
    //클래스에는 기본적으로 클래스타입의 객체를 만들 수 있는
    //기본생성자 있음-생성자를 안만들어도 가능한 것
    public C(){
        super();//B생성자를 의미
        System.out.println("C생성자 역시 호출");
    }
}
