package exam;

public class Ex01 {
    public static void main(String[] args) {
        C c = new C();
        //생성자는 메모리-힙에 객체를 만든다

        //A a = new B();
        //A는 new자식 또는 본인으로 생성할 수 있기 때문에 형변환시 체크필수
        //B b  =(B)a;//a가 b로 변할때는 생략안된다는 뜻이
        // instanceof로 체크를 해야 됨-a가 A를 가르키든지 B를 가리키든지 상관없이

        A a =c;
        //a는 꺼내도 C의 일부라는 뜻-다형성이 가능(참조변수의 다형성?)
        //이때는 instance of를 안해도 되고, 스몰 c가 바뀌는 것이므로,
        //참조변수 c는 이미만들어져있어야 됨 가장 하위클래스인 C타입의 c는
        //당연히 new C밖에 못만드니까 instanceof로 체크 안해도됨

        B b =c;

        A a1 = new D();
        if(a1 instanceof C){
            C c2 = (C) a1;
        }
        C c2 = new C();



    }
}
