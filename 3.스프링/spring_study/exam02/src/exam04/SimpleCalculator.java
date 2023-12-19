package exam04;

public class SimpleCalculator extends Calculator{

    @Override
    public int add(int num1, int num2) {
        return num1+num2;
    }
    public void name(){
        System.out.println("내이름은 포도");
    }
}
