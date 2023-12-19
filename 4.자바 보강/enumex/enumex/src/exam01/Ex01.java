package exam01;
import static exam01.Transportation.*;
public class Ex01 {
    public static void main(String[] args) {
        Transportation bus = BUS;
        System.out.println(BUS == Transportation.BUS);
        //oridinal()과 name()은 모든 enum class의 상위인 java.lang.Enum의 메서드이다
        System.out.printf("ordinal(): %d, name():%s%n", bus.ordinal(), bus.name());


    }
}
