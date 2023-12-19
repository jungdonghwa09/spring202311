package exam04;

public class Ex01 {
    public static void main(String[] args) {
        SimpleCalculator cal = new SimpleCalculator();
            int result= cal.add(10,20);
            System.out.println(result);
            
            //추상클래스(상위임)의 멤버변수 num에 접근하고자 Calculator타입으로
        //cal을 만듬
            //cal.num=100;
            System.out.println(cal.num);
            //이건 SimpleCalculator타입의 cal인데, cal.쳤을때
        // 상위Calculator의 num이 나오는 이유는 extends해서?

            //cal.name();-SimpleCalculator타입이라 내이름은 포도 라고 나옴
        //cal.했을때 Calculator타입이라 안나옴-
        // 이건 추상클래스인 Calculator의
        //참조변수인 cal과,(추상클래스도 객체생성 가능?-다형성) 그렇지만 뒤에는 new SimpleCalculator가 나옴



    }
}
