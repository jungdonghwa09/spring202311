package exam06;

public class Ex02 {
    public static void main(String[] args) {
        Enum<Transportation> trans = Transportation.SUBWAY;
        //이건 다형성이다 Enum클래스(Transportation)는
        // num<Transportation>(java.lang.enum)의 하위클래스이다
        int o = trans.ordinal();
        System.out.println(o);
        System.out.println(trans.name());

    }
}
