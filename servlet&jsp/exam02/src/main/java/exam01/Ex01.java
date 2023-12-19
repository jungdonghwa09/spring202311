package exam01;

public class Ex01 {
    public static void main(String[] args) {
        schdule s1 = new schdule();
        //s1.year=2023;
        //s1.month=11;
        //s1.day=30;
        s1.setYear(2023);
        s1.setMonth(2);
        s1.setDay(31);

        //s1.showDate();
        System.out.println(s1);
    }
}
