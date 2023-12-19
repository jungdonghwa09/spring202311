package proxyex;
//ProxyCalculator는 Calculator를 상속받았지만 Impl, Rec의 기능을 대신수행해주는것
//으로 다형성을 이용한다
public class ProxyCalculator implements Calculator{
    private Calculator calculator;//부모인 Calculator를 상속받은 impl, rec
    //아래는 생성자로, 생성자 매개변수에 Calculator(부모)를 넣고, 이 부모를 상속받은
    //impl, rec중 하나로 정해놓는 게 아니라(private에서) 생성자안에 매개변수로
    //부모인 인터페이스 Calculator타입을 통해 impl, rec타입의 factorial을 사용
    //할 수 있는 calculator를 private멤버변수에 대입하여, 밑에서 factorial을
    //호출시에 사용한다.
    public ProxyCalculator(Calculator calculator){
        this.calculator = calculator;
    }

    @Override
    public long factorial(long num) {
        long stime = System.nanoTime();//공통기능
        try {
            //부모인 Calculator차입의 calculator참조변수로, impl, rec의 오버라이딩한
            //factorial메서드를 쓸 수있음
            long result = calculator.factorial(num);//핵심기능

            return result;
        }finally{
            long etime = System.nanoTime();
            System.out.printf("걸린시간 : %d%n", etime-stime);
        }
    }
}
