package exam01;

public class Ex03 {
    public static void main(String[] args) {
        Calculator cal = x -> x * x;
        //앞에 x는 매개변수가 1개라는 뜻
        //람다로 사용하고 싶은 메서드는 인터페이스에 하나만 두는게 좋음-
        //여러개 있을 경우 헷갈림-어떤걸 사용할지
        int result = cal.square(10);
        System.out.println(result);
            //Calculator인터페이스 매개변수 num과 이름 동일하게 적어야 됨?
            //그래야 int num인지 안다? 근데 내용이 다 다르니까 굳이
            //인터페이스에 여러 개 추상메서드가 있을때도 매개변수이름으로 구분?
            //인터페이스의 함수를 대부분 람다식으로 표현?

        }

    }

