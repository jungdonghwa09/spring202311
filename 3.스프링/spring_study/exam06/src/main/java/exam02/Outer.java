package exam02;

public class Outer {//외부클래스
    Calculator method(int num3){//외부클래스의 메서드인데, 외부에서접근가능하게
        //반환타입-Calcultor
        return new Calculator(){//외부안의 익명 내부 클래스-그냥 리턴하고 끝, 바로리턴
          //아래는 인터페이스의 add함수 오버라이딩한거, 그걸 간단하게 내부 클래스로
            public int add(int num1, int num2){//내부클래스 메서드
                //num3=40;//지역변수는 상수화된다
              return num1+num2+num3;
          }
        };
        //int result = cal.add(10,20);
        //System.out.println(result);

    }
/*
    void method(){
        class Inner{
            void innerMethod(){
                System.out.println("지역 내부 클래스의 메서드");
            }

        }
        Inner in = new Inner();
        in.innerMethod();
    }
    */

}
